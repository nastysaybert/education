package DAO;

import models.Visitor;

import java.sql.SQLException;
import java.util.List;

public interface VisitorDAO {
    public Visitor findById (int id);
    public void insert (Visitor visitor);
    public void update (Visitor visitor);
    public void delete (Visitor visitor);
    public List<Visitor> getAllVisitors ();
}
