package com.example.jpajoin.controller;

import com.example.jpajoin.entity.Team;
import com.example.jpajoin.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/regTeam")
    @ResponseBody
    public ResponseEntity<String> regTeam(@ModelAttribute Team team){
        try {
            teamService.regTeam(team);
            return new ResponseEntity<String>("팀 등록 성공", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("팀 등록 실패", HttpStatus.BAD_REQUEST);
        }
    }
}
