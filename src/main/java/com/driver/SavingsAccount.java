package com.driver;
public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0.0);
        this.maxWithdrawalLimit=1000000.0;
        this.rate=0.05;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
         if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
         }
         if(amount>super.getBalance()){
            throw new Exception("Insufficient Balance");
         }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
         double r=super.getBalance()*rate*years;
         double finalamount=super.getBalance()+r;
         return finalamount;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
             double A=super.getBalance()*Math.pow((1+rate),years);
             double compuntInterest=A+super.getBalance();
             return compuntInterest;
    }

}
