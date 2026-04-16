package com.dunnas.ChamadoServicoCondominio.Infra.Controllers;

import com.dunnas.ChamadoServicoCondominio.Application.UseCases.CreateUserUseCase;
import com.dunnas.ChamadoServicoCondominio.Application.UseCases.ListAllUsersUseCase;
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
    @Autowired
    private ListAllUsersUseCase listAllUsersUseCase;

    private void addLoggedUserToModel(Model model) {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
    }

    @GetMapping("/home")
    public String home(Model model) {
        addLoggedUserToModel(model);
        return "admin/home";
    }

    @GetMapping("/moradores")
    public String usersList(Model model) {
        addLoggedUserToModel(model);
        model.addAttribute("userList", listAllUsersUseCase.execute());
        return "admin/UsersList";
    }

    @PostMapping("/moradores")
    public String createUser(@ModelAttribute UserEntity user) {
        createUseruseCase.execute(user);
        return "redirect:/admin/moradores";
    }

    @GetMapping("/colaboradores")
    public String workersList(Model model) {
        addLoggedUserToModel(model);
        return "admin/WorkersLists";
    }

    @GetMapping("/blocos")
    public String listBlocks(Model model) {
        addLoggedUserToModel(model);
        return "admin/ListBlocks";
    }

    @GetMapping("/administradores")
    public String listAdmins(Model model) {
        addLoggedUserToModel(model);
        return "admin/AdminsList";
    }
}
