package it.agilae.gdpr.dao.core.data.dao.base;

import it.agilae.gdpr.dao.core.data.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

public interface IBaseListableDao<E> extends Serializable {

    /**
     * Ritorna la lista in funzione dei filtri di ricerca inseriti
     *
     * @param e
     * @return
     * @throws Exception
     */
    public List<E> findByFilters(E e) throws DaoException;



}
