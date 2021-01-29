package DAO;

import models.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class AddressDAOImpl implements AddressDAO {

    public Address findById (int id){
        return HibernateSessionFactoryUtil.getHibernateSession().get(Address.class, id);
    }

    public void insert (Address address){
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        session.close();
    }

    public void update (Address address){
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.update(address);
        transaction.commit();
        session.close();
    }

    public void delete (Address address){
        Session session = HibernateSessionFactoryUtil.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.delete(address);
        transaction.commit();
        session.close();
    }

}
