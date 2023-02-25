package group1.unnamed.controller;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.data.dto.SignUpDTO;
import group1.unnamed.data.entity.CompanyEntity;
import group1.unnamed.data.object.UserInfo;
import group1.unnamed.service.CompanyService;
import group1.unnamed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "")
    public CompanyEntity signUp(@RequestBody CompanyDTO companyDTO) {

        return companyService.addCompany(companyDTO);
    }
}
