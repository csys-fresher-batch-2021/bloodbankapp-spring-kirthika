package in.kirthika.model;

public class UserDetail {
	private String userName;
	private String userPassword;
	private String userBloodGroup;
	private Long userMobileNum;
	private int userAge;
	private String userPlace;

	@Override
	public String toString() {
		return "UserDetail [userName=" + userName + ", userPassword=" + userPassword + ", userBloodGroup="
				+ userBloodGroup + ", userMobileNum=" + userMobileNum + ", userAge=" + userAge + ", userPlace="
				+ userPlace + "]";
	}

	public UserDetail(String userName, String userPassword, Long userMobileNum) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMobileNum = userMobileNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserBloodGroup() {
		return userBloodGroup;
	}

	public void setUserBloodGroup(String userBloodGroup) {
		this.userBloodGroup = userBloodGroup;
	}

	public Long getUserMobileNum() {
		return userMobileNum;
	}

	public void setUserMobileNum(Long userMobileNum) {
		this.userMobileNum = userMobileNum;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserPlace() {
		return userPlace;
	}

	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}

	public UserDetail(String userName, String userPassword, String userBloodGroup, Long userMobileNum, int userAge,
			String userPlace) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userBloodGroup = userBloodGroup;
		this.userMobileNum = userMobileNum;
		this.userAge = userAge;
		this.userPlace = userPlace;
	}

	public UserDetail() {
		super();
	}

}
