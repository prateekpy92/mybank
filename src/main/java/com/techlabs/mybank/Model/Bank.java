package com.techlabs.mybank.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private int id;

    @NotNull
    private String bankName;

    @NotNull
    private int noOfBranches;

    @NotNull
    private int noOfCustomers;

    @NotNull
    private String mainOffice;

    @NotNull
    private String emailId;

    @NotNull
    private String achievements;

    // Default constructor (required by Hibernate)
    public Bank() {
    }

    // Parameterized constructor
    public Bank(int id, String bankName, int noOfBranches, int noOfCustomers, String mainOffice, String emailId, String achievements) {
        this.id = id;
        this.bankName = bankName;
        this.noOfBranches = noOfBranches;
        this.noOfCustomers = noOfCustomers;
        this.mainOffice = mainOffice;
        this.emailId = emailId;
        this.achievements = achievements;
    }

    // Manually added getters and setters (if Lombok is not working)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getNoOfBranches() {
        return noOfBranches;
    }

    public void setNoOfBranches(int noOfBranches) {
        this.noOfBranches = noOfBranches;
    }

    public int getNoOfCustomers() {
        return noOfCustomers;
    }

    public void setNoOfCustomers(int noOfCustomers) {
        this.noOfCustomers = noOfCustomers;
    }

    public String getMainOffice() {
        return mainOffice;
    }

    public void setMainOffice(String mainOffice) {
        this.mainOffice = mainOffice;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
}
