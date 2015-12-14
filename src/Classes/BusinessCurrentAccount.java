package Classes;

import Exceptions.LowBalanceException;

public class BusinessCurrentAccount extends CurrentAccount{

    public BusinessCurrentAccount(String AccountID, String AccountNo, double Balance) throws LowBalanceException {
        super(AccountID, AccountNo, Balance);
        
    }

    BusinessCurrentAccount() {
        super();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
