package pe.com.bbva.job;

import pe.com.bbva.task.ITask;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ExecuteJob extends QuartzJobBean {

    private ITask runTask;

    public void setRunTask(ITask runTask) {
        this.runTask = runTask;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        runTask.executeTask();
    }
}