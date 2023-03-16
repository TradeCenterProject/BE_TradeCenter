package group1.unnamed.data.dao.impl;

import group1.unnamed.data.dao.TaskDAO;
import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDAOImpl implements TaskDAO {

    TaskRepository taskRepository;

    @Autowired
    public TaskDAOImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskEntity> getTasksByUserId(int userId) {
        return taskRepository.findAllByBossEntity_IdOrEmployeeEntity_Id(userId, userId);
    }

    @Override
    public TaskEntity addTask(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

    @Override
    public int countTaskByDateAndType(String date, String type) {
        return taskRepository.countAllByDateAndType(date, type);
    }
}
