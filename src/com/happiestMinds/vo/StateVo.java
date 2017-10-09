/**
 * 
 */
package com.happiestMinds.vo;

/**
 * @author Mahesh Chouhan
 *
 */
public class StateVo {

	private long id;
	private String name;
	private String description;
	private Byte status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StateVo [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + "]";
	}

	
	
}
