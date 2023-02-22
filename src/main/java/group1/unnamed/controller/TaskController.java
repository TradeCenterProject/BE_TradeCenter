package group1.unnamed.controller;

import group1.unnamed.data.dto.*;
import group1.unnamed.service.StockService;
import group1.unnamed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "")
    public TaskListDTO getTaskList() {

        return taskService.getTaskList(1);
    }

    @PostMapping(value = "")
    public TaskListDTO addTask(@RequestBody AddTaskDTO addTaskDTO) {
        taskService.addTask(1, addTaskDTO);

        return taskService.getTaskList(1);
    }
}
