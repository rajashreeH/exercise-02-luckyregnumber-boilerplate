package com.stackroute;

import java.util.Scanner;

//Complete the code below as given in the problem.md file
public class LuckyRegistrationNumber {

   
    public static int checkRegistrationNumber(String regNumber) {
    	
    	if(regNumber==null||regNumber.equals("")) {
    		return -1;
    	}

    	String state=regNumber.substring(0, 2);
    	String stateNum=regNumber.substring(2,4);
    	String dist = null,distNumber = null;
    	if(regNumber.length()==10) {
    	 dist=regNumber.substring(4,6);
    	 distNumber=regNumber.substring(6,10);
    	}
    	else if(regNumber.length()==9){
    		 dist=regNumber.substring(4,5);
        	 distNumber=regNumber.substring(5,9);
    	}
    	else {
    		return -1;
    	}
    	/*System.out.println("state:"+state);
    	System.out.println("stateNum:"+stateNum);
    	System.out.println("dist:"+dist);
    	System.out.println("distNum:"+distNumber);
    	*/
    	
    	if((state.equalsIgnoreCase("KA")||state.equalsIgnoreCase("DL"))&&
    			(stateNum.matches("^[1][0]*$")||stateNum.matches("^[0][1-9]*$")) &&
    			(dist.matches("^[a-zA-Z]*$")) &&
    			(distNumber.matches("^[1-9][0-9]*$"))
    			) {
    		int sum=0;
    		int lastnumber=Integer.parseInt(distNumber);
    		
        	while(lastnumber>0) {
        		int n=lastnumber%10;
        		sum=sum+n;
        		lastnumber=lastnumber/10;	
        	}
        	int lucky=0;
        	if(sum/10==0) {
        		lucky=sum;
        	}
        	else {
        		while(sum>0) {
            		int n=sum%10;
            		lucky=lucky+n;
            		sum=sum/10;
            	}
        	}
        	
    		if(lucky==6) {
    			return 1;
    		}
    		else {
    			return 0;
    		}
    	}
    	return -1;
    	
    	

    	
    }

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
    	//Use Scanner to get input from console
    	Scanner scan=new Scanner(System.in);
    	String regNum=scan.nextLine();
    	
    	
    	
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