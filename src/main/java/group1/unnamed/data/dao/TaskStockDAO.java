package group1.unnamed.data.dao;

import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.TaskStockEntity;

import java.util.List;

public interface TaskStockDAO {

    List<TaskStockEntity> getTaskStocksByTaskId(int taskId);

    List<TaskStockEntity> addTaskStocks(List<TaskStockEntity> taskStockEntities);
}
