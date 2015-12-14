package Classes;

import Exceptions.LowBalanceException;


public class Transaction {
    public static void fundsTransfer(Account src, Account dest, double amount) throws Exception{
        boolean status=true;
        while (status){
            try {
                if(amount>500){
                src.subBalance(amount);
                status=false;
                }
                else throw new LowBalanceException();
            }catch(LowBalanceException e){
                System.out.println(e.getMessage());
            }
        }
        dest.AddBalance(amount);
    }
}
