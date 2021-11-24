//James Hawkins
//Finds the average of guttneburg publish dates

import java.util.*;
import java.io.*;

public class dateAverage{

	public static void main(String [] args){
		//gets the directory to process
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a dir of guttenburg texts: ");
		String input = sc.nextLine();
		try{
			File file = new File(input);
			//array of all files in the selected directory
			String [] fileList = file.list();
			ArrayList<String> dates = new ArrayList<String>();
			//goes through each file in the directory
			for(String name : fileList){
				//makes sure that the file is a txt
				if(name.contains(".txt")){
					//gets the date from the file
					String date = getDate(input+name);
					if(!(date.equals("ree"))){
						dates.add(date);
					}
					//adds the date to the array of dates
					if(date.equals("ree")){
					//	System.out.println("File does not contain a date");
					}
				}
			}

			//gets the average date
			String result = averageDate(dates);
			System.out.println("The average date is: "+ result);
		}catch(Exception e){
			System.out.println("Break 1"+e);
		}
	}
	
	//takes in the file to process
	//returns the release date
	public static String getDate(String fileName){
		try{
			File file = new File(fileName);
			Scanner fileSc = new Scanner(file);
			//System.out.println("This is the read filename: "+fileName);
			while(fileSc.hasNextLine()){
				String line = fileSc.nextLine();
				if(line.contains("Release Date:")){
					String result = line.substring(line.indexOf(":")+2, line.length());
					if(result.contains("[")){
						result = result.substring(0,result.indexOf("[")-1);
					}
					//System.out.println("This is the extracted date: "+result);
					return result;
				}		
			}
		}catch(Exception e){
			System.out.println("Break 2 "+e);
		}
		return "ree";
	}

	//takes in a array of dates in strings
	//returns the average date as a sting
	public static String averageDate(ArrayList<String> dates){
		ArrayList<Integer> days = new ArrayList<Integer>();
		ArrayList<Integer> months = new ArrayList<Integer>();
		ArrayList<Integer> years = new ArrayList<Integer>();					
		for(int i = 0; i < dates.size(); i++){
			String date = dates.get(i);
			int yearTemp = -1;
			int monthsTemp = -1;
			int dayTemp = -1;
			date = date.toLowerCase();
			Scanner dateSc = new Scanner(date);
			ArrayList<String> brknDate = new ArrayList<String>();
			while(dateSc.hasNext()){
				String tempString = dateSc.next();
				//System.out.println("This is part of the date: "+ tempString);
				brknDate.add(tempString);
			}
			if(brknDate.size()==1){
				yearTemp = processDate('y',brknDate.get(0));
				if(yearTemp != -1){
					years.add(yearTemp);
				}
			}else if(brknDate.size()==2){
				monthsTemp = processDate('m',brknDate.get(0));
				if(monthsTemp != -1){
					months.add(monthsTemp);
				}
				yearTemp = processDate('y', brknDate.get(1));
				if(yearTemp != -1){
					years.add(yearTemp);
				}
				
			}else{
				dayTemp = processDate('d',brknDate.get(1));
				if(dayTemp != -1){
					days.add(dayTemp);
				}
				monthsTemp = processDate('m',brknDate.get(0));
				if(monthsTemp != -1){
					months.add(monthsTemp);
				}
				yearTemp = processDate('y', brknDate.get(2));
				if(yearTemp != -1){
					years.add(yearTemp);
				}
			}
		}
		int averageDay = averageArray(days);
		int averageMonth = averageArray(months);
		int averageYear = averageArray(years);
		return averageMonth + "/" + averageDay + "/" + averageYear; 	
	
	}

	//takes in a char to tell what to return, day, month, year
	//takes in a string to process as a date
	//returns int of selected part of a date
	public static int processDate(char t, String date){
		if(t =='d'){
			//process day
			String temp = date;
			//System.out.println("This is supposed to be day: "+temp);
			//removes the ,
			temp = temp.replace(",","");
			try{
				int tempInt = Integer.parseInt(temp);
				if(tempInt>0&&tempInt<32){
					return tempInt;
				}else{
					return -1;
				}
			}catch(Exception e){
				return -1 ;
			}
		}else if(t =='m'){
			//process month
			if(date.contains("january")){
				return 1;
			}else if(date.contains("february")){
				return 2;
			}else if(date.contains("march")){
				return 3;
			}else if(date.contains("april")){
				return 4;
			}else if(date.contains("may")){
				return 5;
			}else if(date.contains("june")){
				return 6;
			}else if(date.contains("july")){
				return 7;
			}else if(date.contains("august")){
				return 8;
			}else if(date.contains("september")){
				return 9;
			}else if(date.contains("october")){
				return 10;
			}else if(date.contains("november")){
				return 11;
			}else if(date.contains("december")){
				return 12;
			}else{
				return -1;
			}
		}else{
			//process year
			//String temp = dateList.get(dateList.size()-1);
			try{
				return Integer.parseInt(date);
			}catch(Exception e){
				return -1;
			}

		}
	}
	
	//takes in a array of ints
	//returns the int average of the array
	public static int averageArray(ArrayList<Integer> list){
		int result = 0;
		//System.out.println("Array size is: "+list.size());
		for(int i = 0; i < list.size(); i++){
			result = result + list.get(i);
		}
		return result/list.size();
	}
}
