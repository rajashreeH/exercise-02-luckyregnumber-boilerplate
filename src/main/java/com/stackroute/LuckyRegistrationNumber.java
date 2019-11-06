package com.stackroute;

import java.util.Scanner;

//Complete the code below as given in the problem.md file
public class LuckyRegistrationNumber {

   
    private static Scanner scan;

	public static int checkRegistrationNumber(String regNumber) {
    	
    	if(regNumber==null||regNumber.equals("")) {
    		return -1;
    	}

    	final String state=regNumber.substring(0, 2);
    	final String stateNum=regNumber.substring(2,4);
    	String dist = null;
    	String distNumber = null;
    	if(regNumber.length()==10) {
    	 dist=regNumber.substring(4,6);
    	 distNumber=regNumber.substring(6,10);
    	}
    	else{
    		 dist=regNumber.substring(4,5);
        	 distNumber=regNumber.substring(5,9);
    	}
    	
    	if(("KA".equalsIgnoreCase(state)||"DL".equalsIgnoreCase(state))&&
    			(stateNum.matches("^[1][0]*$")||stateNum.matches("^[0][1-9]*$")) &&
    			(dist.matches("^[a-zA-Z]*$")) &&
    			(distNumber.matches("^[1-9][0-9]*$"))
    			) {
    		int sum=0;
    		int lastnumber=Integer.parseInt(distNumber);
    		
        	while(lastnumber>0) {
        		int lastNum=lastnumber%10;
        		sum=sum+lastNum;
        		lastnumber=lastnumber/10;	
        	}
        	int lucky=0;
        	if(sum/10==0) 
        		lucky=sum;
        	else {
        		while(sum>0) {
            		int lastnumber1=sum%10;
            		lucky=lucky+lastnumber1;
            		sum=sum/10;
            	}
        	}
        	
    		if(lucky==6)
    			return 1;
    		else 
    			return 0;
    	}
    	return -1;
    	    	
    }

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
    	scan = new Scanner(System.in);
    	final String regNum=scan.nextLine();
    	
    	int check=checkRegistrationNumber(regNum);    
    	if(check==1) {
    		System.out.println("Lucky Registration Number");
    	}
    	else if(check==0) {
    		System.out.println("Valid Registration Number");
    	}
    	else {
    		System.out.println("Invalid Registration Number");
    	}
    }

}