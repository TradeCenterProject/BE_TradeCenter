package group1.unnamed.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CompanyDTO {
    private String companyCode;
    private String companyName;
    private String phoneNumber;
    private String registeredDate;

}
