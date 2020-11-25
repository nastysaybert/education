package DAO;

import models.Visitor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.util.List;

public class VisitorDAOImpl implements VisitorDAO {

    public Visitor findById (int id){
        //return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Visitor.class, id);
        return HibernateSessionFactoryUtil.getHibernateSession().get(Visitor.class, id);
    }

    public void insert (Visitor visitor){
        //Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.save(visitor);
        transaction.commit();
        session.close();
    }

    public void update (Visitor visitor){
        //Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.update(visitor);
        transaction.commit();
        session.close();
    }

    public void delete (Visitor visitor){
        //Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.delete(visitor);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Visitor> getAllVisitors(){
        //List<Visitor> visitors = (List<Visitor>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Visitor").list();
        List<Visitor> visitors = (List<Visitor>) HibernateSessionFactoryUtil.getHibernateSession().createQuery("From Visitor").list();
        return visitors;
    }
}
