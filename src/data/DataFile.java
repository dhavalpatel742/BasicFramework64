package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	
	
	public String emailwithspecialchar = d.getCellData("Data1", "UserName", 4);//"dkjncjen%$cshv";
	public String wrongemail = d.getCellData("Data1", "UserName", 3);//"dwcbewbcdcgue";
	public String wrongpassword = d.getCellData("Data1", "Password", 2);//"dwhuguvbdwev";
	public String specialcharerr =d.getCellData("Data1", "Email Error", 5);// "Please enter a username or card number without special characters.";
	public String emptyemailerr =d.getCellData("Data1", "Email Error", 4);// "Please enter your username or card number.";
	public String emptypassworderr = d.getCellData("Data1", "Password Error", 3);//"Please enter your password.";
	public String globalerr = d.getCellData("Data1", "Global Error", 2);//"Please check your card number / username or password and try again.";
	
}

//Login
/*public String emailWithSpecialChar = 
public String wrongEmail = 
public String wrongPassword = 
public String specialCharErr = 
public String emptyEmailErr = 
public String emptyPasswordErr = 
public String globalErr = 
*/