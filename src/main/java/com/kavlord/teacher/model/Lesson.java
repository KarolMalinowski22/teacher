package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;
    private Date date;
    private String description;
    @ManyToMany
    @JoinTable(name = "presence",
    joinColumns = @JoinColumn(name = "lessonId"),
    inverseJoinColumns = @JoinColumn(name = "dancerId"))
    private List<Dancer> presence;
    @ManyToMany
    @JoinTable(name = "teacher_lesson",
    joinColumns = @JoinColumn(name = "lessonId"),
    inverseJoinColumns = @JoinColumn(name = "teacherId"))
    private List<Teacher> teachers;
}
