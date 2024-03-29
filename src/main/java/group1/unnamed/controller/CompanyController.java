package group1.unnamed.controller;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins= "http://localhost:3000", allowedHeaders = "*")
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "")
    public CompanyDTO getCompanyInformation() {
        return companyService.getCompanyInformation(1);
    }

}
