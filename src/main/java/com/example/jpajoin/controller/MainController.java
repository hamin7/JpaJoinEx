package com.example.jpajoin.controller;

import com.example.jpajoin.dto.MemberDto;
import com.example.jpajoin.dto.TeamDto;
import com.example.jpajoin.entity.Team;
import com.example.jpajoin.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @PostMapping("/regteam")
    public ResponseEntity<List<TeamDto>> regTeam(@ModelAttribute Team team) {
        ResponseEntity<List<TeamDto>> res = null;
        try {
            mainService.regTeam(team);
            res = new ResponseEntity<List<TeamDto>>(
                    mainService.teamList(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<List<TeamDto>>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }

    @GetMapping("/members/{teamName}")
    public ResponseEntity<List<MemberDto>> memberList(@PathVariable String teamName) {
        ResponseEntity<List<MemberDto>> res = null;
        try {
            List<MemberDto> list = mainService.memberList(teamName);
            res = new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<List<MemberDto>>(HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
