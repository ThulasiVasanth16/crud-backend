package com.crudBackEnd.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudBackEnd.model.User;


@Repository

public interface UserRepository extends JpaRepository<User, Long>{

}
