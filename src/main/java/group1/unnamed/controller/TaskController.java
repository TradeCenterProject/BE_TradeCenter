package group1.unnamed.controller;

import group1.unnamed.data.dto.*;
import group1.unnamed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GetTaskDTO> getTaskList() {

        return taskService.getTaskList(1);
    }

    @PostMapping(value = "")
    public List<GetTaskDTO> addTask(@RequestBody AddTaskStocksDTO addTaskStocksDTO) {
        taskService.addTask(1, addTaskStocksDTO);

        return taskService.getTaskList(1);
    }
}
