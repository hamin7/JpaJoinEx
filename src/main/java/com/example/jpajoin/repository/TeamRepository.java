package com.example.jpajoin.repository;

import com.example.jpajoin.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    public Team findByName(String name);
}
