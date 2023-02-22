package group1.unnamed.handler;

import group1.unnamed.data.entity.TaskEntity;
import group1.unnamed.data.entity.TaskStockEntity;

import java.util.List;

public interface TaskStockHandler {

    List<TaskStockEntity> getTaskStockEntitiesByTaskId(int taskId);

    List<TaskStockEntity> addTaskStockEntities(List<TaskStockEntity> taskStockEntities);
}
