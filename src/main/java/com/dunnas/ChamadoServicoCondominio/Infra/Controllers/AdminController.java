package com.dunnas.ChamadoServicoCondominio.Infra.Controllers;

import com.dunnas.ChamadoServicoCondominio.Application.UseCases.*;
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
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private CreateWorkerUseCase createWorkerUseCase;
    @Autowired
    private CreateAdminUseCase createAdminUseCase;

    @Autowired
    private ListAllUsersUseCase listAllUsersUseCase;
    @Autowired
    private ListAllAdminsUseCase listAllAdminsUseCase;
    @Autowired
    private ListAllWorkersUseCase listAllWorkersUseCase;


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
        createUserUseCase.execute(user);
        return "redirect:/admin/moradores";
    }

    @GetMapping("/colaboradores")
    public String workersList(Model model) {
        addLoggedUserToModel(model);
        model.addAttribute("workerList", listAllWorkersUseCase.execute());
        return "admin/WorkersLists";
    }

    @PostMapping("/colaboradores")
    public String createWorker(@ModelAttribute UserEntity user) {
        createWorkerUseCase.execute(user);
        return "redirect:/admin/colaboradores";
    }

    @GetMapping("/administradores")
    public String listAdmins(Model model) {
        addLoggedUserToModel(model);
        model.addAttribute("adminList", listAllAdminsUseCase.execute());
        return "admin/AdminsList";
    }
    @PostMapping("/administradores")
    public String createAdmin(@ModelAttribute UserEntity user) {
        createAdminUseCase.execute(user);
        return "redirect:/admin/administradores";
    }

    @GetMapping("/blocos")
    public String listBlocks(Model model) {
        addLoggedUserToModel(model);
        return "admin/ListBlocks";
    }
}
