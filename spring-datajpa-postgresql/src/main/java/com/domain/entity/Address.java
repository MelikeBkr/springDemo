package com.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable
{
    @Id
    //allocationSize corresponds to increment amount
    //In example will increment by 1
    @SequenceGenerator(name="seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(length = 500, name="address")
    private String address;
    @Enumerated
    private AddressType addressType;
    @Column(name="active")
    private boolean isActive;
    //for assigning an address/es to a person
    @ManyToOne
    @JoinColumn(name="person_address_id")
    private Person person;
    public enum AddressType
    {
        HOME,
        OFFICE,
        OTHER
    }
}
