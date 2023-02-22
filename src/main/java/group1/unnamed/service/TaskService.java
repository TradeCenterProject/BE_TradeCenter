package group1.unnamed.service;

import group1.unnamed.data.dto.*;

public interface TaskService {

    TaskListDTO getTaskList(int userId);

    AddTaskDTO addTask(int userId, AddTaskDTO addTaskDTO);

}
