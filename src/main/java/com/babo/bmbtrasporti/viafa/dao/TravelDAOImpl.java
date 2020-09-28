package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Travel;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TravelDAOImpl implements TravelDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Travel> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Travel> theQuery = currentSession.createQuery("from Travel", Travel.class);

        List<Travel> travels = theQuery.getResultList();

        return travels;
    }

    @Override
    public Travel findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Travel travels = currentSession.get(Travel.class, id);

        return travels;
    }

    @Override
    public void save(Travel travel) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(travel);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Travel where id=:travelId");
        query.setParameter("travelId", id);

        query.executeUpdate();
    }
}
