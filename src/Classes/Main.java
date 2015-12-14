package Classes;

import Exceptions.*;
import ViewClasses.*;
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ObjectsDataHolder objData = new ObjectsDataHolder();
    static LoginView login = new LoginView();
    static String UserID, pass;
    static int index=-1;
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner cin = new Scanner (System.in);
    static FundsTransferViews fViews = new FundsTransferViews();
    static Account DestAcc;
    public static void main(String args[])throws Exception{
        setData();
        objData.saveAccountData(accounts);
        objData.saveCustomerData(customers);
        objData.retrieveCustomerData();
        objData.retrieveAccountData();
        while (true){
            if (login()){
                
                System.out.println(accounts.get(index).getBalance());
                FundsTransfer();
                System.out.println(accounts.get(index).getBalance());
                System.out.println(DestAcc.getBalance());
                
            } 
        }
    }
    public static boolean IdValidation(){
        for (Customer c: customers){
            if (c.getUserID().equalsIgnoreCase(UserID)){
                index=customers.indexOf(c);
                return true;
            }
        }return false;
    }
    public static boolean PasswordValidation(){
        if(customers.get(index).getPass().equalsIgnoreCase(pass)){
            return true;
        }
        return false;
    }
    public static boolean validateDestAccount(String DestAccNo){
        for (Account a: accounts){
            if (a.getAccountNo().equals(DestAccNo)){
                retrieveDestAccountData(accounts.indexOf(a));
                return true;
            }  
        }return false;
    }
    public static void setData() throws LowBalanceException{
        accounts.add(new BusinessCurrentAccount("12345", "9876", 89222));
        accounts.add(new RunningSavingAccount("23456","6677",1500000));
        accounts.add(new FixDepositSavingAccount("23454","6547",2300000));
        customers.add(new Customer("khizar lakhani","4250108608137","9876","khizar123","7860"));
        customers.add(new Customer("Mursal khan","4250108607683","6677","mask477","1234"));
        customers.add(new Customer("saqlain shoaib","4250106543137","6547","Shoaib566","0987"));
    }
    public static boolean login() throws InvalidLoginException{
        try{
            System.out.print("USER ID: ");
            UserID=cin.nextLine();
            System.out.print("PASSWORD: ");
            pass=cin.nextLine();
            if (!(IdValidation())){
                throw new InvalidLoginIdException();  
            }
            if (!(PasswordValidation())){
                throw new InvalidLoginPasswordException();
            }
        }catch(InvalidLoginIdException e){
            System.out.println(e.getMessage());
            return false;
        }catch(InvalidLoginPasswordException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static void FundsTransfer() throws Exception{
        String DestAccountNo="";double TransactionAmount = 0;
        while (true){
            try{
                fViews.AskInfo();
                DestAccountNo=fViews.getDestAccNo();
                TransactionAmount=fViews.getAmount(); 
                if (!validateDestAccount(DestAccountNo)){
                    throw new InvalidAccountException();
                }
                else {
                    Transaction.fundsTransfer(accounts.get(index), DestAcc, TransactionAmount);
                    break;
                }
            }catch(InvalidAccountException e){
                e.getMessage();
            }
        }
    } 

    private static void retrieveDestAccountData(int index) {
        if(accounts.get(index) instanceof BusinessCurrentAccount){
            DestAcc = new BusinessCurrentAccount();
        }
        if(accounts.get(index) instanceof PersonalCurrentAccount){
            DestAcc = new PersonalCurrentAccount();
        }
        if(accounts.get(index) instanceof RunningSavingAccount){
            DestAcc = new RunningSavingAccount();
        }
        if(accounts.get(index) instanceof FixDepositSavingAccount){
            DestAcc = new FixDepositSavingAccount();
        }
        DestAcc=accounts.get(index);
    }
}
    


