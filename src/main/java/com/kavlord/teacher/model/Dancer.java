package com.kavlord.teacher.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "dancer")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
    @Email
    private String email;
    @ManyToMany(mappedBy = "dancers")
    private List<Group> groups;
    @ManyToMany
    @JoinTable(name = "presence",
            joinColumns = @JoinColumn(name = "dancerId"),
            inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private List<Lesson> presence;
}
