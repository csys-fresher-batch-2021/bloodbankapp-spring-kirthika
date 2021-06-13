package in.kirthika.model;

import java.time.LocalDate;

public class SeekerDetail {
	private String bloodGroup;
	private String name;
	private Long mobileNumber;
	private int age;
	private String place;
	private LocalDate date;
	private String gender;
	private String status;

	public SeekerDetail(String bloodGroup, String name, Long mobileNumber, int age, String place, LocalDate date,
			String gender) {
		super();
		this.bloodGroup = bloodGroup;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.place = place;
		this.date = date;
		this.gender = gender;
	}

	public SeekerDetail(String bloodGroup, String name, Long mobileNumber, int age, String place, LocalDate date,
			String gender, String status) {
		super();
		this.bloodGroup = bloodGroup;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.place = place;
		this.date = date;
		this.gender = gender;
		this.status = status;
	}

	public SeekerDetail() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	@Override
	public String toString() {
		return "SeekerDetail [bloodGroup=" + bloodGroup + ", name=" + name + ", mobileNumber=" + mobileNumber + ", age="
				+ age + ", place=" + place + ", date=" + date + ", gender=" + gender + ", status=" + status + "]";
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
