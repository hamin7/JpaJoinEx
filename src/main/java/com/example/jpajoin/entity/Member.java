package com.example.jpajoin.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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

    @Builder
    public Member(Integer id, String name) {
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Member["+id+":"+name+":"+team.getName()+"]";
    }
}
