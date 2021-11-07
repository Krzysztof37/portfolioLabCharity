package pl.coderslab.charity.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.utils.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private static UserRepository userRepository;

    public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
    }

    @GetMapping("/add/user")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        System.out.println("dupa");
        return "addUserForm";
    }
    @PostMapping("/add/user")
    public String addUserPost(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return "addUserForm";
        }
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "loginForm";
    }
    @PostMapping("/login")
    public String loginPost(@Param("email") String email, @Param("password") String password, HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            session.setAttribute("user", user);
            return "redirect:/";
        }

        return "redirect:/login";
    }


}
