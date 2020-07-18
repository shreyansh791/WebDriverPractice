package seleniumtopics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CheckForSpecialCharacters {
public static void main(String[] args) {
	boolean b=checkForString("@");
	if(b)
		System.out.println("contains String");
}

private static boolean checkForString(String value) {
	
	Pattern p=Pattern.compile("[^0-9]");
	try {
	Matcher m=p.matcher(value);
	boolean status=m.find();
	return status;
	}catch (NullPointerException e) {
		return false;
		
	}
	
}
}

