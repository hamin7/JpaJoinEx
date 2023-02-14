package com.example.jpajoin.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {
    @Id
    private Integer id;
    @Column
    private String name;

    @OneToMany(mappedBy = "team",
    targetEntity = Member.class,
    fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + id + ":" + name + "]";
    }
}
