package com.example.jpajoin.repository;

import com.example.jpajoin.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    public Optional<Team> findByName(String name);
}
