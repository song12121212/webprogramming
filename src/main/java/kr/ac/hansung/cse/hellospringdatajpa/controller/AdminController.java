package kr.ac.hansung.cse.hellospringdatajpa.controller;

import kr.ac.hansung.cse.hellospringdatajpa.entity.MyUser;
import kr.ac.hansung.cse.hellospringdatajpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public String viewUserList(Model model) {
        List<MyUser> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "admin_users";
    }
}
