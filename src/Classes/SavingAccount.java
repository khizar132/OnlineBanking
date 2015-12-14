package Classes;

import Exceptions.AmountCannotSubractException;

public abstract class SavingAccount extends Account{
    double profit, limit=50000;
    public SavingAccount(){
        super();
    }
    public SavingAccount(String AccountID, String AccountNo, double Balance) {
        super(AccountID, AccountNo, Balance);
    }

    void subBalance(double Amount) throws Exception{
        throw new AmountCannotSubractException("Your account is saving account and you cannot transact an amount from a saving account");
    }
    abstract double getProfit(double amount);
    
}
