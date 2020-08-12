package model.vo;

import java.io.Serializable;

public class Member implements Serializable {

	
	private String address ; 
	private String name ; 
	private String phone ;
	private boolean power;
	
	private static final long serialVersionUID = 6561771726126793156L;
	
	
	public Member(){}
	
	
	public Member( String name ,String address , String phone  ){
		
		this.name = name;
		this.address = address;  
		this.phone = phone;
	}
	
	public Member( String name ,String address , String phone , boolean power ){
		
		this(name, address , phone);
		this.power = power;
	}
	
	
	 
	
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	} 
	
	
	public boolean getPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	
	@Override
	public String toString() {
	
		return name + " " + address + " " + phone;
	}
	
	// id     name      phone     title      author        category               overdue                           rental        
	
	
	@Override
	public int hashCode() {
	
		
		final int prime = 31 ;  
		
		int result = 1 ;
		
		
		result = prime * result + ((address == null)? 0 : address.hashCode());
		result = prime * result + ((name == null)? 0 : name.hashCode());
		result = prime * result + ((phone == null)? 0 : phone.hashCode());
		
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
	
		Member other = (Member)obj;
		
		if(address == null) {
			
			if(other.address != null) {
				return false;
			}
			
		}
		else if (!(address.equals(other.address)))
		{
			return false;
		}
		else if (!(name.equals(other.name)))
		{
			return false;
		}
		else if (!(phone.equals(other.phone)))
		{
			return false;
		}
		
		
		
		return true;
		
		
	}
}