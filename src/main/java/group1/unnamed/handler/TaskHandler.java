package group1.unnamed.handler;

import group1.unnamed.data.entity.TaskEntity;

import java.util.List;

public interface TaskHandler {

    List<TaskEntity> getTaskEntitiesByUserId(int userId);
    TaskEntity addTaskEntity(TaskEntity taskEntity);
    int countTaskEntitiesByDateAndType(String date, String type);
}
