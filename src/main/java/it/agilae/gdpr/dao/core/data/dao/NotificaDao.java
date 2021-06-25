package it.agilae.gdpr.dao.core.data.dao;

import it.agilae.gdpr.dao.INotificaDao;
import it.agilae.gdpr.dao.core.data.dao.base.BaseCrudDao;
import it.agilae.gdpr.dao.core.data.dao.exception.DaoException;
import it.agilae.gdpr.model.Notifica;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("NotificheDao")
public class NotificaDao extends BaseCrudDao<Notifica, Long> implements INotificaDao {


    private static final long serialVersionUID = 814800060731745028L;


    /**
     * Costruttore
     */
    public NotificaDao() {
        super(NotificaDao.class);
    }


    @Override
    public List<Notifica> findByFilters(Notifica e) throws DaoException {

        // SELECT
        super.setSelect(null);
        // FROM
        Map<String,String> from = new HashMap<String,String>();
        from.put("categoriaAsset", "INNER_JOIN");
        from.put("tipologiaSmaltimentoAsset", "INNER_JOIN");
        from.put("tipologiaUbicazioneAsset", "INNER_JOIN");
        from.put("tempoRipristinoAsset", "INNER_JOIN");
        super.setFrom(from);

        // WHERE
        List<Criterion> where = new ArrayList<Criterion>();
        if (e.getNotifica_id() == null)
            throw new DaoException("TenantId non valorizzato");
        where.add(Restrictions.eq("tenantId", e.getNotifica_id()));
        if (e.getNumero_tentativi() != null)
            where.add(Restrictions.eq("sedeId", e.getNumero_tentativi()));
        if (e.getNome() != null)
            where.add(Restrictions.like("nome", "%" + e.getNome().trim() + "%").ignoreCase());
        if (e.getCategoriaAsset()!= null && e.getCategoriaAsset().getCategoriaId() != null)
            where.add(Restrictions.eq("categoriaAsset.categoriaId", e.getCategoriaAsset().getCategoriaId()));
        if (e.getTipologiaSmaltimentoAsset()!= null && e.getTipologiaSmaltimentoAsset().getTipologiaId() != null)
            where.add(Restrictions.eq("tipologiaSmaltimentoAsset.tipologiaId", e.getTipologiaSmaltimentoAsset().getTipologiaId()));
        if (e.getTipologiaUbicazioneAsset()!= null && e.getTipologiaUbicazioneAsset().getTipologiaId() != null)
            where.add(Restrictions.eq("tipologiaUbicazioneAsset.tipologiaId", e.getTipologiaUbicazioneAsset().getTipologiaId()));
        if (e.getTempoRipristinoAsset()!= null && e.getTempoRipristinoAsset().getRipristinoId() != null)
            where.add(Restrictions.eq("tempoRipristinoAsset.ripristinoId", e.getTempoRipristinoAsset().getRipristinoId()));

        if (e.getArchiviato() != null)
            where.add(Restrictions.eq("archiviato", e.getArchiviato()));
        if (e.getFilterDataArchiviazioneDa() != null) {
            Date data_tmp = e.getFilterDataArchiviazioneDa();
            Format formatter = new SimpleDateFormat(CommonCoreConstants.COMMONS_DATE_FORMAT);
            String strData_tmp = formatter.format(data_tmp);
            where.add(Restrictions.sqlRestriction("date(this_.data_archiviazione)>=to_date('" + strData_tmp  + "','" + CommonCoreConstants.COMMONS_DATE_FORMAT + "')"));
        }
        if (e.getFilterDataArchiviazioneA() != null) {
            Date data_tmp = e.getFilterDataArchiviazioneA();
            Format formatter = new SimpleDateFormat(CommonCoreConstants.COMMONS_DATE_FORMAT);
            String strData_tmp = formatter.format(data_tmp);
            where.add(Restrictions.sqlRestriction("date(this_.data_archiviazione)<=to_date('" + strData_tmp  + "','" + CommonCoreConstants.COMMONS_DATE_FORMAT + "')"));
        }



        super.setWhere(where);

        // ORDER
        List<Order> order= new ArrayList<Order>();
        order.add(Order.asc("nome"));
        super.setOrder(order);

        return super.findByFilters(e);
    }

    @Override
    public AssetEntity findByFields(AssetEntity e) throws DaoException {

        // SELECT
        super.setSelect(null);

        // FROM
        Map<String,String> from = new HashMap<String,String>();
        from.put("categoriaAsset", "INNER_JOIN");
        super.setFrom(from);

        // WHERE
        List<Criterion> where = new ArrayList<Criterion>();
        if (e.getTenantId() == null)
            throw new DaoException("TenantId non valorizzato");
        where.add(Restrictions.eq("tenantId", e.getTenantId()));
        if(e.getAssetId() != null)
            where.add(Restrictions.ne("assetId", e.getAssetId()));
        where.add(Restrictions.eq("categoriaAsset.categoriaId", e.getCategoriaAsset().getCategoriaId()));
        where.add(Restrictions.eq("nome", e.getNome().trim()).ignoreCase());
        where.add(Restrictions.eq("archiviato", new Boolean(false)));
        super.setWhere(where);

        return super.findByFields(e);
    }


    @Override
    public AssetEntity findById(AssetEntityId id) throws DaoException {
        if (id.getTenantId() == null)
            throw new DaoException("TenantId non valorizzato");
        super.setSelect(null);
        // FROM
        Map<String,String> from = new HashMap<String,String>();
        from.put("categoriaAsset", "INNER_JOIN");
        from.put("tipologiaSmaltimentoAsset", "INNER_JOIN");
        from.put("tipologiaUbicazioneAsset", "INNER_JOIN");
        from.put("tempoRipristinoAsset", "INNER_JOIN");
        from.put("sede", "LEFT_JOIN");
        super.setFrom(from);
        super.setWhere(null);
        return super.findById(id);
    }

    @Override
    public void insert(AssetEntity e) throws DaoException {
        super.insert(e);
    }


    @Override
    public void update(AssetEntity e) throws DaoException {
        super.update(e);

    }


    @Override
    public void delete(AssetEntity e) throws DaoException {
        super.delete(e);
    }


    @Override
    public Notifica findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Notifica findByFields(Notifica notifica) throws DaoException {
        return null;
    }

    @Override
    public void insert(Notifica notifica) throws DaoException {

    }

    @Override
    public void update(Notifica notifica) throws DaoException {

    }

    @Override
    public void delete(Notifica notifica) throws DaoException {

    }

    @Override
    public AssetEntity custom(String sql) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }



}