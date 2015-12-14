/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewClasses;

import java.util.Scanner;

public class FundsTransferViews {
    Scanner cin = new Scanner (System.in);
    String destAccountNo; double amount;
    public void AskInfo(){
        System.out.println("Enter destination Account No: ");
        destAccountNo=cin.next();
        System.out.println("Enter Amount: ");
        amount=cin.nextDouble();
    }
    public String getDestAccNo(){
        return destAccountNo;
    }
    public double getAmount(){
        return amount;
    }
            
}