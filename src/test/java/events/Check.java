package events;

import java.util.NoSuchElementException;

public class Check {
	public static int returnNumber()
	{
		
		try
		{
			System.out.println(11);
			return 10;
		}
		
		finally
		{
			System.out.println(110);
		}
		
		
	}
public static void main(String[] args) {
	try {
		int a=Integer.parseInt(null);
	}catch (NumberFormatException e) {
		e.printStackTrace();
	}
}
}
