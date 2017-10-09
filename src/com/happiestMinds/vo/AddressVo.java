/**
 * 
 */
package com.happiestMinds.vo;

/**
 * @author Mahesh Chouhan
 *
 */
public class AddressVo {

	private long id;
	private String doorNo;
	private String street;
	private CityVo city;
	private StateVo state;
	private CountryVo country;
	private String pinCode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public CityVo getCity() {
		return city;
	}
	public void setCity(CityVo city) {
		this.city = city;
	}
	public StateVo getState() {
		return state;
	}
	public void setState(StateVo state) {
		this.state = state;
	}
	public CountryVo getCountry() {
		return country;
	}
	public void setCountry(CountryVo country) {
		this.country = country;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "AddressVo [id=" + id + ", doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pinCode=" + pinCode + "]";
	}

}
