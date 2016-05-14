package ro.academy.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.academy.model.accounts.Account;

/**
 * Created by Gustavo on 14/05/2016.
 */

@Controller
public class AccountController {

    @RequestMapping
    public String createAccount() {
        return "createNewAccount";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(Account account) {
        System.out.println(account);
        return "nonValid";
    }
}
