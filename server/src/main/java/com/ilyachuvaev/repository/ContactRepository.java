package com.ilyachuvaev.repository;

import com.ilyachuvaev.entity.ContactMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactMapper, Long> {

}
