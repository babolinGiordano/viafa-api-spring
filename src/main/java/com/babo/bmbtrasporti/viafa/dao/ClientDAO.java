package com.babo.bmbtrasporti.viafa.dao;

import com.babo.bmbtrasporti.viafa.entity.Client;

import java.util.List;

public interface ClientDAO {

    List<Client> findAll();

    Client findById(int id);

    void save(Client client);

    void deleteById(int id);
}
