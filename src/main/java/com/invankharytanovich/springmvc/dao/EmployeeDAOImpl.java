package com.invankharytanovich.springmvc.dao;

import com.invankharytanovich.springmvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query sessionQuery = session.createQuery("delete from Employee where id=:employeeId");
        sessionQuery.setParameter("employeeId", id);
        sessionQuery.executeUpdate();
    }
}
