package com.ua.selectionCommittee.domain;

import javax.persistence.*;

@Entity
@Table(name = "enrollee")
public class Enrollee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String login;

	@Column
	private String password;

	@Column(name = "password_confirm")
	private String passwordConfirm;

	@Column(name = "math_score")
	private Double mathScore;

	@Column(name = "english_score")
	private Double englishScore;

	@Column(name = "ukraine_score")
	private Double ukraineScore;

	@Column(name = "physics_score")
	private Double physicsScore;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Lob
	private String image;

	@Column
	private String status;

	public Enrollee() {
	}

	public Enrollee(Enrollee enrollee) {
		this.id = enrollee.id;
		this.name = enrollee.name;
		this.surname = enrollee.surname;
		this.login = enrollee.login;
		this.password = enrollee.password;
		this.mathScore = enrollee.mathScore;
		this.role = enrollee.role;
		this.englishScore = enrollee.englishScore;
		this.ukraineScore = enrollee.ukraineScore;
		this.physicsScore = enrollee.physicsScore;
		this.passwordConfirm = enrollee.passwordConfirm;
	}

	public Enrollee(String name, String surname, String login, String password, String confirmPassword,
			Double mathScore, Double englishScore, Double ukraineScore, Double physicsScore, Role role) {
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.mathScore = mathScore;
		this.role = role;
		this.passwordConfirm = confirmPassword;
		this.englishScore = englishScore;
		this.ukraineScore = ukraineScore;
		this.physicsScore = physicsScore;
	}

	public Enrollee(Integer id, String name, String surname, String login, String password, String confirmPassword,
			Double mathScore, Double englishScore, Double ukraineScore, Double physicsScore, Role role) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.ukraineScore = ukraineScore;
		this.physicsScore = physicsScore;
		this.passwordConfirm = confirmPassword;
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMathScore() {
		return mathScore;
	}

	public void setMathScore(Double mathScore) {
		this.mathScore = mathScore;
	}

	public Double getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(Double englishScore) {
		this.englishScore = englishScore;
	}

	public Double getUkraineScore() {
		return ukraineScore;
	}

	public void setUkraineScore(Double ukraineScore) {
		this.ukraineScore = ukraineScore;
	}

	public Double getPhysicsScore() {
		return physicsScore;
	}

	public void setPhysicsScore(Double physicsScore) {
		this.physicsScore = physicsScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((englishScore == null) ? 0 : englishScore.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mathScore == null) ? 0 : mathScore.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((physicsScore == null) ? 0 : physicsScore.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((ukraineScore == null) ? 0 : ukraineScore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollee other = (Enrollee) obj;
		if (englishScore == null) {
			if (other.englishScore != null)
				return false;
		} else if (!englishScore.equals(other.englishScore))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mathScore == null) {
			if (other.mathScore != null)
				return false;
		} else if (!mathScore.equals(other.mathScore))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (physicsScore == null) {
			if (other.physicsScore != null)
				return false;
		} else if (!physicsScore.equals(other.physicsScore))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (ukraineScore == null) {
			if (other.ukraineScore != null)
				return false;
		} else if (!ukraineScore.equals(other.ukraineScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollee [id=" + id + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password="
				+ password + ", mathScore=" + mathScore + ", englishScore=" + englishScore + ", ukraineScore="
				+ ukraineScore + ", physicsScore=" + physicsScore + "]";
	}

}
