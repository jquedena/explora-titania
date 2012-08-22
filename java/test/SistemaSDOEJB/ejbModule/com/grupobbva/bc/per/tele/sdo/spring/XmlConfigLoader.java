package com.grupobbva.bc.per.tele.sdo.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Clase Singleton usada para la carga de los beans de Spring esto se hace por
 * medio de la clase ClassPathXmlApplicationContext
 * 
 * @see org.springframework.context.support.ClassPathXmlApplicationContext
 * 
 * @author
 * 
 */
public final class XmlConfigLoader
{

    private static XmlConfigLoader configLoader;

    private BeanFactory factory;

    private XmlConfigLoader()
    {
        // Carga de la configuracion de los beans
        // Revisar si se puede usar una expresion regular para realizar la carga
        // la expresion podria ser como pe/com/bcp/token/config/xml/*.xml o en
        // todo
        // caso usar otro Factory que realize la carga.
        String[] configXmls = { "com/grupobbva/bc/per/tele/sdo/spring/config/applicationContext-jdbc.xml" };
        // Creacion del factory
        factory = new ClassPathXmlApplicationContext(configXmls);
    }

    /**
     * Implementacion del singleton
     * 
     * @return Clase se instancia unica
     */
    public static synchronized XmlConfigLoader getInstance()
    {

        if (configLoader == null)
        {
            configLoader = new XmlConfigLoader();
        }
        return configLoader;
    }

    /**
     * Obtiene un bean del factory creado
     * 
     * @param name
     * @return
     */
    public Object getBean(String name)
    {
        return factory.getBean(name);
    }

}

