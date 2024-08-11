package com.techlabs.mybank.Model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id ;

    @NotNull
    private String name;

    @NotNull
    private long phoneNo;

    @NotNull
    @Column(unique = true)
    private String accNO;

    @NotNull
    private String pinNo;

    @NotNull
    private String  emailId;

    @NotNull
    private String address;

    @NotNull
    @Column(unique = true)
    private long adhaarNo;

    @NotNull
    @Column(unique = true)
    private String panNo;

    @NotNull
    private float balance;

    @NotNull
    private String accType;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Branch branch;

    @NotNull
    private String dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAccNO() {
		return accNO;
	}

	public void setAccNO(String accNO) {
		this.accNO = accNO;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(long adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Customers() {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.accNO = accNO;
		this.pinNo = pinNo;
		this.emailId = emailId;
		this.address = address;
		this.adhaarNo = adhaarNo;
		this.panNo = panNo;
		this.balance = balance;
		this.accType = accType;
		this.branch = branch;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", accNO=" + accNO + ", pinNo="
				+ pinNo + ", emailId=" + emailId + ", address=" + address + ", adhaarNo=" + adhaarNo + ", panNo="
				+ panNo + ", balance=" + balance + ", accType=" + accType + ", branch=" + branch + ", dob=" + dob + "]";
	}

}
