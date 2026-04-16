package com.dunnas.ChamadoServicoCondominio.Infra.Controllers;

import com.dunnas.ChamadoServicoCondominio.Application.UseCases.AuthenticateUserUseCase;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthenticateUserUseCase authenticateUserUseCase;

    @Value("${api.security.jwt.expiration-hours}")
    private int expirationHour;

    @GetMapping
    public String login_page(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, HttpServletResponse response) {
        try {
            String token = authenticateUserUseCase.execute(login, password);
            if (token.isEmpty()) throw new RuntimeException("Invalid credentials");

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(expirationHour * 3600);
            response.addCookie(cookie);
            return "redirect:/home";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:/?error=true";
        }
    }

    @GetMapping("/home")
    public String redirectHome(){
        Collection<GrantedAuthority> auth = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if (auth == null) {
            System.out.println("User is not authenticated");
            return "redirect:/";
        }

        boolean isAdmin = auth.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "redirect:/admin/home";
        }

        boolean isMorador = auth.stream().anyMatch(a -> a.getAuthority().equals("ROLE_MORADOR"));
        boolean isColaborador = auth.stream().anyMatch(a -> a.getAuthority().equals("ROLE_COLABORADOR"));

        if (isMorador) {
            return "redirect:/morador/home";
        } else if (isColaborador) {
            return "redirect:/colaborador/home";
        } else {
            System.out.println("User has no recognized role");
            return "redirect:/";
        }
    }

}
