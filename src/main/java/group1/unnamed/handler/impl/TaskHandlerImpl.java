package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.StockDAO;
import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.handler.StockHandler;
import group1.unnamed.handler.TaskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskHandlerImpl implements TaskHandler {

    TaskDAO taskDAO;

    @Autowired
    public TaskHandlerImpl(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<TaskEntity> getTaskEntitiesByUserId(int userId) {
        return taskDAO.getTasksByUserId(userId);
    }

    @Override
    public TaskEntity addTaskEntity(TaskEntity taskEntity) {
        return taskDAO.addTask(taskEntity);
    }

    @Override
    public int countTaskEntitiesByDateAndType(String date, String type) {
        return taskDAO.countTaskByDateAndType(date, type);
    }
}
