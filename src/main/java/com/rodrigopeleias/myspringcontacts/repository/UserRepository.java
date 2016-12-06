package com.rodrigopeleias.myspringcontacts.repository;

import com.rodrigopeleias.myspringcontacts.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    User findByEmail(String email);
}
