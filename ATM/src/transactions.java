import java.util.Scanner;
import java.text.DecimalFormat;

public class transactions {
    Scanner input = new Scanner(System.in);
    DecimalFormat bankmoneyformat = new DecimalFormat("'£'###,##0.00"); // so 0.00 will be shown when balance is 0
    public double balance = 0;
    public double savings = 0;
    public double customerNumber;
    public double customerPin;

    public void getCheckingWithdrawInput() {
        System.out.println("Your current balance: " + bankmoneyformat.format(balance));
        System.out.print("Amount you want to withdraw from your balance: ");
        double amount = input.nextDouble();

        if ((balance - amount) >= 0) {
            calsAfterWithdrawChecking(amount);
            System.out.println("New Checking Account balance: " + bankmoneyformat.format(balance) + "\n");
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void withdrawfromSavings(){
        System.out.println("Current savings: " + bankmoneyformat.format(savings));
        System.out.println("How much many would you like the withdraw from your savings: ");
        double moneytowithdraw = input.nextDouble();
        if(savings >= moneytowithdraw){
            calsAfterWithdrawSavings(moneytowithdraw);
            System.out.println("New savings: "+ bankmoneyformat.format(savings));
        } else {
            System.out.println("The amount of money you want to withdraw is too much for your savings. \n");
        }
    }
    public void deposittoBalance(){
        System.out.println("Current balance: "+ bankmoneyformat.format(balance));
        System.out.println("How much money you want to deposit: ");
        double moneytodeposit = input.nextDouble();
        if(balance + moneytodeposit >= 0){
            calcAfterDepositChecking(moneytodeposit);
            System.out.println("New balance: "+ bankmoneyformat.format(balance));
        } else {
            System.out.println("Balance cannot be negative \n");
        }
    }
    public void deposittoSavings(){
        System.out.println("Current saving balance: "+ bankmoneyformat.format(savings));
        System.out.println("How much money you want to deposit: ");
        double moneytodeposit = input.nextDouble();
        if(savings + moneytodeposit >= 0){
            calcAfterDepositSavings(moneytodeposit);
            System.out.println("New saving balance: "+ bankmoneyformat.format(savings));
        } else {
            System.out.println("Savings account cannot be negative \n");
        }
    }
    public void transportFromChecktoSavings(){
        System.out.println("Checking balance: "+ bankmoneyformat.format(balance));
        System.out.println("Savings balance: "+ bankmoneyformat.format(savings));
        System.out.println("How much money  would you like to transfer to your savings from your Checking: ");
        double moneytransfer = input.nextDouble();
        if(moneytransfer > balance){
            System.out.println("Balance cannot be negative! ");
            return;
        }
        calsAfterWithdrawChecking(moneytransfer);
        calcAfterDepositSavings(moneytransfer);
    }
    public void transportFromSavingstoCheckings(){
        System.out.println("Checking balance: "+ bankmoneyformat.format(balance));
        System.out.println("Savings balance: "+ bankmoneyformat.format(savings));
        System.out.println("How much money  would you like to transfer to your Checking from your savings: ");
        double moneytransfer = input.nextDouble();
        if(moneytransfer > savings){
            System.out.println("Savings cannot be negative! ");
            return;
        }
        calsAfterWithdrawSavings(moneytransfer);
        calcAfterDepositChecking(moneytransfer);
    }
    public double setCustomerNumber(double customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }
    public double getCustomerNumber(){
        return customerNumber;
    }
    public double setPinNumber(double customerPin){
        this.customerPin = customerPin;
        return customerPin;
    }
    public double getCustomerPin(){
        return customerPin;
    }
    public void getBalance(){
        if(balance == 0) {
            System.out.println("£0,00");
            return ;
        }
        System.out.println(bankmoneyformat.format(balance));
    }
    public void getSavingBalance(){
        if(balance == 0){
            System.out.println("£0,00");
            return ;
        }
        System.out.println(bankmoneyformat.format(savings));
    }
    public double calsAfterWithdrawChecking(double amount){
        balance = (balance - amount);
        return balance;
    }
    public double calsAfterWithdrawSavings(double amount){
        savings = (savings - amount);
        return savings;
    }
    public double calcAfterDepositChecking(double amount){
        balance = (balance + amount);
        return balance;
    }
    public double calcAfterDepositSavings(double amount){
        savings = (savings + amount);
        return savings;
    }
}
