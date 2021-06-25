package it.agilae.gdpr.dao;

import it.agilae.gdpr.model.Notifica;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class NotificaDao implements INotificaDao<Notifica>, CrudRepository<Notifica, Long> {

    private Session session;

    public void getList() {
        Criteria criteria = session.createCriteria(Notifica.class);
        List<Notifica> res = criteria.list();

        for (Notifica not : res) {
            log.info("{}", not.getNotifica_id());
        }
    }
}
