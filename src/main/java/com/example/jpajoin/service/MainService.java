package com.example.jpajoin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.jpajoin.dto.MemberDto;
import com.example.jpajoin.dto.TeamDto;
import com.example.jpajoin.entity.Member;
import com.example.jpajoin.entity.Team;
import com.example.jpajoin.repository.MemberRepository;
import com.example.jpajoin.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MemberRepository memberRepository;

    ModelMapper modelMapper = new ModelMapper();

    public void regTeam(Team team) throws Exception {
        teamRepository.save(team);
    }

    public List<TeamDto> teamList() throws Exception {
        List<Team> list= teamRepository.findAll();
        List<TeamDto> teamList = new ArrayList<>();
        for(Team t :list) {
            teamList.add(new TeamDto(t.getId(),t.getName()));
        }
        return teamList;
    }

    public List<MemberDto>
    memberList(String teamName) throws Exception {
        Optional<Team> oteam =
                teamRepository.findByName(teamName);
        if(oteam.isEmpty()) throw new Exception("팀명 오류");
        Team team = oteam.get();
        List<Member> list= team.getMembers();
        List<MemberDto> members = new ArrayList<>();
        for(Member m: list) {
            members.add(new MemberDto(m.getId(),m.getName(),
                    team.getId(), team.getName()));
        }
        return members;
    }
}
