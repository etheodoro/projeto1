package br.com.curso.io.projeto1.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "findUserByNameByProc",
			procedureName = "GetUserByName",
			parameters = {
				@StoredProcedureParameter(
						name = "name",
						type = String.class,
						mode = ParameterMode.IN
						) }
			,resultClasses = User.class)
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	@ManyToMany
	private Set<Role> roles;
	
	public User() {
	}

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
