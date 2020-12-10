package com.neosuniversity.jpa.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="TBL_EMPLOYEES")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @ManyToOne()
    private Rol rol;


}
