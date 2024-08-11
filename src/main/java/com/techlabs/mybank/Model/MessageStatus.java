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
public class MessageStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mess_status_id")
    private int id ;

    @OneToOne
    @JoinColumn(name = "req_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Requests requests;

    @NotNull
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Requests getRequests() {
		return requests;
	}

	public void setRequests(Requests requests) {
		this.requests = requests;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MessageStatus(int id, Requests requests, @NotNull String status) {
		super();
		this.id = id;
		this.requests = requests;
		this.status = status;
	}
    
}
