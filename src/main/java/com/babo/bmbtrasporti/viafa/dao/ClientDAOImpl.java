package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Client> theQuery = currentSession.createQuery("from Client", Client.class);

        List<Client> clients = theQuery.getResultList();

        return clients;
    }

    @Override
    public Client findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Client clients = currentSession.get(Client.class, id);

        return clients;
    }

    @Override
    public void save(Client client) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(client);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("delete from Client where id=:clientId");
        query.setParameter("clientId", id);

        query.executeUpdate();
    }
}
