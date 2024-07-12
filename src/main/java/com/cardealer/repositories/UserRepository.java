package com.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cardealer.models.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    //findBy = do a select query in the database
    @Query(value = "select * from user where username = ?1", nativeQuery=true)
    public User findByUsername(String username);


}
