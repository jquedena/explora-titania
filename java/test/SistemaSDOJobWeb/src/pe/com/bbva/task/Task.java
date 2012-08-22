package pe.com.bbva.task;

import org.apache.log4j.Logger;

public class Task implements ITask{

    private static Logger log = Logger.getLogger(Task.class);
    private ITask task;

    public ITask getExecute() {
        return task;
    }

    public void setExecute(ITask execute) {
        this.task = execute;

    }
    
    public void executeTask() {
        log.info("[Task::executeTask] Iniciando");
        task.executeTask();
        log.info("[Task::executeTask] Terminado");
    }
}
