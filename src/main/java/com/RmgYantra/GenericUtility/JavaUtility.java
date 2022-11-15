package com.RmgYantra.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 * This class consists of java library
 * @author Vramanan
 *
 */
public class JavaUtility {
	/**
	 * This method return random number with in the range(1000)
	 * @return
	 */
	public int RandomNumber(){
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**
	 *  its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */
	public String  getSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String time=arr[3];
		String[] hms = time.split(":");
		String sec = hms[2];
		String min = hms[1];
		String hr = hms[0];
		
		String yyyy = arr[5];
		String dd = arr[2];
		@SuppressWarnings("deprecation")
		int mm = date.getMonth()+1;
	
			String formate = yyyy+"-"+mm+"-"+dd+"_"+hr+min+sec;
			return formate;
	}
	/**
	 *  its used to get the current system date based on DD-MM-YYYY format 
	 * @return
	 */
	public String  getSystemDateInIST() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String time=arr[3];
		String[] hms = time.split(":");
		String sec = hms[2];
		String min = hms[1];
		String hr = hms[0];
		String yyyy = arr[5];
		String dd = arr[2];
		@SuppressWarnings("deprecation")
		int mm = date.getMonth()+1;
	
			String formate = dd+"-"+mm+"-"+yyyy+"_"+hr+min+sec;
			return formate;
	}

}
