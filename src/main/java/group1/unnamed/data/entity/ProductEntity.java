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
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity companyEntity;
    private String productCode;
    private String productName;
    private String productCompany;
    private String productCategory;
    private String location;
    private int price;
    private int quantity;

    public ProductEntity(CompanyEntity companyEntity, String productCode, String productName, String productCompany, String productCategory, String location, int price, int quantity) {
        this.companyEntity = companyEntity;
        this.productCode = productCode;
        this.productName = productName;
        this.productCompany = productCompany;
        this.productCategory = productCategory;
        this.location = location;
        this.price = price;
        this.quantity = quantity;
    }
}
