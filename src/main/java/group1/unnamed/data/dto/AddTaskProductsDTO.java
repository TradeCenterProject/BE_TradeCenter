package group1.unnamed.data.dto;

import group1.unnamed.data.object.TaskProduct;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddTaskProductsDTO {

    private AddTaskDTO task;
    private List<TaskProduct> products;

}
