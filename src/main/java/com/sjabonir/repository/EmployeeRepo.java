package com.sjabonir.repository;

import com.sjabonir.entity.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public Employee save(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        return employee;
    }

    public Employee get(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public Employee getByName(Employee employee){
        Query query = sessionFactory.getCurrentSession()
                .getNamedQuery("findEmployeeByName")
                .setString("name",employee.getName());
        return (Employee) query.list().get(0);
    }

    public Employee getBySp(Employee employee){
        Query query = sessionFactory.getCurrentSession()
                .getNamedQuery("callSpEmployee")
                .setLong("id",employee.getId());
        return (Employee) query.list().get(0);
    }

    public Employee update(Employee employee) {
        Employee employeeUpdate = get(employee.getId());
        employeeUpdate.setName(employee.getName());
        employeeUpdate.setAge(employee.getAge());
        employeeUpdate.setPosition(employee.getPosition());
        sessionFactory.getCurrentSession().flush();
        return employeeUpdate;
    }

    public void delete(long id) {
        Employee employee = get(id);
        sessionFactory.getCurrentSession().delete(employee);
    }
}
