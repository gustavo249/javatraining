package ro.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.academy.model.accounts.Account;
import ro.academy.model.base.UsersCRUD;
import ro.academy.model.daos.AccountDAO;

import java.util.List;

/**
 * Created by Gustavo on 14/05/2016.
 */
@Service
public class MyService implements UsersCRUD{
    @Autowired
    private AccountDAO accountsDAO;

    @Override
    public boolean addAccount(Account account) {
        return accountsDAO.addAccount(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountsDAO.getAllAccounts();
    }

    @Override
    public Account getAccount(String username) {
        return accountsDAO.getAccount(username);
    }

    @Override
    public int update(Account account) {
        return accountsDAO.update(account);
    }

    @Override
    public boolean delete(int id, String table) {
        return accountsDAO.delete(id, table);
    }
}
