package springSecurityLogin.com.example.springsecuritylogin;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class ParentController {
    @GetMapping("/welcome")
    public String userWelcomePage() {
        return "welcome";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            System.out.println(authentication.getName());
            return "welcome";
        }

        return "login";
    }
}
