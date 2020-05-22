
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class CoronaSolver {
	
	static List<String> list = new ArrayList<String>();

	static String currentLoc = "L";
	
	static String[] answer = new String[18];
	
	
	public static void main (String[] args) throws IOException {
		
		//String currentLoc = getFirstDay();
		
		//System.out.println(dayLA(0));
		//System.out.println(dayNY(0));
		//System.out.println(getDays());
		//System.out.println(getFlight());
		//System.out.println(currentLoc);
		//System.out.println(compareDay(3));
		//System.out.println(list.get(1));
		System.out.println(Arrays.toString(solver()));
		
		}
	
	
	public static String dayLA(int day) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("deaths.txt"));
		String str;

		
		while((str = in.readLine()) != null){
		    list.add(str);
		}
		
		int size = list.size()*2;
		String[] newStringArr = new String[size];
		//System.out.println(list.get(1));
		String[] stringArr = list.toArray(new String[0]);
		int size2 = (stringArr.length * 2) - 3;
		String[] newS = new String[size2];
		/*
		for (int i = 0; i < stringArr.length; i++)
		{
			newStringArr[i] = stringArr[i].split(" ");
		}
		*/
		int k = 0;
		for(String s : stringArr) {
		      newStringArr = s.split(" ");
		      //for(String results : newStringArr) {
		          //System.out.println(results);
		          //String [] arr = results;
		    	  //int size = newStringArr.length;
		    	  //newS = new String[size];
		       for (int i = 0; i < newStringArr.length; i++)
		       {
		    	   
		    	   newS[k] = newStringArr[i];
		    	   k = k + 1;
		    	   String result = newStringArr[i];
		    	   
		    	   //System.out.println(result);
		       }
		          
		      
		  }
		//System.out.println(Arrays.toString(newS));
		
		int size3 = (newS.length/2);
		String[] LA = new String[size3];
		int l = 0;
		for (int j = 2; j < newS.length; j = j+2)
		{
			
			LA[l] = newS[j];
			//System.out.println(LA[j]);
			l++;
		}
		int correctDay = day;
		return LA[correctDay];
}
	

	
	public static String dayNY(int day) throws IOException
	{
		
		BufferedReader in = new BufferedReader(new FileReader("deaths.txt"));
		String str2;

		
		while((str2 = in.readLine()) != null){
		    list.add(str2);
		}
		
		int size = list.size()*2;
		String[] newStringArr = new String[size];
		
		String[] stringArr2 = list.toArray(new String[0]);
		int size2 = (stringArr2.length * 2);
		String[] newS2 = new String[size2];
		/*
		for (int i = 0; i < stringArr.length; i++)
		{
			newStringArr[i] = stringArr[i].split(" ");
		}
		*/
		int k = 0;
		for(String s : stringArr2) {
		      newStringArr = s.split(" ");
		      //for(String results : newStringArr) {
		          //System.out.println(results);
		          //String [] arr = results;
		    	  //int size = newStringArr.length;
		    	  //newS = new String[size];
		       for (int i = 0; i < newStringArr.length; i++)
		       {
		    	   
		    	   newS2[k] = newStringArr[i];
		    	   k = k + 1;
		    	   String result = newStringArr[i];
		    	   
		    	   //System.out.println(result);
		       }
		          
		      
		  }
		//System.out.println(Arrays.toString(newS));
		
		int size3 = (newS2.length);
		String[] NY = new String[size3];
		int l = 0;
		for (int j = 3; j < newS2.length; j = j+2)
		{
			
			NY[l] = newS2[j];
			//System.out.println(LA[j]);
			l++;
		}
		int correctDay = day;
		return NY[correctDay];
	}
	
	public static int getDays() throws IOException
	{
		
		BufferedReader in = new BufferedReader(new FileReader("deaths.txt"));
		String str;

		
		while((str = in.readLine()) != null){
		    list.add(str);
		}
		
		String dayString;
		dayString = list.get(0);
		int days =Integer.parseInt(dayString);  
		
		return days;
	}
	
	public static int getFlight()
	{
		String flightString;
		flightString = list.get(1);
		int flight =Integer.parseInt(flightString);  
		
		return flight;
	}
	/* DOESNT WORK, DON'T KNOW WHY NOT. THORWS OUT OF BOUNDS WHEN GETTING dayNY FOR SOME REASON
	public static String getFirstDay() throws NumberFormatException, IOException
	{
		String NY = dayNY(3);
		int nyInt = Integer.parseInt(NY);
		String LA = dayLA(3);
		int laInt = Integer.parseInt(LA);
		if (nyInt > laInt)
		{
			return "N";
		}
		else
		{
			return "L";
		}
	}
	*/
	public static String compareDay(int day) throws NumberFormatException, IOException
	{
		int NY = Integer.parseInt(dayNY(day));
		int LA = Integer.parseInt(dayLA(day));
		int flight = getFlight();
		if (NY + flight < LA)
		{
			currentLoc = "N";
			return currentLoc;
		}
		else if (LA + flight < NY)
		{
			currentLoc = "L";
			return currentLoc;
		}
		else
		{
			if (day == 0)
			{
				
				compareDayReverse(day+1);
				return currentLoc;
			}
			compareDay(day-1);
			return currentLoc;
		}
		
	}
	
	public static String compareDayReverse(int day) throws NumberFormatException, IOException
	{
		int NY = Integer.parseInt(dayNY(day));
		int LA = Integer.parseInt(dayLA(day));
		int flight = getFlight();
		if (NY + flight < LA)
		{
			currentLoc = "N";
			return currentLoc;
		}
		else if (LA + flight < NY)
		{
			currentLoc = "L";
			return currentLoc;
		}
		else
		{
			compareDayReverse(day+1);
			return currentLoc;
		}
		
	}
	
	public static boolean comparePrevLA(int day) throws NumberFormatException, IOException
	{
		int flight = getFlight();
		int NY = Integer.parseInt(dayNY(day));
		int LA = Integer.parseInt(dayLA(day));
		
		if (NY+flight < LA)
		{
			currentLoc = "N";
			return true;
		}
		else if (LA < NY)
		{
			currentLoc = "L";
			return false;
		}
		else
		{
			comparePrevLA(day-1);
		}
		return true;
	}
	
	public static boolean comparePrevNY(int day) throws NumberFormatException, IOException
	{
		int flight = getFlight();
		int NY = Integer.parseInt(dayNY(day));
		int LA = Integer.parseInt(dayLA(day));
		
		if (LA+flight < NY)
		{
			currentLoc = "L";
			return true;
		}
		else if (NY< LA)
		{
			currentLoc = "N";
			return false;
		}
		else
		{
			comparePrevNY(day-1);
		}
		
		return true;
	}
	
	public static String[] solver() throws NumberFormatException, IOException
	{
		int days = getDays();
		int flight = getFlight();
		String lastLoc = compareDay(days-1);
		answer[days-1] = lastLoc;
		currentLoc = lastLoc;
		//System.out.println(lastLoc);
		for (int i = days-2; i > 0; i--)
		{
			if (currentLoc.equalsIgnoreCase("L"))
			{
				if (comparePrevLA(i))
				{
					answer[i] = currentLoc;
				}
				else
				{
					answer[i] = currentLoc;
				}
			}
			else if (currentLoc.equalsIgnoreCase("N"))
			{
				//System.out.println("here");
				if (comparePrevNY(i))
				{
					
					answer[i] = currentLoc;
				}
				else
				{
					answer[i] = currentLoc;
				}
			}
		}
		answer[0] = compareDay(0);
		return answer;
	}
}
