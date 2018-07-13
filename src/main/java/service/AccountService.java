/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Account;

/**
 *
 * @author phongdm
 */
public interface AccountService {
    public List<Account> getListAccount();
    
    public Account getAccount(String username);
    
    public boolean updateAccount(Account account);
    
    public boolean removeAccount(Account account);
}
