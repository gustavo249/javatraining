package ro.academy.model.base;

import ro.academy.model.accounts.Account;

import java.util.List;

/**
 * Created by Gustavo on 14/05/2016.
 */
public interface UsersCRUD {
    boolean addAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccount(String username);
    int update(Account account);
    boolean delete(int id, String table);
}
