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
    private String name;
    private String email;
    private String password;
    private String salt;
    private Boolean isAdmin;

    public UserEntity(CompanyEntity companyEntity, String name, String email, String password, String salt, Boolean isAdmin) {
        this.companyEntity = companyEntity;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isAdmin = isAdmin;
    }

    public UserEntity(String name, String email, String password, String salt, Boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isAdmin = isAdmin;
    }
}
