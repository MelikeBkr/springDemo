package com.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Person
{
    @Id
    @SequenceGenerator(name="seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(length = 50, name="name")
    private String name;
    @Column(length = 50, name="surname")
    private String surname;

    @OneToMany
    @JoinColumn(name="person_address_id")
    List<Address> addressList;
}
