package group1.unnamed.service.impl;

import group1.unnamed.data.dto.*;
import group1.unnamed.data.entity.*;
import group1.unnamed.data.object.TaskProduct;
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
    ProductHandler productHandler;
    TaskProductHandler taskProductHandler;
    UserHandler userHandler;


    @Autowired
    public TaskServiceImpl(TaskHandler taskHandler, ProductHandler productHandler, TaskProductHandler taskProductHandler, UserHandler userHandler) {
        this.taskHandler = taskHandler;
        this.productHandler = productHandler;
        this.taskProductHandler = taskProductHandler;
        this.userHandler = userHandler;
    }

    @Override
    public List<GetTaskDTO> getTaskList(int userId) {

        List<TaskEntity> taskEntities = taskHandler.getTaskEntitiesByUserId(userId);

        List<GetTaskDTO> tasks = new ArrayList<>();

        for (int i=0; i<taskEntities.size(); i++) {
            TaskEntity taskEntity = taskEntities.get(i);

            UserInfo admin = new UserInfo(taskEntity.getBossEntity().getId(), taskEntity.getBossEntity().getUserName());
            UserInfo staff = new UserInfo(taskEntity.getEmployeeEntity().getId(), taskEntity.getEmployeeEntity().getUserName());

            GetTaskDTO task = new GetTaskDTO(taskEntity.getId(), admin, staff, taskEntity.getTaskCode(), taskEntity.getType(), taskEntity.getTitle(), taskEntity.getDate(), taskEntity.isDone());

            tasks.add(task);
        }
        return tasks;
    }

    @Override
    public AddTaskProductsDTO addTask(int userId, AddTaskProductsDTO addTaskProductsDTO) {
        AddTaskDTO addTaskDTO = addTaskProductsDTO.getTask();
        List<TaskProduct> products = addTaskProductsDTO.getProducts();

        UserEntity userEntity = userHandler.getUserEntity(userId);
        CompanyEntity companyEntity = userEntity.getCompanyEntity();

        UserEntity staffEntity = userHandler.getUserEntity(addTaskDTO.getEmployeeId());

        String dateCode = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        String typeCode;
        String type = addTaskDTO.getTaskType();
        if (type.equals("입고")) typeCode = "RCV";
        else if (type.equals("출고")) typeCode = "FWD";
        else typeCode = "ETC";

        String numberCode;
        int numberOfTask = taskHandler.countTaskEntitiesByDateAndType(LocalDate.now().toString(), type) + 1;
        if (numberOfTask<10) numberCode = "00" + numberOfTask;
        else if (numberOfTask<100) numberCode = "0" + numberOfTask;
        else numberCode = Integer.toString(numberOfTask);

        String code = dateCode + typeCode + numberCode;

        TaskEntity taskEntity = new TaskEntity(companyEntity, userEntity, staffEntity, code, addTaskDTO.getTaskType(), addTaskDTO.getTitle(), LocalDate.now().toString(), false);

        taskHandler.addTaskEntity(taskEntity);

        List<TaskProductEntity> taskProductEntities = new ArrayList<>();

        for (int i=0; i<products.size(); i++) {
            TaskProduct product = products.get(i);
            ProductEntity productEntity = productHandler.getProductEntity(product.getId());

            TaskProductEntity taskProductEntity = new TaskProductEntity(taskEntity, productEntity, products.get(i).getQuantity());

            taskProductEntities.add(taskProductEntity);
        }

        taskProductHandler.addTaskProductEntities(taskProductEntities);

        return addTaskProductsDTO;
    }
}
