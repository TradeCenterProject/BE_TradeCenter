package group1.unnamed.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.UserEntity;
import group1.unnamed.data.object.UserInfo;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaskDTO {

    private int id;
    private UserInfo admin;
    private UserInfo staff;
    private String code;
    private String type;
    private String title;
    private String date;
    private boolean isDone;

}
