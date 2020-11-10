package com.domain.dto;

import com.domain.entity.Address;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
@Data
public class PersonDto
{
    private long id;
    private String name;
    private String surname;
    List<String> addressList;
}
