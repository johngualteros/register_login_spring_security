package controller;

import com.register_users.register_login_spring_security.dto.UserRegisterDTO;
import com.register_users.register_login_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public UserRegisterDTO returnNewUserRegisterDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showFormRegister(){
        return "register";
    }
    @PostMapping
    public String registerAccountUser(@ModelAttribute("user") UserRegisterDTO registerDto){
        userService.save(registerDto);
        return "redirect:/register?successful";
    }
}
