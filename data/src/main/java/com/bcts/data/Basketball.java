package com.bcts.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Basketball {

    @Autowired
    private DataRepository dataRepository;

    // Fetch all teams from MongoDB
    public List<Team> getTeams() {
        List<Team> teams = dataRepository.findAll();
        return teams;  
      }

    // Filter teams by capacity
    public List<Team> filterTeamsByCapacity(int capacity) {
        List<Team> allTeams = dataRepository.findAll();
        List<Team> filteredTeams = new ArrayList<>();

        for (Team team : allTeams) {
            if (team.getCapacity() >= capacity) {
                filteredTeams.add(team);
            }
        }

        return filteredTeams;
    }

    // Find the most common arena location
    public String findMostCommonArena() {
        List<Team> allTeams = dataRepository.findAll();
        if (allTeams.isEmpty()) {
            return "No teams available";
        }

        List<String> locations = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (Team team : allTeams) {
            String location = team.getLocation();
            if (locations.contains(location)) {
                int index = locations.indexOf(location);
                counts.set(index, counts.get(index) + 1);
            } else {
                locations.add(location);
                counts.add(1);
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > counts.get(maxIndex)) {
                maxIndex = i;
            }
        }

        return locations.get(maxIndex);
    }
}
