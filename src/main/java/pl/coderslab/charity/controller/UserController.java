package pl.coderslab.charity.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.utils.UserRepository;
import pl.coderslab.charity.utils.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private static UserRepository userRepository;
    private static UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
    }

    @GetMapping("/add/user")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUserForm";
    }

    @PostMapping("/add/user")
    public String addUserPost(@Valid User user, BindingResult result){

        if(result.hasErrors()){
            return "addUserForm";
        }
        User userWithRole = userService.addRoleToUser(user);
        userRepository.save(userWithRole);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "loginForm";
    }

//    @PostMapping("/login")
//    public String loginPost(@Param("email") String email, @Param("password") String password, HttpServletRequest req){
//        HttpSession session = req.getSession();
//        User user = userRepository.findByEmail(email);
//
//        if(user != null) {
//
//            if (user.getPassword().equals(password)) {
//                session.setAttribute("user", user);
//
//                return "redirect:/add/donation";
//            }
//        }
//
//        return "redirect:/login";
//    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        if(session.getAttribute("user") != null){
//            session.invalidate();
//        }
//        return "redirect:/";
//    }


}
