package group1.unnamed.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SignUpDTO {
    private String email;
    private String password;
    private String userName;
    private String companyCode;
    private String companyName;

}
