package com.rural.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CountryFil;
import com.rural.govfile.action.CountryFilAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * CountryFil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.CountryFil
 * @author MyEclipse Persistence Tools
 */

public class CountryFilDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CountryFilDAO.class);
	// property constants
	public static final String COUNTRY_FIL_NUM = "countryFilNum";
	public static final String COUNTRY_FIL_NAME = "countryFilName";
	public static final String COUNTRY_FIL_IDEF = "countryFilIdef";
	public static final String COUNTRY_FIL_PUB_COMP = "countryFilPubComp";
	public static final String COUNTRY_FIL_EXPL = "countryFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(CountryFil transientInstance) {
		log.debug("saving CountryFil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CountryFil persistentInstance) {
		log.debug("deleting CountryFil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CountryFil findById(java.lang.Integer id) {
		log.debug("getting CountryFil instance with id: " + id);
		try {
			CountryFil instance = (CountryFil) getHibernateTemplate().get(
					"com.rural.bean.CountryFil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CountryFil instance) {
		log.debug("finding CountryFil instance by example");
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
		log.debug("finding CountryFil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CountryFil as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCountryFilNum(Object countryFilNum) {
		return findByProperty(COUNTRY_FIL_NUM, countryFilNum);
	}

	public List findByCountryFilName(Object countryFilName) {
		return findByProperty(COUNTRY_FIL_NAME, countryFilName);
	}

	public List findByCountryFilIdef(Object countryFilIdef) {
		return findByProperty(COUNTRY_FIL_IDEF, countryFilIdef);
	}

	public List findByCountryFilPubComp(Object countryFilPubComp) {
		return findByProperty(COUNTRY_FIL_PUB_COMP, countryFilPubComp);
	}

	public List findByCountryFilExpl(Object countryFilExpl) {
		return findByProperty(COUNTRY_FIL_EXPL, countryFilExpl);
	}

	public List findAll() {
		log.debug("finding all CountryFil instances");
		try {
			String queryString = "from CountryFil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CountryFil merge(CountryFil detachedInstance) {
		log.debug("merging CountryFil instance");
		try {
			CountryFil result = (CountryFil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CountryFil instance) {
		log.debug("attaching dirty CountryFil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CountryFil instance) {
		log.debug("attaching clean CountryFil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CountryFilDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CountryFilDAO) ctx.getBean("CountryFilDAO");
	}
	
	public List<CountryFil> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding CountryFil instance with conditon: " );
		try {
			List<CountryFil> result = null;
			String s = CountryFilAction.getJQS();
			String queryString = "from CountryFil as model where GoveFilClfyID = '"+s+"'";
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
			log.error("finding CountryFil instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding CountryFil number with conditon: " );
		try {
			String s = CountryFilAction.getJQS();
			String queryString = "from CountryFil as model where GoveFilClfyID ='"+s+"'";
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
			log.error("finding CountryFil number with conditon name failed", re);
			throw re;
		}
	}
}