package com.techlabs.mybank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.mybank.Model.ApplicationStatus;
import com.techlabs.mybank.Service.ApplicationStatusService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusService applicationStatusService;

    @GetMapping("/application-status")
    public List<ApplicationStatus> getALlStatus(){
        return applicationStatusService.getAllStatus();
    }
}
