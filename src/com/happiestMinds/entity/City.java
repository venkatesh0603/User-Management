package com.happiestMinds.entity;
// Generated Sep 20, 2017 11:51:49 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * City generated by hbm2java
 */
@Entity
@Table(name = "City", catalog = "UserManagement")
public class City implements java.io.Serializable {

	private long id;
	private State state;
	private String name;
	private String description;
	private Byte status;
	private Set<Address> addresses = new HashSet<Address>(0);

	public City() {
	}

	public City(long id) {
		this.id = id;
	}

	public City(long id, State state, String name, String description, Byte status, Set<Address> addresses) {
		this.id = id;
		this.state = state;
		this.name = name;
		this.description = description;
		this.status = status;
		this.addresses = addresses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state")
	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
