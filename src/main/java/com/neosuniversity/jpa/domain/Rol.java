package com.neosuniversity.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table (name = "TBL_ROL")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rol {

    @Id
    private Integer id;

    @Column(name = "ROL_NAME")
    private String rolName;

    @OneToMany(mappedBy="rol")
    @ToString.Exclude  private Set<Employee> employees;


}
