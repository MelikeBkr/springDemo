package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

//User in MongoRepository<User,String>-> connect User collection
//String in MongoRepository<User,String>-> primary key in User collection (ex. ID)
public interface UserRepository extends MongoRepository<User,String>
{

}
