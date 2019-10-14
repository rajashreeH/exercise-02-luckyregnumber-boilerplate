## Problem Statement: Lucky Registration Number

**Given a vehicle registration number, find whether it is valid, invalid or lucky registration number**

**This exercise contains a class named LuckyRegistrationNumber with the following static method:**

     checkRegistrationNumber(String):int     

- The input parameter is a vehicle registration number and the output is -1, 0 or 1 based on below given rules.
- If the Vehicle registration number is valid as per the below format the method should return 0, else -1 

    PPXXQQYYYY
    PP - Should be either KA or DL
    XX - Number from 01 to 10
    QQ - 1 or 2 alphabets from A-Z(uppercase)
    YYYY - Number from 1000 to 9999 
    Ex: KA01MG2323, DL10G5454
- Method should return 1, if the registration number is valid, and last 4 digits add up to a lucky number. When last 4 digits are repeatedly added(see below) and the sum is 6, it is a lucky number
    
    KA01MG8484
    8+4+8+4 = 24 -> 2 + 4 = 6 (Lucky number)
    
     
- If the input string is empty or null, the method should return -1.

**Do the following in the main method of LuckyRegistrationNumber**

1. Accept Registration number from the console
2. If the Registration number is invalid, display **Invalid Registration number**
3. If the Registration number is Valid but not lucky, display **Valid Registration number**
4. If the Registration number is Valid and lucky, display **Lucky Registration number**

## Example
    Sample Input:
    KA01MG2130
    
    Expected Output:
    Lucky Registration number
--------------------------------------------------------
    Sample Input:
    KA09GG1234
    
    Expected Output:
    Valid Registration number
--------------------------------------------------------
    Sample Input:
    DL10G4839
    
    Expected Output:
    Lucky Registration number
--------------------------------------------------------
    Sample Input:
    KA01GM0839
    
    Expected Output:
    Invalid Registration number

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding