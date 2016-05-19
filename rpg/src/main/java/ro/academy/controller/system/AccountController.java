package ro.academy.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.academy.model.accounts.Account;
import ro.academy.service.MyService;

import javax.validation.Valid;

/**
 * Created by Gustavo on 14/05/2016.
 */

@Controller
public class AccountController {

    @Autowired
    private MyService service;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(@ModelAttribute(value = "user") @Valid Account user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:registration";
        }
        if (foundInDb(user) == null) {
            service.addAccount(user);
        }
        return "valid";
    }

    private Account foundInDb(Account account) {
        return service.getAccount(account.getUsername());
    }

    public void setService(MyService service) {
        this.service = service;
    }
}
