package group1.unnamed.data.dto;

import group1.unnamed.data.object.TaskStock;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddTaskStocksDTO {

    private AddTaskDTO task;
    private List<TaskStock> stocks;

}
