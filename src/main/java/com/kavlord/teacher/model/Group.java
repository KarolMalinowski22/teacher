package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity(name = "class")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String town;
    private String address;
    private String description;
    @ManyToMany
    @JoinTable(name = "class_membership",
    joinColumns = @JoinColumn(name = "classId"),
    inverseJoinColumns = @JoinColumn(name = "dancerId"))
    private List<Dancer> dancers;
    @ManyToMany
    @JoinTable(name = "teacher_class",
            joinColumns = @JoinColumn(name = "classId"),
            inverseJoinColumns = @JoinColumn(name = "teacherId"))
    private List<Teacher> teachers;
}
