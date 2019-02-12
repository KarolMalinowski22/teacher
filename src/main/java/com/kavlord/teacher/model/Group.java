package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity(name = "group")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String town;
    private String description;
    @ManyToMany
    @JoinTable(name = "groups_membership",
    joinColumns = @JoinColumn(name = "groupId"),
    inverseJoinColumns = @JoinColumn(name = "dancerId"))
    private List<Dancer> dancers;
}
