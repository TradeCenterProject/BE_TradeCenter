package group1.unnamed.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String code;
    private String phoneNumber;
    private String registeredDate;

    public CompanyEntity(String name, String code, String registeredDate) {
        this.name = name;
        this.code = code;
        this.registeredDate = registeredDate;
    }
}
