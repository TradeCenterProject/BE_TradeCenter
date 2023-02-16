package group1.unnamed.data.dto;

import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.entity.StockEntity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StockDTO {
    private String code;
    private String name;
    private String producer;
    private String location;
    private int price;
    private int amount;

}
