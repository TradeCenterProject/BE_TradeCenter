package group1.unnamed.data.object;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaskStock {

    private int id;
    private int amount;
}
