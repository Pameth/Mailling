package sn.isi.dao;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public int add(Client c) throws Exception;
    public int update(Client c)throws Exception;
    public Client getClient(String email)throws Exception;
    public List<Client> liste()throws Exception;
}
