
package loanamount;

import java.util.Scanner;

public class LoanAmount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loan loan = new Loan();
        
        System.out.print("Enter purchase cost: $");
        loan.setPurchaseCost(scanner.nextDouble());
        System.out.print("Enter monthly payment: $");
        loan.setMonthlyPayment(scanner.nextDouble());
        System.out.print("Enter the interest rate: ");
        loan.setAnnualIntRate(scanner.nextDouble());
        
        System.out.println(loan.toString());
        
    }
    
}
