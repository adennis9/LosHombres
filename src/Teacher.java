
public class Teacher {
	
	String firstName,
			lastName,
			dateOfBirth,
			profession,
			location,
			grade,
			gender;
	
	public Teacher(String firstName, String lastName, String dateOfBirth, String profession, String location, String grade, String gender) {
		
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setDateOfBirth(String dob) {
		dateOfBirth = dob;
	}
	
	public void setProfession(String job) {
		profession = job;
	}
	public void setLocation(String place) {
		location = place;
	}
	
	public void setGrade(String lvl) {
		grade = lvl;
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
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String toString() {
		return "First Name: " + firstName +
				"\nLast Name: " + lastName +
				"\nDate of Birth: " + dateOfBirth +
				"\nProfession: " + profession +
				"\nLocation: " + location +
				"\nGender: " + gender;
	}
}
