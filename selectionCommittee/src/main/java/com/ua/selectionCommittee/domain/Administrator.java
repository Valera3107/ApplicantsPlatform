package com.ua.selectionCommittee.domain;

import javax.persistence.*;

@Entity
@Table(name = "administrator")
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private String login;

	@Column
	private String password;

	@Column(name="password_confirm")
	private String passwordConfirm;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Administrator() {
	}
	
	public Administrator(Administrator administrator) {
		this.id = administrator.id;
		this.name = administrator.name;
		this.login = administrator.login;
		this.password = administrator.password;
		this.role = administrator.role;
		this.passwordConfirm = administrator.passwordConfirm;
	}

	public Administrator(String name, String login, String password,String confirmPassword, Role role) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
		this.passwordConfirm = confirmPassword;
	}

	public Administrator(Integer id, String name, String login, String password,String confirmPassword, Role role) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;
		this.passwordConfirm = confirmPassword;
	}
	
	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String confirmPassword) {
		this.passwordConfirm = confirmPassword;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Administrator other = (Administrator) obj;
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
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", role="
				+ role + "]";
	}

}
