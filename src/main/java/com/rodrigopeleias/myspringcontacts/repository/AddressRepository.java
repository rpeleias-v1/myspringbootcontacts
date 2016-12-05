package com.rodrigopeleias.myspringcontacts.repository;

import com.rodrigopeleias.myspringcontacts.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
