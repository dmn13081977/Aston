package my.dao;

import my.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Person> getAllPeople() {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("From Person", Person.class);
        List<Person> allPeople = query.getResultList();
        return allPeople;
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        if (person.getId() == 0) session.persist(person);
        else session.merge(person);
    }

    @Override
    public Person getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Person> query = session.createQuery("DELETE FROM Person where id=:personid");
        query.setParameter("personid", id);
        query.executeUpdate();
    }
}
