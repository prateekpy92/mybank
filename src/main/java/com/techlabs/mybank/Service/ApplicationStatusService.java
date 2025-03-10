package com.techlabs.mybank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.mybank.Model.Admin;
import com.techlabs.mybank.Model.ApplicationStatus;
import com.techlabs.mybank.Model.StatusOptions;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationStatusService {

    @Autowired
    private com.techlabs.mybank.Repository.ApplicationStatusRepo applicationStatusRepo;

    public List<ApplicationStatus> getAllStatus(){
        return applicationStatusRepo.findAll();
    }

    public List<ApplicationStatus> getAllStatusUnderReview(){
        return applicationStatusRepo.search(String.valueOf(StatusOptions.UNDER_REVIEW));
    }
    public List<ApplicationStatus> getAllStatusUnderProcessing(){
        return applicationStatusRepo.search(String.valueOf(StatusOptions.UNDER_PROCESSING));
    }


    public void add(ApplicationStatus applicationStatus) {
         applicationStatusRepo.save(applicationStatus);
    }

    public void delete(int id) {
        applicationStatusRepo.deleteById(id);
    }

    public Optional<ApplicationStatus> getApplicationStatusById(int id) {
        return applicationStatusRepo.findById(id);
    }
    public ApplicationStatus update(ApplicationStatus applicationStatus) {
        return applicationStatusRepo.save(applicationStatus);

    }

    public ApplicationStatus getApplicationStatusByCusId(int id){
       return  applicationStatusRepo.findApplicationStatusByRequestedAccounts_Id(id);
    }
    public ApplicationStatus getApplicationStatusByRequestId(int id) {
        return applicationStatusRepo.findApplicationStatusByRequestedAccounts_Id(id);
    }




}
