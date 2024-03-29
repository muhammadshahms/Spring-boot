package com.example.demo.controller;

import com.example.demo.dto.ClubDto;
import com.example.demo.models.Club;
import com.example.demo.services.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "index";
    }

    @GetMapping("/club")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "club/club-list";
    }

    @GetMapping("/club/new")
    public String newClub(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "club/club-create";
    }

    @PostMapping("/club/new")
    public String saveClub(@ModelAttribute("club") Club club) {
        clubService.saveClub(club);
        return "redirect:/club";
    }


    @GetMapping("/club/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "club/club-edit";
    }

    @PostMapping("/club/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "club/club-edit";
        }

        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/club";
    }

    @GetMapping("/club/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId) {
        clubService.deleteClub(clubId);
        return "redirect:/club";
    }

    @GetMapping("/club/search")
    public String searchClubs(@RequestParam("query") String query, Model model) {
        List<ClubDto> clubs = clubService.findByQuery(query);

        if (clubs.isEmpty()) {
            model.addAttribute("message", "No clubs found.");
        } else {
            model.addAttribute("clubs", clubs);
        }

        return "club/club-list";
    }

    @GetMapping("/club/{clubId}")
    public String viewClub(@PathVariable("clubId") Long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "club/club-view";
    }
}


