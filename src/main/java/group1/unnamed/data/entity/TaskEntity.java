package group1.unnamed.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity companyEntity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "boss_id", referencedColumnName = "id")
    private UserEntity bossEntity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private UserEntity employeeEntity;
    private String taskCode;
    private String type;
    private String title;
    private String date;
    private boolean isDone;

    public TaskEntity(CompanyEntity companyEntity, UserEntity bossEntity, UserEntity employeeEntity, String taskCode, String type, String title, String date, boolean isDone) {
        this.companyEntity = companyEntity;
        this.bossEntity = bossEntity;
        this.employeeEntity = employeeEntity;
        this.taskCode = taskCode;
        this.type = type;
        this.title = title;
        this.date = date;
        this.isDone = isDone;
    }
}
