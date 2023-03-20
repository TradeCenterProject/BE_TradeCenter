package group1.unnamed.handler.impl;

import group1.unnamed.data.dao.TaskProductDAO;
import group1.unnamed.data.entity.TaskProductEntity;
import group1.unnamed.handler.TaskProductHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskProductHandlerImpl implements TaskProductHandler {

    TaskProductDAO taskProductDAO;

    @Autowired
    public TaskProductHandlerImpl(TaskProductDAO taskProductDAO) {
        this.taskProductDAO = taskProductDAO;
    }

    @Override
    public List<TaskProductEntity> getTaskProductEntitiesByTaskId(int taskId) {
        return taskProductDAO.getTaskProductsByTaskId(taskId);
    }

    @Override
    public List<TaskProductEntity> addTaskProductEntities(List<TaskProductEntity> taskProductEntities) {
        return taskProductDAO.addTaskProducts(taskProductEntities);
    }
}
