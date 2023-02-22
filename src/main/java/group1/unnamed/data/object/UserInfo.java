package group1.unnamed.data.object;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfo {

    private int id;
    private String name;
}
