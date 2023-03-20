package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.TaskProductDAO;
import group1.unnamed.data.entity.TaskProductEntity;
import group1.unnamed.data.repository.TaskProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskProductDAOImpl implements TaskProductDAO {

    TaskProductRepository taskProductRepository;

    @Autowired
    public TaskProductDAOImpl(TaskProductRepository taskProductRepository) {
        this.taskProductRepository = taskProductRepository;
    }


    @Override
    public List<TaskProductEntity> getTaskProductsByTaskId(int taskId) {
        return taskProductRepository.findAllByTaskEntity_Id(taskId);
    }

    @Override
    public List<TaskProductEntity> addTaskProducts(List<TaskProductEntity> taskProductEntities) {
        return taskProductRepository.saveAll(taskProductEntities);
    }
}
