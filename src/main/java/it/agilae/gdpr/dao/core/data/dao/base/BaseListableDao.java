package it.agilae.gdpr.dao.core.data.dao.base;

import it.agilae.gdpr.dao.core.data.dao.exception.DaoException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
public abstract class BaseListableDao<E> extends HibernateDao<E> implements IBaseListableDao<E>{

    private static final long serialVersionUID = -858081390239428340L;

    /**
     * Costruttore
     *
     * @param persistentClass
     */
    public BaseListableDao(Class<E> persistentClass) {
        super(persistentClass);
    }


    /**
     * Contiene le colonne della select
     */
    private @Getter
    @Setter
    Map<String,String> select;

    /**
     * Contiene le  tabelle della from
     */
    private @Getter @Setter Map<String,String> from;


    /**
     * Contiene i filtri della where
     */
    private @Getter @Setter
    List<Criterion> where;


    /**
     * Contiene gli ordinamenti
     */
    private @Getter @Setter List<Order> order;


    @SuppressWarnings("unchecked")
    @Override
    public List<E> findByFilters(E e) throws DaoException {
        try {
            Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistentClass() );
            //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setResultTransformer(Transformers.aliasToBean(getPersistentClass()));
            //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            //criteria.setResultTransformer(Transformers.aliasToBean(getPersistentClass() ));

            // SELECT
            if(getSelect() != null)	{
                ProjectionList projectionList = Projections.projectionList();
                for (Map.Entry<String, String> column : getSelect().entrySet())
                    projectionList.add(Projections.alias(Projections.property(column.getKey()), column.getValue()));
                criteria.setProjection(Projections.distinct(projectionList));
                criteria.setResultTransformer(new AliasToBeanNestedResultTransformer(getPersistentClass()));
            }

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

            // ORDER
            if(getOrder() != null) {
                for (int i = 0; i < getOrder().size(); i++)
                    criteria.addOrder(getOrder().get(i));
            }

            // EXTRACTION
            return (List<E>) criteria.list();
        }
        catch (Exception ex) {
            throw new DaoException("Errore nelle estrazione dal db" + ex);
        }
    }
}





