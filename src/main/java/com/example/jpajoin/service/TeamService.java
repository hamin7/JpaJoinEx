package com.example.jpajoin.service;

import com.example.jpajoin.entity.Team;
import com.example.jpajoin.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void regTeam(Team team) throws Exception {
        Optional<Team> oTeam = teamRepository.findById(team.getId());
        if (oTeam.isEmpty()) {
            teamRepository.save(team);
        } else {
            throw new Exception("팀 중복");
        }
    }

}
