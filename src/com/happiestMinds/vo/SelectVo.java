/**
 * 
 */
package com.happiestMinds.vo;

/**
 * @author Mahesh Chouhan
 *
 */
public class SelectVo {

	private long id;
	private String name;
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
	@Override
	public String toString() {
		return "SelectVo [id=" + id + ", name=" + name + "]";
	}
	
}
