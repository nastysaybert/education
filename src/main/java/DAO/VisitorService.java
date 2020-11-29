package DAO;

import models.Visitor;

import java.util.List;

public class VisitorService {
    private VisitorDAOImpl visitorDAO = new VisitorDAOImpl();

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
}
