package group1.unnamed.data.dto;

import group1.unnamed.data.entity.StockEntity;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StockListDTO {

    private List<StockEntity> stocks;
}
