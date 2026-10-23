package com.teraha.commons.entities;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String username; 

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "pass_hash", nullable = false)
	private String passwordHash;

	@Column(nullable = false)
	private boolean enabled = true;

	@Column(name = "last_login")
	private OffsetDateTime lastLogin;

	@ManyToMany
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	@Setter(AccessLevel.NONE)
	private Set<Role> roles = new HashSet<>();

	protected User() {}

	public User(
			String username,
			String email,
			String passwordHash
			){
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
			}

	public void addRole(Role role){
		roles.add(Objects.requireNonNull(role));
	}

	public void removeRole(Role role){
		roles.remove(role);
	}
}
