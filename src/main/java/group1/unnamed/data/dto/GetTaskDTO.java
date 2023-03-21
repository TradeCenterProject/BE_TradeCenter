package group1.unnamed.data.dto;

import group1.unnamed.data.object.UserInfo;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class GetTaskDTO {

    private int id;
    private UserInfo boss;
    private UserInfo employee;
    private String taskCode;
    private String taskType;
    private String title;
    private String date;
    private boolean isDone;

}
