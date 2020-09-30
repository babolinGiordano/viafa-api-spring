package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//TODO: Modificato per usare direttamente le JPA e non + Hibernate
@Repository
public class ClientDAOImpl implements ClientDAO {

    private EntityManager entityManager;
    
    @Autowired
    public EntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;   
    }

    @Override
    public List<Client> findAll() {

        Query query = entityManager.createQuery("from Client");

        List<Client> clients = theQuery.getResultList();

        return clients;
    }

    @Override
    public Client findById(int id) {

        Client clients = entityManager.find(Client.class, id);

        return clients;
    }

    @Override
    public void save(Client client) {

        Client clients = entityManager.merge(client);
        
        client.setId(clients.getId());
    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("delete from Client where id=:clientId");
        query.setParameter("clientId", id);

        query.executeUpdate();
    }
}
