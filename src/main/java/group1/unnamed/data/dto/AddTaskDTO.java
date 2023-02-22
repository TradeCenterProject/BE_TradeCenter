package group1.unnamed.data.dto;

import group1.unnamed.data.object.TaskStock;
import group1.unnamed.data.object.UserInfo;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddTaskDTO {

    private TaskDTO task;
    private List<TaskStock> stocks;

}
