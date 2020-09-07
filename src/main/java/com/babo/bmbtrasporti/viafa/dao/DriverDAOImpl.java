package com.babo.bmbtrasporti.viafa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.babo.bmbtrasporti.viafa.entity.Driver;

@Repository
public class DriverDAOImpl implements DriverDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Driver> findAll() {
		
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// Create a query using native Hibernate API
		Query<Driver> theQuery = currentSession.createQuery("from Driver", Driver.class);

		// Execute query and get result list
		List<Driver> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Driver findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Driver employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
