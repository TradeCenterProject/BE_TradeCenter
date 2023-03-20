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
    private String companyName;
    private String companyCode;
    private String phoneNumber;
    private String registeredDate;

    public CompanyEntity(String companyName, String companyCode, String registeredDate) {
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.registeredDate = registeredDate;
    }
}
