package entity;

public class CustomerPhoneNumber {
	private int ID;
	private String phoneNumber;

	public int getID() {
		return ID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CustomerPhoneNumber(int iD, String phoneNumber) {
		ID = iD;
		this.phoneNumber = phoneNumber;
	}

	public CustomerPhoneNumber() {
	}

}
