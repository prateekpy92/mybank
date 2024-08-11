package com.techlabs.mybank.Model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor  // Lombok annotation for no-arg constructor
@Getter
@Setter
@ToString
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String emailId;

    @NotNull
    private String pass;

    // Manually adding the no-arg constructor, just in case Lombok isn't working
    public Admin() {
        // Required by Hibernate
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Admin(int id, @NotNull String emailId, @NotNull String pass) {
        this.id = id;
        this.emailId = emailId;
        this.pass = pass;
    }
}
