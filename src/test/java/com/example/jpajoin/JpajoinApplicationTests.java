package com.example.jpajoin;

import com.example.jpajoin.entity.Member;
import com.example.jpajoin.entity.Team;
import com.example.jpajoin.repository.MemberRepository;
import com.example.jpajoin.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JpajoinApplicationTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;
    @Test
    void insertTeam() {
        Team team = Team.builder().id(3).name("SK").build();
        teamRepository.save(team);
    }

    @Test
    void selectMember() {
        Member member = memberRepository.findById(10).get();
        System.out.println(member);
    }

    @Test
    void insertMember() {
        Team team = teamRepository.findByName("KT");
        Member member = new Member(11, "GoYoungPyo", team);
        memberRepository.save(member);
    }
}
