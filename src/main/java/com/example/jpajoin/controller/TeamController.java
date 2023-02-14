package com.example.jpajoin.controller;

import com.example.jpajoin.dto.TeamDto;
import com.example.jpajoin.entity.Team;
import com.example.jpajoin.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/regTeam")
    @ResponseBody
    public ResponseEntity<List<TeamDto>> regTeam(@ModelAttribute Team team){
        try {
            teamService.regTeam(team);
            List<TeamDto> teams = teamService.teamList();
            return new ResponseEntity<List<TeamDto>>(teams, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<TeamDto>>(HttpStatus.BAD_REQUEST);
        }
    }
}
