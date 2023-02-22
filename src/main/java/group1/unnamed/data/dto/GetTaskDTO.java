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
    private UserInfo admin;
    private UserInfo staff;
    private String code;
    private String type;
    private String title;
    private String date;
    private boolean isDone;

}
