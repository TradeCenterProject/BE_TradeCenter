package group1.unnamed.controller;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.exception.CustomException;
import group1.unnamed.exception.ExceptionConstants;
import group1.unnamed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins= "http://localhost:3000", allowedHeaders = "*")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "")
    public List<GetTaskDTO> getTaskList(HttpServletRequest request) throws CustomException {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "INVALID SESSION");
        }

        UserEntity userEntity = (UserEntity) session.getAttribute("signIn");

        return taskService.getTaskList(userEntity.getId());
    }

    @PostMapping(value = "")
    public List<GetTaskDTO> addTask(@RequestBody AddTaskProductsDTO addTaskProductsDTO, HttpServletRequest request) throws CustomException {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new CustomException(ExceptionConstants.ExceptionClass.USER, HttpStatus.UNAUTHORIZED, "INVALID SESSION");
        }

        UserEntity userEntity = (UserEntity) session.getAttribute("signIn");

        taskService.addTask(userEntity.getId(), addTaskProductsDTO);

        return taskService.getTaskList(userEntity.getId());
    }
}
