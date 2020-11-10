package com.demo.repository;

import com.demo.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person,String>
{
    //only retrieve items that match names (Custom Query Format)
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);
    //(Spring Data Format)
    List<Person> findByNameLikeOrSurnameLike(String name, String surname);

}
