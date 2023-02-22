package group1.unnamed.data.dto;

import group1.unnamed.data.entity.StockEntity;
import group1.unnamed.data.entity.TaskEntity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaskListDTO {

    private List<TaskDTO> tasks;
}
