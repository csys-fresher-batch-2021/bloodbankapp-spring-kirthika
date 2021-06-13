package in.kirthika.model;

public class SeekerStatusDetail {

	private String name;
	private String place;
	private Long mobileNumber;
	private String blood;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public SeekerStatusDetail(String name, String place, Long mobileNumber, String blood) {
		super();
		this.name = name;
		this.place = place;
		this.mobileNumber = mobileNumber;
		this.blood = blood;

	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	@Override
	public String toString() {
		return "SeekerStatusDetail [name=" + name + ", place=" + place + ", mobileNumber=" + mobileNumber + ", blood="
				+ blood + "]";
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
