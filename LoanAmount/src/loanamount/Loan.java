package loanamount;

import java.util.Scanner;

public final class Loan {
    private double purchaseCost;
    private double annualIntRate;
    private double monthlyPayment;
    private double monthlyIntRate;
    private int months;
  
    Scanner scanner = new Scanner(System.in);
    
    public Loan(){
    }
    
    public double getMonthlyIntRate() {
        return monthlyIntRate;
    }

    public void setMonthlyIntRate(double monthlyRate) {
        monthlyIntRate = monthlyRate;
    }    
    public void calculateMonthlyIntRate() {
        monthlyIntRate = annualIntRate / 12/100;
    }
    
    public double calculateRemainingDebt(double remainingDebt) {
        double interest;
        if (remainingDebt > monthlyPayment) {
            interest = remainingDebt * monthlyIntRate;
            remainingDebt = remainingDebt  - (monthlyPayment - interest);
        }
            return remainingDebt;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(double cost) {
        if (cost > 0){
            purchaseCost = cost;
        } else {
            System.out.print("Please enter a valid purchase cost: $");
            cost = scanner.nextDouble();
            purchaseCost = cost;
        }
    } 
    
    public double getAnnualIntRate() {
        return annualIntRate;
    }

    public void setAnnualIntRate(double annualRate) {
        if (annualRate > 0){
            annualIntRate = annualRate;
            calculateMonthlyIntRate();
        } else {
            System.out.println("Please enter a valid interest rate: ");
            annualRate = scanner.nextDouble();
            annualIntRate = annualRate;
        }
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthPayment) {
        if (monthPayment > 0){
            monthlyPayment = monthPayment;
        } else {
            System.out.println("Please enter a valid monthly payment: $");
            monthPayment = scanner.nextDouble();
            monthlyPayment = monthPayment;
        }
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int remMonths) {
        months = remMonths;
    }
    
    
    @Override
    public String toString(){
        String output = "";
        String output2 = "";
        output +=  "\nLoan amount: $" + purchaseCost + "\n" +
               "Annual Interest Rate: " + annualIntRate  + "%\n" +
               "Monthly Interest Rate: " + monthlyIntRate + "%\n" +
               "Monthly payment: " + monthlyPayment + "\n\n" +
               "Loan \t\t Months \n" ;
               
        double debt = purchaseCost;
        months = 1;
        calculateRemainingDebt(debt);
        do { 
            debt = calculateRemainingDebt(debt);
            output2 += String.format("%-7.2f", debt)+ 
               "\t\t" + months++ +"\n";
        } while (debt > monthlyPayment);     
        
       return output + output2;
    }
}
    
    

    

