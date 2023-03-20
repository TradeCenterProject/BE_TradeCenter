package group1.unnamed.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDTO {
    private int id;
    private String productCode;
    private String productName;
    private String productCompany;
    private String productCategory;
    private String location;
    private int price;
    private int quantity;

}
