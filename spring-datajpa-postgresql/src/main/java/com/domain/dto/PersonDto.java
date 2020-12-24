package com.domain.dto;

import lombok.Data;

import java.util.List;
@Data
public class PersonDto
{
    private long id;
    private String name;
    private String surname;
    List<String> addressList;
}
