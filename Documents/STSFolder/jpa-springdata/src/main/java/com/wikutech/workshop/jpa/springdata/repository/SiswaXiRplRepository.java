package com.wikutech.workshop.jpa.springdata.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wikutech.workshop.jpa.springdata.entity.SiswaXiRpl;

@Repository
public interface SiswaXiRplRepository extends CrudRepository<SiswaXiRpl, Long> {
	
	SiswaXiRpl findById(long id);
	
	List<SiswaXiRpl> findByNama(String nama);
}
