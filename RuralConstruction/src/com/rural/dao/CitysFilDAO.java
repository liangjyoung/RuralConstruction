package com.rural.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CitysFil;
import com.rural.govfile.action.CitysFilAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * CitysFil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.CitysFil
 * @author MyEclipse Persistence Tools
 */

public class CitysFilDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CitysFilDAO.class);
	// property constants
	public static final String CITYS_FIL_NUM = "citysFilNum";
	public static final String CITYS_FIL_NAME = "citysFilName";
	public static final String CITYS_FIL_IDEF = "citysFilIdef";
	public static final String CITYS_FIL_PUB_COMP = "citysFilPubComp";
	public static final String CITYS_FIL_EXPL = "citysFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(CitysFil transientInstance) {
		log.debug("saving CitysFil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CitysFil persistentInstance) {
		log.debug("deleting CitysFil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CitysFil findById(java.lang.Integer id) {
		log.debug("getting CitysFil instance with id: " + id);
		try {
			CitysFil instance = (CitysFil) getHibernateTemplate().get(
					"com.rural.bean.CitysFil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CitysFil instance) {
		log.debug("finding CitysFil instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CitysFil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CitysFil as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCitysFilNum(Object citysFilNum) {
		return findByProperty(CITYS_FIL_NUM, citysFilNum);
	}

	public List findByCitysFilName(Object citysFilName) {
		return findByProperty(CITYS_FIL_NAME, citysFilName);
	}

	public List findByCitysFilIdef(Object citysFilIdef) {
		return findByProperty(CITYS_FIL_IDEF, citysFilIdef);
	}

	public List findByCitysFilPubComp(Object citysFilPubComp) {
		return findByProperty(CITYS_FIL_PUB_COMP, citysFilPubComp);
	}

	public List findByCitysFilExpl(Object citysFilExpl) {
		return findByProperty(CITYS_FIL_EXPL, citysFilExpl);
	}

	public List findAll() {
		log.debug("finding all CitysFil instances");
		try {
			String queryString = "from CitysFil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CitysFil merge(CitysFil detachedInstance) {
		log.debug("merging CitysFil instance");
		try {
			CitysFil result = (CitysFil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CitysFil instance) {
		log.debug("attaching dirty CitysFil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CitysFil instance) {
		log.debug("attaching clean CitysFil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CitysFilDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CitysFilDAO) ctx.getBean("CitysFilDAO");
	}
	
	public List<CitysFil> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding CitysFil instance with conditon: " );
		try {
			List<CitysFil> result = null;
			String s = CitysFilAction.getJQS();
			String queryString = "from CitysFil as model where GoveFilClfyID = '"+s+"'";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);//+orderRule);  
			if (values != null) {
				for (int i = 0; i < values.size(); i++) {
					query.setParameter(i, values.get(i));
				}
			}
	        query.setFirstResult(from);  
	        query.setMaxResults(length);  
	  
	        result = query.list();  
	        return result;
		} catch (RuntimeException re) {
			log.error("finding CitysFil instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding CitysFil number with conditon: " );
		try {
			String s = CitysFilAction.getJQS();
			String queryString = "from CitysFil as model where GoveFilClfyID ='"+s+"'";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding CitysFil number with conditon name failed", re);
			throw re;
		}
	}
}