package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.dao.TaskStockDAO;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.TaskStockEntity;
import group1.unnamed.data.repository.TaskRepository;
import group1.unnamed.data.repository.TaskStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStockDAOImpl implements TaskStockDAO {

    TaskStockRepository taskStockRepository;

    @Autowired
    public TaskStockDAOImpl(TaskStockRepository taskStockRepository) {
        this.taskStockRepository = taskStockRepository;
    }


    @Override
    public List<TaskStockEntity> getTaskStocksByTaskId(int taskId) {
        return taskStockRepository.findAllByTaskEntity_Id(taskId);
    }

    @Override
    public List<TaskStockEntity> addTaskStocks(List<TaskStockEntity> taskStockEntities) {
        return taskStockRepository.saveAll(taskStockEntities);
    }
}
