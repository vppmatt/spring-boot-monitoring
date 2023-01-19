package com.multicode.payments.control;

import com.multicode.payments.service.CCUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/country")
public class CountriesController {

    @Autowired
    private CCUtilsService ccUtilsService;

    @GetMapping()
    public List<String> getAllCountries() {
        return ccUtilsService.getCountries();
    }
}
