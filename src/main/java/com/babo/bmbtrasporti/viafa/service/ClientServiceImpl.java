package com.babo.bmbtrasporti.viafa.service;

import com.babo.bmbtrasporti.viafa.dao.ClientDAO;
import com.babo.bmbtrasporti.viafa.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    @Transactional
    public Client findById(int id) {
        return clientDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDAO.save(client);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        clientDAO.deleteById(id);
    }
}
