
public class Teacher {
	
	String firstName,
			lastName,
			region,
			dateJoined,
			gender,
			incomeRange;
	
	public Teacher(String firstName, String lastName, String dateOfBirth, String profession, String location, String grade, String gender) {
		
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setRegion(String location) {
		region = location;
	}
	
	public void setDateJoined(String startDate) {
		dateJoined = startDate;
	}
	public void setIncomeRange(String income) {
		incomeRange = income;
	}
	
	public void setGender(String sex) {
		gender = sex;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getDateJoined() {
		return dateJoined;
	}
	
	public String getIncomeRange(){
		return incomeRange;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String toString() {
		return "First Name: " + firstName +
				"\nLast Name: " + lastName +
				"\nRegion: " + region +
				"\nDate Joined: " + dateJoined +
				"\nIncome Range: " + incomeRange +
				"\nGender: " + gender;
	}
}
