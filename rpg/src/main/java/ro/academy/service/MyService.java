package ro.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.academy.model.accounts.Account;
import ro.academy.model.daos.AccountDAO;

/**
 * Created by Gustavo on 14/05/2016.
 */
@Service
public class MyService {

    @Autowired
    private AccountDAO accountsDAO;


    public void addAccount(Account account) { accountsDAO.save(account);
    }

    public Iterable<Account> getAllAccounts() {
        return accountsDAO.findAll();
    }


    public Account getAccount(String username) {
        return accountsDAO.findOne(username);
    }


    public void delete(String username) {
         accountsDAO.delete(username);
    }



}
