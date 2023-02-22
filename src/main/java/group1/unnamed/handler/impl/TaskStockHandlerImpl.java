package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.dao.TaskStockDAO;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.TaskStockEntity;
import group1.unnamed.handler.TaskHandler;
import group1.unnamed.handler.TaskStockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskStockHandlerImpl implements TaskStockHandler {

    TaskStockDAO taskStockDAO;

    @Autowired
    public TaskStockHandlerImpl(TaskStockDAO taskStockDAO) {
        this.taskStockDAO = taskStockDAO;
    }

    @Override
    public List<TaskStockEntity> getTaskStockEntitiesByTaskId(int taskId) {
        return taskStockDAO.getTaskStocksByTaskId(taskId);
    }

    @Override
    public List<TaskStockEntity> addTaskStockEntities(List<TaskStockEntity> taskStockEntities) {
        return taskStockDAO.addTaskStocks(taskStockEntities);
    }
}
