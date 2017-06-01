package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.CityBasicInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CityBasicInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.CityBasicInfo
 * @author MyEclipse Persistence Tools
 */

public class CityBasicInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CityBasicInfoDAO.class);
	// property constants
	public static final String CITY_NUM = "cityNum";
	public static final String CITY_NAME = "cityName";
	public static final String CITY_LONGI = "cityLongi";
	public static final String CITY_LATI = "cityLati";
	public static final String CITY_MEAS = "cityMeas";
	public static final String CITY_POP = "cityPop";
	public static final String CITY_HHOLDS = "cityHholds";

	protected void initDao() {
		// do nothing
	}

	public void save(CityBasicInfo transientInstance) {
		log.debug("saving CityBasicInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CityBasicInfo persistentInstance) {
		log.debug("deleting CityBasicInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CityBasicInfo findById(java.lang.Integer id) {
		log.debug("getting CityBasicInfo instance with id: " + id);
		try {
			CityBasicInfo instance = (CityBasicInfo) getHibernateTemplate()
					.get("com.rural.bean.CityBasicInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CityBasicInfo instance) {
		log.debug("finding CityBasicInfo instance by example");
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
		log.debug("finding CityBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CityBasicInfo as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString );
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty3(String propertyName, Object value) {
		log.debug("finding CityBasicInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CityBasicInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding CityBasicInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CityBasicInfo as model where model."
					+ propertyName + "= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCityNum(Object cityNum) {
		return findByProperty(CITY_NUM, cityNum);
	}

	public List findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List findByCityLongi(Object cityLongi) {
		return findByProperty(CITY_LONGI, cityLongi);
	}

	public List findByCityLati(Object cityLati) {
		return findByProperty(CITY_LATI, cityLati);
	}

	public List findByCityMeas(Object cityMeas) {
		return findByProperty(CITY_MEAS, cityMeas);
	}

	public List findByCityPop(Object cityPop) {
		return findByProperty(CITY_POP, cityPop);
	}

	public List findByCityHholds(Object cityHholds) {
		return findByProperty(CITY_HHOLDS, cityHholds);
	}

	public List findAll() {
		log.debug("finding all CityBasicInfo instances");
		try {
			String queryString = "from CityBasicInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CityBasicInfo merge(CityBasicInfo detachedInstance) {
		log.debug("merging CityBasicInfo instance");
		try {
			CityBasicInfo result = (CityBasicInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CityBasicInfo instance) {
		log.debug("attaching dirty CityBasicInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CityBasicInfo instance) {
		log.debug("attaching clean CityBasicInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CityBasicInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CityBasicInfoDAO) ctx.getBean("CityBasicInfoDAO");
	}
	
	public List<CityBasicInfo> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding CityBasicInfo instance with conditon: " );
		try {
			List<CityBasicInfo> result = null;
			String queryString = "from CityBasicInfo as model ";
			String orderRule = "order by cityNum";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString+orderRule);  
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
			log.error("finding CityBasicInfo instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding CityBasicInfo number with conditon: " );
		try {
			String queryString = "from CityBasicInfo as model ";
			if (sql != null) {
				queryString += " where " + sql;
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
			log.error("finding CityBasicInfo number with conditon name failed", re);
			throw re;
		}
	}
}