package group1.unnamed.handler;

import group1.unnamed.data.entity.TaskProductEntity;

import java.util.List;

public interface TaskProductHandler {

    List<TaskProductEntity> getTaskProductEntitiesByTaskId(int taskId);

    List<TaskProductEntity> addTaskProductEntities(List<TaskProductEntity> taskProductEntities);
}
