package group1.unnamed.controller;

import group1.unnamed.data.dto.CompanyDTO;
import group1.unnamed.data.dto.StockDTO;
import group1.unnamed.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins= "*", allowedHeaders = "*")
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
