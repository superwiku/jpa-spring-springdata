package com.wikutech.workshop.jpa.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wikutech.workshop.jpa.spring.entity.PegawaiNegeri;

@Repository
@Transactional(readOnly = true)
public class PegawaiNegeriRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public PegawaiNegeri findById(long id) {
		return entityManager.find(PegawaiNegeri.class, id);
	}
	
	@Transactional
	public void save(PegawaiNegeri pns) {
		if (pns.getNip() == 0) {
			entityManager.persist(pns);
		} else {
			PegawaiNegeri n = findById(pns.getNip());
			n.setNama(pns.getNama());
			n.setAlamat(pns.getAlamat());
		}
	}
	
	public List<PegawaiNegeri> findByNama(String nama) {
		String q = "SELECT n FROM PegawaiNegeri n WHERE n.nama LIKE ?1";
		TypedQuery<PegawaiNegeri> query = entityManager.createQuery(q, PegawaiNegeri.class);
		query.setParameter(1, nama);
		
		return query.getResultList();
	}

}
