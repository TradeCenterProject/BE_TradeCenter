package group1.unnamed.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
