package Classes;

public class FixDepositSavingAccount extends SavingAccount{

    public FixDepositSavingAccount(String AccountID, String AccountNo, double Balance) {
        super(AccountID, AccountNo, Balance);
    }

    FixDepositSavingAccount() {
        super();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double getProfit(double amount) {
        if (amount>limit){
            profit=amount*0.15;
            return profit;
        }
        return 0;
    }
}
