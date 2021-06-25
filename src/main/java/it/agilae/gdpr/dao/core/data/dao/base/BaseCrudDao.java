package it.agilae.gdpr.dao.core.data.dao.base;

import it.agilae.gdpr.dao.core.data.dao.exception.DaoException;
import lombok.NoArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.io.Serializable;
import java.util.Map;

@NoArgsConstructor
public abstract class BaseCrudDao<E, ID extends Serializable>
        extends BaseListableDao<E> implements IBaseCrudDao<E, ID>{


    private static final long serialVersionUID = -1522700139743020462L;


    /**
     * @param persistentClass
     */
    public BaseCrudDao(Class<E> persistentClass) {
        super(persistentClass);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findById(ID id) throws DaoException {
        try {

            Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());

            // FROM
            if(getFrom() != null) {
                String alias = null;
                for (Map.Entry<String, String> table : getFrom().entrySet())	{
                    if(table.getKey().indexOf(".") == -1)
                        alias = table.getKey();
                    else
                        alias = table.getKey().substring(table.getKey().lastIndexOf(".") + 1 , table.getKey().length());
                    criteria.createAlias(table.getKey(), alias, table.getValue().equalsIgnoreCase("INNER_JOIN") ? JoinType.INNER_JOIN : JoinType.LEFT_OUTER_JOIN);
                }
            }

            // WHERE
            criteria.add(Restrictions.idEq(id));

            return (E) criteria.uniqueResult();
        } catch (Exception ex) {
            throw new DaoException("Errore nella estrazione dal Db", ex);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findByFields(E e) throws DaoException{
        try {

            Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass());

            // FROM
            if(getFrom() != null) {
                String alias = null;
                for (Map.Entry<String, String> table : getFrom().entrySet())	{
                    if(table.getKey().indexOf(".") == -1)
                        alias = table.getKey();
                    else
                        alias = table.getKey().substring(table.getKey().lastIndexOf(".") + 1 , table.getKey().length());
                    criteria.createAlias(table.getKey(), alias, table.getValue().equalsIgnoreCase("INNER_JOIN") ? JoinType.INNER_JOIN : JoinType.LEFT_OUTER_JOIN);
                }
            }

            // WHERE
            if(getWhere() != null){
                for (int i = 0; i < getWhere().size(); i++)
                    criteria.add(getWhere().get(i));
            }

            return (E) criteria.uniqueResult();
        } catch (Exception ex) {
            throw new DaoException("Errore nella estrazione dal Db", ex);
        }
    }


    @Override
    public void insert(E po) throws DaoException{
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(po);
        } catch (Exception ex) {
            throw new DaoException("Errore nell'inserimento sul DB", ex);
        }
    }


    @Override
    public void update(E e) throws DaoException{
        try {
            getSessionFactory().getCurrentSession().update(e);
        } catch (Exception ex) {
            throw new DaoException("Errore nell'aggiornamento sul DB", ex);
        }
    }



    @Override
    public void delete(E e) throws DaoException {
        try {
            getSessionFactory().getCurrentSession().delete(e);
        } catch (Exception ex) {
            throw new DaoException("Errore nella cancellazione sul DB", ex);
        }

    }


    @SuppressWarnings("unchecked")
    @Override
    public E custom(String sql) throws DaoException 	{
        try {
            SQLQuery sqlQuery = getSessionFactory().getCurrentSession().createSQLQuery(sql);
            sqlQuery.addEntity(getPersistentClass());
            return (E)sqlQuery.uniqueResult();
        } catch (Exception ex) {
            throw new DaoException("Errore nell'aggiornamento sul DB", ex);
        }

    }



}
