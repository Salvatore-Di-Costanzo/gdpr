package it.agilae.gdpr.dao.core.data.dao.base;

import it.agilae.gdpr.dao.core.data.dao.exception.DaoException;

import java.io.Serializable;

public interface IBaseCrudDao <E, I extends Serializable> extends Serializable{

    /**
     * Ritorna l'oggetto con lo specifico id
     *
     * @param id
     * @return
     * @throws DaoException
     */
    public E findById(I id) throws DaoException;

    /**
     * Ritorna l'oggetto con le specifiche proprietà
     *
     * @param e
     * @return
     * @throws DaoException
     */
    public E findByFields(E e) throws DaoException;

    /**
     * Inserisce un nuovo oggetto
     *
     * @param e
     * @return
     * @throws DaoException
     */
    public void insert(E e) throws DaoException;


    /**
     * Aggiorna l'oggetto
     *
     * @param e
     * @return
     * @throws DaoException
     */
    public void update(E e) throws DaoException;


    /**
     * Cancella l'oggetto
     *
     * @param e
     * @throws DaoException
     */
    public void delete(E e) throws DaoException;


    /**
     * Effettua la generica query
     *
     * @param e
     * @return
     * @throws Exception
     */
    public E custom (String sql) throws DaoException;

}
