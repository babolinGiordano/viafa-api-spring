package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Truck;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TruckDAOImpl implements TruckDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Truck> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Truck> query = currentSession.createQuery("from Truck", Truck.class);

        List<Truck> trucks = query.getResultList();

        return trucks;
    }

    @Override
    public Truck findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Truck truck = currentSession.get(Truck.class, id);

        return truck;
    }

    @Override
    public void save(Truck truck) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(truck);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Truck where id=:truckId");
        query.setParameter("truckId", id);

        query.executeUpdate();
    }
}
