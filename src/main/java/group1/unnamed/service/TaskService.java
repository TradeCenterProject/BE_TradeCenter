package group1.unnamed.service;

import group1.unnamed.data.dto.*;

import java.util.List;

public interface TaskService {

    List<GetTaskDTO> getTaskList(int userId);

    AddTaskProductsDTO addTask(int userId, AddTaskProductsDTO addTaskProductsDTO);

}
