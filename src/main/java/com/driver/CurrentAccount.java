package com.driver;

import java.util.Arrays;


public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
          super(name, balance, 5000);
          this.tradeLicenseId=tradeLicenseId;
          if(balance<getMinBalance()){
            throw new Exception("Insufficient Balance");
       }
    }

    

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(Rearrangeable(tradeLicenseId)==false){
            throw new Exception("Valid License can not be generated");
        }
    }
        
    public  boolean check(String tradeLicenseId){
        
        for(int i=1; i<tradeLicenseId.length(); i++){
            char ch=tradeLicenseId.charAt(i-1);
            if(ch==tradeLicenseId.charAt(i)){
                return false;
            }
         }
         return true;
        }
    public boolean Rearrangeable(String str){
          String odd="";
          String even="";
          for(int i=0; i<str.length(); i++){
              if(str.charAt(i)%2==0){
                even+=str.charAt(i);
              }
              else{
                odd+=str.charAt(i);
              }
          }
          char[] s1=even.toCharArray();
          Arrays.sort(s1);
          even=new String();
          even=s1.toString();
          char [] s2=odd.toCharArray();
          Arrays.sort(s2);
          odd=new String();
          odd=s2.toString();

          if(check(even+odd)  || check(odd+even)){
                 return true;
          }
          return false;
    }
         
         
   
        
       
    

}
