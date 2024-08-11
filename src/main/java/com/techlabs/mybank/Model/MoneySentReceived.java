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
public class MoneySentReceived {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @NotNull
    private String senderAccNo;

    @NotNull
    private String receiverAccNo;

    @NotNull
    private float amount;

    @NotNull
    private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenderAccNo() {
		return senderAccNo;
	}

	public void setSenderAccNo(String senderAccNo) {
		this.senderAccNo = senderAccNo;
	}

	public String getReceiverAccNo() {
		return receiverAccNo;
	}

	public void setReceiverAccNo(String receiverAccNo) {
		this.receiverAccNo = receiverAccNo;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MoneySentReceived [id=" + id + ", senderAccNo=" + senderAccNo + ", receiverAccNo=" + receiverAccNo
				+ ", amount=" + amount + ", date=" + date + "]";
	}

}
