package com.example.demo.controller;

import com.example.demo.dto.ClubDto;
import com.example.demo.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService ;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();

        model.addAttribute("clubs", clubs);
        return "club-list";
    }
}
