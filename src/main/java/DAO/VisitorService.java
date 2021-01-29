package DAO;

import models.Address;
import models.Visitor;

import java.util.List;

public class VisitorService {
    private VisitorDAOImpl visitorDAO = new VisitorDAOImpl();
    private AddressDAOImpl addressDAO = new AddressDAOImpl();

    public Visitor findVisitorById (int id){
        return visitorDAO.findById(id);
    }

    public void insertVisitor (Visitor visitor){
        visitorDAO.insert(visitor);
    }

    public void updateVisitor (Visitor visitor){
        visitorDAO.update(visitor);
    }

    public void deleteVisitor (Visitor visitor){
        visitorDAO.delete(visitor);
    }

    public List<Visitor> getAllVisitors (){
        return visitorDAO.getAllVisitors();
    }

    public List<Address> getAddressesByVisitor (Visitor visitor) {
        return visitorDAO.getAddressesByVisitor(visitor);
    }

    public void insertAddress (Address address) { addressDAO.insert(address); }

    public void updateAddress (Address address) { addressDAO.update(address); }

    public void deleteAddress (Address address) { addressDAO.delete(address); }
}
