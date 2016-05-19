package ro.academy.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ro.academy.model.accounts.Account;

/**
 * Created by Gustavo on 14/05/2016.
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome() {
        return "welcomePage";
    }

    @RequestMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new Account());
        return "createNewAccount";
    }

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        return "welcomePage";
    }
}
