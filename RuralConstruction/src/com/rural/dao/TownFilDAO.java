package com.rural.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.TownFil;
import com.rural.govfile.action.TownFilAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * TownFil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.TownFil
 * @author MyEclipse Persistence Tools
 */

public class TownFilDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TownFilDAO.class);
	// property constants
	public static final String TOWN_FIL_NUM = "townFilNum";
	public static final String TOWN_FIL_NAME = "townFilName";
	public static final String TOWN_FIL_IDEF = "townFilIdef";
	public static final String TOWN_FIL_PUB_COMP = "townFilPubComp";
	public static final String TOWN_FIL_EXPL = "townFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(TownFil transientInstance) {
		log.debug("saving TownFil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TownFil persistentInstance) {
		log.debug("deleting TownFil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TownFil findById(java.lang.Integer id) {
		log.debug("getting TownFil instance with id: " + id);
		try {
			TownFil instance = (TownFil) getHibernateTemplate().get(
					"com.rural.bean.TownFil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TownFil instance) {
		log.debug("finding TownFil instance by example");
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
		log.debug("finding TownFil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TownFil as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTownFilNum(Object townFilNum) {
		return findByProperty(TOWN_FIL_NUM, townFilNum);
	}

	public List findByTownFilName(Object townFilName) {
		return findByProperty(TOWN_FIL_NAME, townFilName);
	}

	public List findByTownFilIdef(Object townFilIdef) {
		return findByProperty(TOWN_FIL_IDEF, townFilIdef);
	}

	public List findByTownFilPubComp(Object townFilPubComp) {
		return findByProperty(TOWN_FIL_PUB_COMP, townFilPubComp);
	}

	public List findByTownFilExpl(Object townFilExpl) {
		return findByProperty(TOWN_FIL_EXPL, townFilExpl);
	}

	public List findAll() {
		log.debug("finding all TownFil instances");
		try {
			String queryString = "from TownFil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TownFil merge(TownFil detachedInstance) {
		log.debug("merging TownFil instance");
		try {
			TownFil result = (TownFil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TownFil instance) {
		log.debug("attaching dirty TownFil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TownFil instance) {
		log.debug("attaching clean TownFil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TownFilDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TownFilDAO) ctx.getBean("TownFilDAO");
	}
	
	public List<TownFil> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding TownFil instance with conditon: " );
		try {
			List<TownFil> result = null;
			String s = TownFilAction.getJQS();
			String queryString = "from TownFil as model where GoveFilClfyID = '"+s+"'";
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
			log.error("finding TownFil instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding TownFil number with conditon: " );
		try {
			String s = TownFilAction.getJQS();
			String queryString = "from TownFil as model where GoveFilClfyID ='"+s+"'";
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
			log.error("finding TownFil number with conditon name failed", re);
			throw re;
		}
	}
}