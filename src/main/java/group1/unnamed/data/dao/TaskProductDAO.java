package group1.unnamed.data.dao;

import group1.unnamed.data.entity.TaskProductEntity;

import java.util.List;

public interface TaskProductDAO {

    List<TaskProductEntity> getTaskProductsByTaskId(int taskId);

    List<TaskProductEntity> addTaskProducts(List<TaskProductEntity> taskProductEntities);
}
