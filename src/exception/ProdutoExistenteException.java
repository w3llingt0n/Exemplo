/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author rapwe
 */
public class ProdutoExistenteException extends Exception{
    public ProdutoExistenteException(String message){
        super(message);
    }
    
}
