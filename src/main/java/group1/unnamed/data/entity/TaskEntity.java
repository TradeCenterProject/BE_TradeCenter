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
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private UserEntity adminEntity;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private UserEntity staffEntity;
    private String code;
    private String type;
    private String title;
    private String date;
    private boolean isDone;

    public TaskEntity(CompanyEntity companyEntity, UserEntity adminEntity, UserEntity staffEntity, String code, String type, String title, String date, boolean isDone) {
        this.companyEntity = companyEntity;
        this.adminEntity = adminEntity;
        this.staffEntity = staffEntity;
        this.code = code;
        this.type = type;
        this.title = title;
        this.date = date;
        this.isDone = isDone;
    }
}
