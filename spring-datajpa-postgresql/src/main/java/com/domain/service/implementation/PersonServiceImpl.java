package com.domain.service.implementation;

import com.domain.dto.PersonDto;
import com.domain.graphql.entity.Address;
import com.domain.graphql.entity.Person;
import com.domain.repository.AddressRepository;
import com.domain.repository.PersonRepository;
import com.domain.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService
{
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto)
    {
        //Assert can be added to check whether name is empty or not
        Person p = new Person();
        p.setName(personDto.getName());
        p.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(p);
        List<Address> addressList = new ArrayList<>();
        personDto.getAddressList().forEach(item->{
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(personDb);
        });
        addressRepository.saveAll(addressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PersonDto> getAll()
    {
        List<Person> people = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        people.forEach(item->
        {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setAddressList(item.getAddressList().stream().
                    map(Address::getAddress).collect(Collectors.toList()));
            personDtos.add(personDto);
        });
        return personDtos;
    }
}
