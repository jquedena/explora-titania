package com.everis.pe.bbva.core.jsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.indra.pe.bbva.core.configuracion.WebServletContextListener;

public class OpenSessionInViewPhaseListener implements PhaseListener {
	
	private static final long serialVersionUID = 3742147752036645123L;
	private static final Logger logger = LoggerFactory.getLogger(OpenSessionInViewPhaseListener.class);
	private ThreadLocal<TransactionStatus> SYNCED_TRANSACTION_STATUS = new ThreadLocal<TransactionStatus>();
	private PlatformTransactionManager transactionManager;
	private SessionFactory sessionFactory;
	
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	/**
	 * This method will create a new transaction if none is active. If the JSF
	 * cycle is in a RENDER_RESPONSE phase, the transaction will be read-only.
	 * 
	 * @param phaseId
	 *            The JSF lifecycle phase.
	 */
	private void beginTransactionIfNoneActive(PhaseId phaseId) {
		try {
			if (!TransactionSynchronizationManager.isActualTransactionActive()) {

				boolean readOnlyTransaction = phaseId == PhaseId.RENDER_RESPONSE;

				logger.info("Beginin a new " + (readOnlyTransaction ? "read-only" : "write") + " Transaction.  Phase: " + phaseId);

				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
				def.setReadOnly(readOnlyTransaction);
				
				TransactionSynchronizationManager.bindResource(getSessionFactory(), new SessionHolder(getSessionFactory().openSession()));
				SYNCED_TRANSACTION_STATUS.set(transactionManager.getTransaction(def));
			} else {
				logger.info("A Transaction is already active. Before phase" + phaseId);
			}

		} catch (TransactionException e) {
			throw e;
		}
	}

	/**
	 * This method will commit or rollback the current transaction, depending on
	 * its state. If an exception is thrown, it will be swallowed.
	 * 
	 * @param phaseId
	 *            The phase ID in which this is taking place.
	 */
	void commitOrRollbackActiveTransaction(PhaseId phaseId) {
	
			TransactionStatus status = SYNCED_TRANSACTION_STATUS.get();
			if(status!=null)
			{
				try {
				if (!status.isCompleted() && !status.isRollbackOnly() && !TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
					logger.info("Committing transaction. phase: " + phaseId);
					transactionManager.commit(status);
				} else if (status.isRollbackOnly() || TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
					logger.info("rolling back transaction after phase: " + phaseId);
					transactionManager.rollback(status);
				}
				} catch (TransactionException e) {
					throw e;
				} finally {
					TransactionSynchronizationManager.unbindResource(getSessionFactory());
				}
			}	
	}

	public void beforePhase(PhaseEvent event) {

		PhaseId phaseId = event.getPhaseId();
		logger.info("Before phase: " + phaseId);

		try {			
			if (phaseId == PhaseId.RESTORE_VIEW || phaseId == PhaseId.RENDER_RESPONSE) {
				beginTransactionIfNoneActive(phaseId);
			}
		} catch (Exception e) {
			logger.error("Exception thrown before phase:" + event.getPhaseId(), e);
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	/**
	 * This method will invoke a transaction commit or rollback in the phase
	 * INVOKE_APPLICATION or RENDER_RESPONSE is finished or if there was an
	 * error rendering the view.
	 */
	public void afterPhase(PhaseEvent event) {
		logger.info("After phase: " + event.getPhaseId());

		if (event.getPhaseId() == PhaseId.INVOKE_APPLICATION || event.getFacesContext().getRenderResponse()
				|| event.getFacesContext().getResponseComplete() || (event.getPhaseId() == PhaseId.RENDER_RESPONSE))

			commitOrRollbackActiveTransaction(event.getPhaseId());		
	}

	public SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = (SessionFactory) WebServletContextListener.getApplicationContext().getBean("sessionFactoryReauni");;
		}
		return sessionFactory;
	}
}
