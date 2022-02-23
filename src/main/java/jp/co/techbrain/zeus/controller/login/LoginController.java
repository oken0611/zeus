package jp.co.techbrain.zeus.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String getLogin(){
        return "login/login";
    }

    @PostMapping
    public String postLogin(){
        return "redirect:/top/top";
    }
}
