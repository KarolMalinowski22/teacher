package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="lesson")
class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;
    private Date date;
    private String description;
    @ManyToMany(mappedBy = "presence")
    private List<Dancer> presence;
    @ManyToMany(mappedBy = "lessons")
    private List<Teacher> teachers;
}
