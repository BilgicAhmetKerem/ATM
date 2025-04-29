
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class menu extends transactions{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat bankmoneyformat = new DecimalFormat("'£'###,###,##0,00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public void login(){
        boolean success = false;
        do{
            try{
                data.put(9876, 987);
                data.put(1234, 123);

                System.out.println("Welcome to BilgicKasse! ");

                System.out.println("Please enter your user ID-Number: ");
                System.out.println("If you dont have an account enter 1 to create one.");
                if(menuInput.nextInt() == 1){
                    System.out.println("\n");
                }
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Please enter your password: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\n Invalid Character(s). Please enter only numbers! \n");
            }
            for(Entry<Integer, Integer> entry : data.entrySet()){
                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getCustomerPin()){
                    getAccountType();
                }
            }
            System.out.println("Wrong customer id-number or password... ");
        } while(!success);
    }
    public void getAccountType(){
        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 to check the checking account");
        System.out.println("Type 2 to check the saving account");
        System.out.println("Type 3 to exit \n");
        System.out.println("Please enter your choice: ");
        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thanks for using BilgicKasse");
                break;
            default:
                System.out.println("\n Invalid Choice!\n");
                getAccountType();
        }
    }
    public void getChecking(){
        System.out.println("Checking account: ");
        System.out.println("Type 1 to view the balance");
        System.out.println("Type 2 to withdraw the funds");
        System.out.println("Type 3 to deposit funds");
        System.out.println("Type 4 to transfer money from savings to Checkings");
        System.out.println("Type 5 to transfer money from Checkings to savings");
        System.out.println("Type 6 to exit");
        System.out.println("Choice: ");
        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getBalance();
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;
            case 3:
                deposittoBalance();
                getChecking();
            case 4:
                transportFromSavingstoCheckings();
                getSavings();
            case 5:
                transportFromChecktoSavings();
                getSavings();
            case 6:
                getAccountType();
                break;
            default:
                System.out.println("\n Invalid Choice!\n");
                getChecking();
        }
    }
    public void getSavings(){
        System.out.println("Checking account: ");
        System.out.println("Type 1 to view the balance");
        System.out.println("Type 2 to withdraw the funds");
        System.out.println("Type 3 to deposit funds");
        System.out.println("Type 4 to transfer money from savings to Checkings");
        System.out.println("Type 5 to transfer money from Checkings to savings");
        System.out.println("Type 6 to exit");
        System.out.println("Choice: ");
        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getSavingBalance();
                getSavings();
                break;
            case 2:
                withdrawfromSavings();
                getSavings();
                break;
            case 3:
                deposittoSavings();
                getSavings();
            case 4:
                transportFromSavingstoCheckings();
                getSavings();
            case 5:
                transportFromChecktoSavings();
                getSavings();
            case 6:
                getAccountType();
                break;
            default:
                System.out.println("\n Invalid Choice!\n");
                getChecking();
        }
    }
}

