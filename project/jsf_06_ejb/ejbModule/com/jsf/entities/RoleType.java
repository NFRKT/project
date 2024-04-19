package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the role_type database table.
 * 
 */
@Entity
@Table(name="role_type")
@NamedQuery(name="RoleType.findAll", query="SELECT r FROM RoleType r")
public class RoleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	private Integer idRole;

	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="roleType")
	private List<User> users;

	public RoleType() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setRoleType(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRoleType(null);

		return user;
	}

}