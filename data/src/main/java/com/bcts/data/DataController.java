package com.bcts.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    private Basketball service;

    @GetMapping("/")
    public String home(Model model) {
        List<Team> teams = service.getTeams();
        model.addAttribute("allTeams", teams);
        return "index";
    }

    @GetMapping("/teams")
    public String teams(Model model) {
        List<Team> teams = service.getTeams();
        model.addAttribute("allTeams", teams);
        return "teams";
    }

    @GetMapping("/arenas/compare")
    public String compare(Model model) {
        model.addAttribute("filteredTeams", List.of());
        return "compare";
    }

    @GetMapping("/arenas/filterByCapacity")
    public String filterByCapacity(@RequestParam("capacity") int capacity, Model model) {
        List<Team> filteredTeams = service.filterTeamsByCapacity(capacity);
        model.addAttribute("filteredTeams", filteredTeams);
        return "compare";
    }

    @GetMapping("/arenas/mostCommon")
    public String mostCommonArena(Model model) {
        String mostCommonLocation = service.findMostCommonArena();
        model.addAttribute("mostCommonArena", mostCommonLocation);
        model.addAttribute("filteredTeams", List.of());
        return "compare";
    }
}
