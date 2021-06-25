package it.agilae.gdpr.dao.core.data.dao.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class HibernateDao<E> {

    public HibernateDao(Class<E> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Autowired
    private @Getter
    SessionFactory sessionFactory;

    private @Getter Class<E> persistentClass;

}