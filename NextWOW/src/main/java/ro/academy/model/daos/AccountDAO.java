package ro.academy.model.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ro.academy.model.accounts.Account;
import ro.academy.model.base.UsersCRUD;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Gustavo on 14/05/2016.
 */
@Component
public class AccountDAO implements UsersCRUD {
    private List<Account> accounts;
    private NamedParameterJdbcTemplate parameterJdbcTemplate;



    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.parameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean addAccount(Account account) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
        return parameterJdbcTemplate.update("INSERT into accounts VALUES (:username, :password, :email, :name)", params) == 1;
    }

    @Override
    public List<Account> getAllAccounts() {
        return parameterJdbcTemplate.query("SELECT * FROM accounts", (resultSet, i) -> {
            return createAccount(resultSet);
        });
    }

    @Override
    public Account getAccount(String username) {
        MapSqlParameterSource params = new MapSqlParameterSource("username", username);
        return parameterJdbcTemplate.queryForObject("SELECT * FROM accounts WHERE username=:username", params, (resultSet, i) -> {
            return createAccount(resultSet);
        });
    }

    private Account createAccount(ResultSet resultSet) throws SQLException {
        return new Account(resultSet.getString("username"), resultSet.getString("password"),
                resultSet.getString("email"), resultSet.getString("name"));
    }

    @Override
    public int update(Account account) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
        return parameterJdbcTemplate.update("UPDATE accounts SET (username=:username, password=:password, email=:email, name=:name) " +
                "WHERE  id=:id", params);
    }

    @Override
    public boolean delete(int id, String table) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return parameterJdbcTemplate.update("DELETE FROM accounts WHERE id=:id", params) == 1;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

}
