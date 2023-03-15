package group1.unnamed.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LoginDTO {
    private String email;
    private String password;

}
