package com.driver;
import java.util.Random;


public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private Random number;

    public BankAccount(String name, double balance, double minBalance) {
             this.name=name;
             this.balance=balance;
             this.minBalance=minBalance;
             this.number=new Random();
    }

    

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public double getBalance() {
        return balance;
    }



    public void setBalance(double balance) {
        this.balance = balance;
    }



    public double getMinBalance() {
        return minBalance;
    }



    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }



    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        
            for(int i=0; i<digits; i++){
                int n=number.nextInt(10)+0;
            }
            int num=n;
            int sumdigit=0;
            while(num!=0){
                int r=num%10;
                sumdigit+=r;
                num=num/10;
            }
            if(sumdigit==sum){
                return Integer.toString(n);
            }
            else{
                   throw new Exception("Account Number can not be generated");
                }
            
        
        
             
       
        //return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance=this.balance+amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
            if(minBalance<balance){
                balance=balance-amount;
                System.out.println(amount+"Amount has been deducted");
            }
            else{
                throw  new Exception("Insufficient Balance");
            }
    }

}