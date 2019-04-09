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
@Entity(name = "dancer")
public class Dancer extends Person{
    {
        groups = new ArrayList<>();
    }
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
    @ManyToMany
    @JoinTable(name = "class_membership",
            joinColumns = @JoinColumn(name = "dancerId"),
            inverseJoinColumns = @JoinColumn(name = "classId"))
    private List<Group> groups;
    @ManyToMany(mappedBy = "presence")
    private List<Lesson> presence;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;
    public static Dancer empty(){
        Dancer dancer = new Dancer();
        dancer.setFirstName("");
        dancer.setLastName("");
        dancer.setEmail("");
        return dancer;
    }
}
