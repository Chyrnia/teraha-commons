package com.teraha.commons.entities;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;

	private String description;

	@ManyToMany
	@JoinTable(
		name = "roles_permissions",
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "permission_id")
	)
	@Setter(AccessLevel.NONE)
	private Set<Permission> permissions = new HashSet<>();

	protected Role() {}

	public Role(String name, String description){
		this.name = name;
		this.description = description;
	}

	public void addPermission(Permission permission){
		permissions.add(Objects.requireNonNull(permission));
	}

	public void removePermission(Permission permission){
		permissions.remove(permission);
	}
}
