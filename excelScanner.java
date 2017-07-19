import java.util.List;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;

public class excelScanner {
	
	public static void main(String[] args){				
		
		// Creates buffer and file reader
		BufferedReader br = null;
		FileReader fr = null;
		
		// Initializes statistical data
		int maleCount = 0;
		int femaleCount = 0;
		int north = 0;
		int northWest = 0;
		int northEast = 0;
		int south = 0;
		int southWest = 0;
		int southEast = 0;
		int east = 0;
		int west = 0;
		
		// Pay Blocks
		int lessThanFifty = 0;
		int greaterThanEighty = 0; 
		int betweenFiftyAndEighty = 0;
		
		/*
		 * dateBlock# contains number of people within year ranges:
		 * 	dateBlock1 - less than 1985 (year <= 1984)
		 *  dateBlock2 - between 1985 and 2000 (1985 <= year < 2000)
		 *  dateBlock3 - between 2000 and 2010 (2000 <= year < 2010)
		 *  dateBlock4 - from 2010 to date (year >= 2010
		 */
		int dateBlock1 = 0; 
		int dateBlock2 = 0;
		int dateBlock3 = 0;
		int dateBlock4 = 0;
		
		Component aComponent = null;
		final JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(aComponent);
		
		
		try{
			File file = fc.getSelectedFile();
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			
			br = new BufferedReader(new FileReader(file));
			
			List<String> lineBuffer = new ArrayList<String>();			
			
			sCurrentLine = br.readLine();
			
			// Parses CSV file line by line
			for(int i = 0; (sCurrentLine = br.readLine()) != null; i++){
				lineBuffer = Arrays.asList(sCurrentLine.split(","));
				
				for(int j = 1; j < lineBuffer.size(); j++){
					lineBuffer.get(j);
	
					// Counts Gender 
					if(j == 1){
						if(lineBuffer.get(j).equals("Male")){
							maleCount++;
						}
						else{
							femaleCount++;
						}
					}
					
					// Counts Regions
					else if(j == 2){
						if(lineBuffer.get(j).equals("N")){
							north++;
						}
						else if (lineBuffer.get(j).equals("NW")){
							northWest++;
						}
						else if (lineBuffer.get(j).equals("NE")){
							northEast++;
						}
						else if (lineBuffer.get(j).equals("S")){
							south++;
						}
						else if (lineBuffer.get(j).equals("SW")){
							southWest++;
						}
						else if (lineBuffer.get(j).equals("SE")){
							southEast++;
						}
						else if (lineBuffer.get(j).equals("E")){
							east++;
						}
						else if (lineBuffer.get(j).equals("W")){
							west++;
						}
					}
					
					// Counts Date Blocks
					else if(j == 3){
						List<String> dateBuffer = Arrays.asList(lineBuffer.get(j).split("-"));
						
						int teacherYear = Integer.parseInt(dateBuffer.get(0));
						
						if(teacherYear < 1985){
							dateBlock1++;
						}
						else if(teacherYear >= 1985 && teacherYear < 2000){
							dateBlock2++;
						}
						else if(teacherYear >= 2000 && teacherYear < 2010){
							dateBlock3++;
						}
						else if(teacherYear >= 2010){
							dateBlock4++;
						}
					}
					
					// Counts Pay Blocks
					else if(j == 4){
						String income = lineBuffer.get(j);
						
				 		if (income.equals("<50")) 
				 			lessThanFifty++; 
				 		else if (income.equals("80+")) 
				 			greaterThanEighty++; 
				 		else 
				 			betweenFiftyAndEighty++; 
					}
				}
			}
		} 
		catch (IOException e){
			e.printStackTrace();
		} 
		finally{
			try{
				if(br != null)
					br.close();
				if(fr != null)
					fr.close();
			} 
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
	
		// Casts all variables to strings
		String maleCountS = Integer.toString(maleCount);
		String femaleCountS = Integer.toString(femaleCount);
		String westS = Integer.toString(west);
		String eastS = Integer.toString(east);
		String northS = Integer.toString(north);
		String southS = Integer.toString(south);
		String northWestS = Integer.toString(northWest);
		String northEastS = Integer.toString(northEast);
		String southWestS = Integer.toString(southWest);
		String southEastS = Integer.toString(southEast);
		String dateBlock1S = Integer.toString(dateBlock1);
		String dateBlock2S = Integer.toString(dateBlock2);
		String dateBlock3S = Integer.toString(dateBlock3);
		String dateBlock4S = Integer.toString(dateBlock4);
		String lessThanFiftyS = Integer.toString(lessThanFifty);
		String greaterThanEightyS = Integer.toString(greaterThanEighty);
		String betweenFiftyAndEightyS = Integer.toString(betweenFiftyAndEighty);		
		
		System.out.println(
				"maleCount: " + maleCountS + "\n" +
				"femaleCount: " + femaleCountS + "\n" +
				"north: " + northS + "\n" +
				"south: " + southS + "\n" +
				"northWest: " + northWestS + "\n" +
				"northEast: " + northEastS + "\n" +
				"southWest: " + southWestS + "\n" +
				"southEast: " + southEastS + "\n" +
				"dateBlock1: " + dateBlock1S + "\n" +
				"dateBlock2: " + dateBlock2S + "\n" +
				"dateBlock3: " + dateBlock3S + "\n" +
				"dateBlock4: " + dateBlock4S + "\n" +
				"lessThanFifty: " + lessThanFiftyS + "\n" +
				"greaterThanEighty: " + greaterThanEightyS + "\n" +
				"betweenFiftyAndEighty: " + betweenFiftyAndEightyS + "\n");
		
		/*
		 *	Creates Updated HTML file 
		 */
		try{
		String htmlInputString = 
				 "<!DOCTYPE html><html><head><title>Teacher Data Analytics</title>" +
                         "<link href=\"http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0-rc2/css/bootstrap.css\" rel=\"stylesheet\" media=\"screen\">" +
                         "</head><body bgcolor=\"#E6E22A\"><div style=\"text-align:center; color:#00B2EE;\"><h2>Teacher Data Analytics Portal</h2></div>" +
                         "<div class=\"container\"><ul class=\"nav nav-tabs nav-stacked\"><li class=\"active\" style=\"text-align:center;\"><a href=\"#ratio\" data-toggle=\"tab\">Gender Ratio</a></li>" +
                         "<li style=\"text-align:center;\"><a href=\"#region\" data-toggle=\"tab\">Region Distribution</a></li><li style=\"text-align:center;\"><a href=\"#income\" data-toggle=\"tab\">Income Ranges</a></li>" +
                         "<li style=\"text-align:center;\"><a href=\"#joined\" data-toggle=\"tab\">Date Joined</a></li></ul><div class=\"tab-content\"><div class=\"tab-pane active\" id=\"ratio\">" +
                         "<h3 style=\"color:#00B2EE;\">Gender Ratio</h3><div id=\"gender-piechart\"></div><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>" +
                         "</div><div class=\"tab-pane\" id=\"region\"><h3 style=\"color:#00B2EE;\">Region Distribution</h3><div id=\"region-piechart\"></div>" +
                         "<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script></div><div class=\"tab-pane\" id=\"income\">" +
                         "<h3 style=\"color:#00B2EE;\">Income Ranges</h3><div id=\"income-div\"></div><script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>" +
                         "</div><div class=\"tab-pane\" id=\"joined\"><h3 style=\"color:#00B2EE;\">Date Joined</h3><div id=\"joined_div\"></div></div></div></div></body></html>" +
                         "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script><script src=\"http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0-rc2/js/bootstrap.min.js\"></script>" +
                         "<script type=\"text/javascript\">google.charts.load('current', {'packages':['corechart']});google.charts.setOnLoadCallback(drawGenderChart);google.charts.setOnLoadCallback(drawRegionChart);" +
                         "function drawGenderChart() {var data = google.visualization.arrayToDataTable([['Task', 'Ratio of Male to Female Teachers'],['Male', " + maleCountS + "],['Female'," + femaleCountS +"]]);" +
               "var options = {'title':'Male/Female Ratio', 'width':1200, 'height':450, pieHole: 0.4};var chart = new google.visualization.PieChart(document.getElementById('gender-piechart'));" +
                         
                          
               "chart.draw(data, options);}function drawRegionChart() {var data = google.visualization.arrayToDataTable([['Task', 'Region Distribution']," +
               "['N', " + northS + "],['NW', " + northWestS + "],['NE'," + northEastS + "],['S', " + southS + " ],['SW', "+southWestS+"],['SE', "+southEastS+"],['W',"+ westS + "],['E', "+eastS+"]]);" +
                         "var options = {'title':'Region Distribution', 'width':1200, 'height':450,  pieSliceTextStyle: {color: 'black',}};" +
                         "var chart = new google.visualization.PieChart(document.getElementById('region-piechart'));chart.draw(data, options)}</script><script>google.charts.load('current', {packages: ['corechart', 'bar']});" +
                         "google.charts.setOnLoadCallback(drawJoinedChart);google.charts.setOnLoadCallback(drawIncomeChart);function drawJoinedChart() {var data = google.visualization.arrayToDataTable([" +
                         
                          
                          "['Range', 'Teachers'],['Before 1985', "+ dateBlock1S +"],['(1985) - 2000', "+dateBlock2S+"],['(2000) - 2016', "+ dateBlock3S +"],['(2016) - Present', "+ dateBlock4S+"]]);" +
                         "var options = {title: 'Numbers Joined',chartArea: {width: '50%'},width : 1200,height : 450,hAxis: {title: 'Total Joined',minValue: 0,textStyle: {bold: true,fontSize: 12,color: '#4d4d4d'},titleTextStyle: {bold: true,fontSize: 18,color: '#4d4d4d'" +
                         "}},vAxis: {title: '',textStyle: {fontSize: 14,bold: true,color: '#848484'},titleTextStyle: {fontSize: 14,bold: true,color: '#848484'}}};var chart = new google.visualization.BarChart(document.getElementById('joined_div'));" +
                         "chart.draw(data, options);}function drawIncomeChart() {var data = google.visualization.arrayToDataTable([['Range', 'Teachers'],['Less than $50,000', "+ lessThanFiftyS +"]," +
                         "['($50,000) - $80,000', " + betweenFiftyAndEightyS + "],['More than ($80,000)', "+ greaterThanEightyS +"],]);var options = {title: 'Numbers Earning',chartArea: {width: '50%'},width : 1200," +
                         "height : 450,hAxis: {title: 'Total Teachers',minValue: 0,textStyle: {bold: true,fontSize: 12,color: '#4d4d4d'},titleTextStyle: {bold: true,fontSize: 18,color: '#4d4d4d'}},vAxis: {title: '',textStyle: {" +
                         "fontSize: 14,bold: true,color: '#848484'},titleTextStyle: {fontSize: 14,bold: true,color: '#848484'}}};var chart = new google.visualization.BarChart(document.getElementById('income-div'));chart.draw(data, options);}</script>";




		File htmlOutputFile = new File("TeacherDataAnalytics.html");
		FileWriter fileWriter = new FileWriter(htmlOutputFile);
		fileWriter.write(htmlInputString);
		fileWriter.flush();
		fileWriter.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}