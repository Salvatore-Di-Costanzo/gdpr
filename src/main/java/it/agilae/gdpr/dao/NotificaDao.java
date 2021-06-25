package it.agilae.gdpr.dao;

import it.agilae.gdpr.model.Notifica;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotificaDao implements INotificaDao<Notifica> {

    private final Session session;

    @Autowired
    public NotificaDao(Session session){
        this.session = session;

    }

    Criteria cr = session.createCriteria(Notifica.class);
    List results = cr.list();
}
