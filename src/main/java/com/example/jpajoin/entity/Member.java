package com.example.jpajoin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
