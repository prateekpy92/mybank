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
public class ApplicationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int id ;

    @OneToOne
    @JoinColumn(name = "request_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RequestedAccounts requestedAccounts;

    @NotNull
    private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RequestedAccounts getRequestedAccounts() {
		return requestedAccounts;
	}

	public void setRequestedAccounts(RequestedAccounts requestedAccounts) {
		this.requestedAccounts = requestedAccounts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApplicationStatus(int id, RequestedAccounts requestedAccounts, @NotNull String status) {
		super();
		this.id = id;
		this.requestedAccounts = requestedAccounts;
		this.status = status;
	}
    
}

