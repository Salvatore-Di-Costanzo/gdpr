package it.agilae.gdpr.dao;

import it.agilae.gdpr.dao.core.data.dao.ICrudDao;
import it.agilae.gdpr.dao.core.data.dao.IListableDao;
import it.agilae.gdpr.model.Notifica;

public interface INotificaDao extends IListableDao<Notifica>, ICrudDao<Notifica, Long> {

}
