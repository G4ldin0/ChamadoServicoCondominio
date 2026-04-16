package com.dunnas.ChamadoServicoCondominio.Infra.Controllers;

import com.dunnas.ChamadoServicoCondominio.Application.UseCases.AuthenticateUserUseCase;
import com.dunnas.ChamadoServicoCondominio.Application.UseCases.CreateUserUseCase;
import com.dunnas.ChamadoServicoCondominio.Domain.Core.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CreateUserUseCase createUseruseCase;

    @GetMapping("/home")
    public String home(Model model) {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user.name", user.getName());
        model.addAttribute("user.login", user.getLogin());
        model.addAttribute("user.role", user.getRole());
        return "admin/home";
    }

    @GetMapping("/moradores")
    public String usersList() {
        return "admin/UsersList";
    }

    @PostMapping("/moradores")
    public String createUser(@ModelAttribute UserEntity user) {
        createUseruseCase.execute(user);
        return "redirect:/admin/moradores";

    }

    @GetMapping("/colaboradores")
    public String workersList() {
        return "admin/WorkersLists";
    }

    @GetMapping("/blocos")
    public String listBlocks() {
        return "admin/ListBlocks";
    }
}

