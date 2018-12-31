package com.example.futuresocks.cinemaservice.repositories.ScreeningRepository;

import com.example.futuresocks.cinemaservice.models.Screening;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class ScreeningRepositoryImpl implements ScreeningRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Screening> getScreeningsByDate(LocalDateTime dateTime) {
        System.out.println(dateTime);
        List<Screening> results = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Screening.class);
            cr.add(Restrictions.gt("dateTime", dateTime));
            cr.add(Restrictions.lt("dateTime", dateTime.plusDays(1)));
            cr.createAlias("movie", " movie");
            cr.addOrder(Order.asc("movie"));
            results = cr.list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
