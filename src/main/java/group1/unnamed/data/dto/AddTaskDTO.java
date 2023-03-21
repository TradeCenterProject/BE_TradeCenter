package group1.unnamed.data.dto;

import group1.unnamed.data.object.UserInfo;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AddTaskDTO {

    private int employeeId;
    private String taskType;
    private String title;

}
