package com.techlabs.mybank.Model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MoneyReceived {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @ManyToOne
    @JoinColumn(name = "cus_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customers customers_money_received;

    @NotNull
    private String senderAccNo;

    @NotNull
    private String receiversAccNo;

    @NotNull
    private String senderIfscCode;

    @NotNull
    private String receiverIfscCode;

    @NotNull
    private float amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customers getCustomers_money_received() {
		return customers_money_received;
	}

	public void setCustomers_money_received(Customers customers_money_received) {
		this.customers_money_received = customers_money_received;
	}

	public String getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(String senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public String getReceiversAccNo() {
		return receiversAccNo;
	}

	public void setReceiversAccNo(String receiversAccNo) {
		this.receiversAccNo = receiversAccNo;
	}

	public String getSenderIfscCode() {
		return senderIfscCode;
	}

	public void setSenderIfscCode(String senderIfscCode) {
		this.senderIfscCode = senderIfscCode;
	}

	public String getReceiverIfscCode() {
		return receiverIfscCode;
	}

	public void setReceiverIfscCode(String receiverIfscCode) {
		this.receiverIfscCode = receiverIfscCode;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}


}
