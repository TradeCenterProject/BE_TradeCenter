package group1.unnamed.data.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity companyEntity;
    private String userName;
    private String email;
    private String password;
    private String salt;
    private String phoneNumber;
    private String accountNumber;
    private Boolean isBoss;
    private String joinedDate;

    public UserEntity(CompanyEntity companyEntity, String userName, String email, String password, String salt, Boolean isBoss) {
        this.companyEntity = companyEntity;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isBoss = isBoss;
    }

    public UserEntity(String userName, String email, String password, String salt, Boolean isBoss) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isBoss = isBoss;
    }
}
