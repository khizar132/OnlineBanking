/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author khizar
 */
public class InvalidAccountException extends Exception{
    public InvalidAccountException(){
        super();
    }
    @Override
    public String getMessage(){
        return "Account does not exist... try again...";
    }
    
}
