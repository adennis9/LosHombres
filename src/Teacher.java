
public class Teacher {
	
	String	region,
			dateJoined,
			gender,
			incomeRange;
	
	public Teacher(String sex, String location, String startDate, String salary) {
		gender = sex;
		region = location;
		dateJoined = startDate;
		incomeRange = salary;
		
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
	
}
