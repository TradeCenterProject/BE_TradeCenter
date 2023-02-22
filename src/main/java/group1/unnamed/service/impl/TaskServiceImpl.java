package group1.unnamed.service.impl;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.*;
import group1.unnamed.data.object.TaskStock;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.handler.*;
import group1.unnamed.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public List<GetTaskDTO> getTaskList(int userId) {

        List<TaskEntity> taskEntities = taskHandler.getTaskEntitiesByUserId(userId);

        List<GetTaskDTO> tasks = new ArrayList<>();

        for (int i=0; i<taskEntities.size(); i++) {
            TaskEntity taskEntity = taskEntities.get(i);

            UserInfo admin = new UserInfo(taskEntity.getAdminEntity().getId(), taskEntity.getAdminEntity().getName());
            UserInfo staff = new UserInfo(taskEntity.getStaffEntity().getId(), taskEntity.getStaffEntity().getName());

            GetTaskDTO task = new GetTaskDTO(taskEntity.getId(), admin, staff, taskEntity.getCode(), taskEntity.getType(), taskEntity.getTitle(), taskEntity.getDate(), taskEntity.isDone());

            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public AddTaskStocksDTO addTask(int userId, AddTaskStocksDTO addTaskStocksDTO) {
        AddTaskDTO addTaskDTO = addTaskStocksDTO.getTask();
        List<TaskStock> stocks = addTaskStocksDTO.getStocks();

        UserEntity userEntity = userHandler.getUserEntity(userId);
        CompanyEntity companyEntity = userEntity.getCompanyEntity();

        UserEntity staffEntity = userHandler.getUserEntity(addTaskDTO.getStaffId());

        String dateCode = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String typeCode;
        String type = addTaskDTO.getType();
        if (type.equals("입고")) typeCode = "RCV";
        else if (type.equals("출고")) typeCode = "FWD";
        else typeCode = "ETC";

        String numberCode;
        int numberOfTask = taskHandler.countTaskEntitiesByDateAndType(LocalDate.now().toString(), type) + 1;
        if (numberOfTask<10) numberCode = "00" + numberOfTask;
        else if (numberOfTask<100) numberCode = "0" + numberOfTask;
        else numberCode = Integer.toString(numberOfTask);

        String code = dateCode + typeCode + numberCode;

        TaskEntity taskEntity = new TaskEntity(companyEntity, userEntity, staffEntity, code, addTaskDTO.getType(), addTaskDTO.getTitle(), LocalDate.now().toString(), false);

        taskHandler.addTaskEntity(taskEntity);

        List<TaskStockEntity> taskStockEntities = new ArrayList<>();

        for (int i=0; i<stocks.size(); i++) {
            TaskStock stock = stocks.get(i);
            StockEntity stockEntity = stockHandler.getStockEntity(stock.getId());

            TaskStockEntity taskStockEntity = new TaskStockEntity(taskEntity, stockEntity, stocks.get(i).getAmount());

            taskStockEntities.add(taskStockEntity);
        }

        taskStockHandler.addTaskStockEntities(taskStockEntities);

        return addTaskStocksDTO;
    }
}
