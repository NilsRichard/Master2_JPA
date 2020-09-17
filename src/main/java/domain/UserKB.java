package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserKB implements Serializable  {

	private static final long serialVersionUID = -3865139814508230644L;

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private CardKB card;

	public UserKB() {
	}

	public UserKB(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@OneToOne(mappedBy = "assignedUser")
	public CardKB getCard() {
		return card;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCard(CardKB card) {
		this.card = card;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
