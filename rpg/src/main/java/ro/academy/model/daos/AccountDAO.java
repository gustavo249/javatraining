package ro.academy.model.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.academy.model.accounts.Account;

/**
 * Created by Gustavo on 16/05/2016.
 */

@Repository
public interface AccountDAO extends JpaRepository<Account, Long> {
}
