package org.timmyaditya.adityaPortfolioJpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="messages")
public class MessageModel {
	
	public MessageModel(String name, String email, String subject, String message, String timestamp) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="subjct")
	private String subject;
	
	@Column(name="message")
	private String message;
	
	@Column(name="timestamp")
	private String timestamp;
}
