package group1.unnamed.data.dao;

import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.entity.TaskEntity;

import java.util.List;

public interface TaskDAO {

    List<TaskEntity> getTasksByUserId(int userId);

    TaskEntity addTask(TaskEntity taskEntity);
}
