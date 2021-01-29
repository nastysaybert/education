package DAO;

import models.Address;

import java.util.List;

public interface AddressDAO {
    public Address findById (int id);
    public void insert (Address address);
    public void update (Address address);
    public void delete (Address address);
}
