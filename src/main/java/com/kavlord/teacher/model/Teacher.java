package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "teacher")
public class Teacher extends Person{
    {
        groups = new ArrayList<>();
    }
    @ManyToMany
    @JoinTable(name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacherId"),
            inverseJoinColumns = @JoinColumn(name = "classId"))
    private List<Group> groups;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_lesson",
            joinColumns = @JoinColumn(name = "teacherId"),
            inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private List <Lesson> lessons;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    public static Teacher empty(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("");
        teacher.setLastName("");
        teacher.setEmail("");
        return teacher;
    }
}
