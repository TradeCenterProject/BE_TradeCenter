package group1.unnamed.data.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stocks")
public class StockEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity companyEntity;
    private String code;
    private String name;
    private String producer;
    private String location;
    private int price;
    private int amount;

    public StockEntity(CompanyEntity companyEntity, String code, String name, String producer, String location, int price, int amount) {
        this.companyEntity = companyEntity;
        this.code = code;
        this.name = name;
        this.producer = producer;
        this.location = location;
        this.price = price;
        this.amount = amount;
    }
}
