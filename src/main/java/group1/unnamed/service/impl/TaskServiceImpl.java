package group1.unnamed.service.impl;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.*;
import group1.unnamed.data.object.TaskStock;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.handler.*;
import group1.unnamed.service.StockService;
import group1.unnamed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    TaskHandler taskHandler;
    StockHandler stockHandler;
    TaskStockHandler taskStockHandler;
    UserHandler userHandler;


    @Autowired
    public TaskServiceImpl(TaskHandler taskHandler, StockHandler stockHandler, TaskStockHandler taskStockHandler, UserHandler userHandler) {
        this.taskHandler = taskHandler;
        this.stockHandler = stockHandler;
        this.taskStockHandler = taskStockHandler;
        this.userHandler = userHandler;
    }

    @Override
    public TaskListDTO getTaskList(int userId) {

        List<TaskEntity> taskEntities = taskHandler.getTaskEntitiesByUserId(userId);

        List<TaskDTO> tasks = new ArrayList<>();

        for (int i=0; i<taskEntities.size(); i++) {
            TaskEntity taskEntity = taskEntities.get(i);

            UserInfo admin = new UserInfo(taskEntity.getAdminEntity().getId(), taskEntity.getAdminEntity().getName());
            UserInfo staff = new UserInfo(taskEntity.getStaffEntity().getId(), taskEntity.getStaffEntity().getName());

            TaskDTO taskDTO = new TaskDTO(taskEntity.getId(), admin, staff, taskEntity.getCode(), taskEntity.getType(), taskEntity.getTitle(), taskEntity.getDate(), taskEntity.isDone());

            tasks.add(taskDTO);
        }

        return new TaskListDTO(tasks);
    }

    @Override
    public AddTaskDTO addTask(int userId, AddTaskDTO addTaskDTO) {
        TaskDTO taskDTO = addTaskDTO.getTask();
        List<TaskStock> stocks = addTaskDTO.getStocks();

        UserEntity userEntity = userHandler.getUserEntity(userId);
        CompanyEntity companyEntity = userEntity.getCompanyEntity();

        UserEntity adminEntity = userHandler.getUserEntity(taskDTO.getAdmin().getId());

        TaskEntity taskEntity = new TaskEntity(companyEntity, adminEntity, userEntity, taskDTO.getCode(), taskDTO.getType(), taskDTO.getTitle(), taskDTO.getDate(), taskDTO.isDone());

        taskHandler.addTaskEntity(taskEntity);

        List<TaskStockEntity> taskStockEntities = new ArrayList<>();

        for (int i=0; i<stocks.size(); i++) {
            TaskStock stock = stocks.get(i);
            StockEntity stockEntity = stockHandler.getStockEntity(stock.getId());

            TaskStockEntity taskStockEntity = new TaskStockEntity(taskEntity, stockEntity, stocks.get(i).getAmount());

            taskStockEntities.add(taskStockEntity);
        }

        taskStockHandler.addTaskStockEntities(taskStockEntities);

        return addTaskDTO;
    }
}
