package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.admiDivisions.action.CountryBasicInfoAction;
import com.rural.bean.CountryBasicInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CountryBasicInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.CountryBasicInfo
 * @author MyEclipse Persistence Tools
 */

public class CountryBasicInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CountryBasicInfoDAO.class);
	// property constants
	public static final String COUNTRY_NUM = "countryNum";
	public static final String COUNTRY_NAME = "countryName";
	public static final String COUNTRY_LONGI = "countryLongi";
	public static final String COUNTRY_LATI = "countryLati";
	public static final String COUNTRY_MEAS = "countryMeas";
	public static final String COUNTRY_POP = "countryPop";
	public static final String COUNTRY_HHOLDS = "countryHholds";

	protected void initDao() {
		// do nothing
	}

	public void save(CountryBasicInfo transientInstance) {
		log.debug("saving CountryBasicInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CountryBasicInfo persistentInstance) {
		log.debug("deleting CountryBasicInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CountryBasicInfo findById(java.lang.Integer id) {
		log.debug("getting CountryBasicInfo instance with id: " + id);
		try {
			CountryBasicInfo instance = (CountryBasicInfo) getHibernateTemplate()
					.get("com.rural.bean.CountryBasicInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CountryBasicInfo instance) {
		log.debug("finding CountryBasicInfo instance by example");
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
		log.debug("finding CountryBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CountryBasicInfo as model where model."
					+ propertyName + "="+ value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding CountryBasicInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CountryBasicInfo as model where model."
					+ propertyName + "= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCountryNum(Object countryNum) {
		return findByProperty(COUNTRY_NUM, countryNum);
	}

	public List findByCountryName(Object countryName) {
		return findByProperty(COUNTRY_NAME, countryName);
	}

	public List findByCountryLongi(Object countryLongi) {
		return findByProperty(COUNTRY_LONGI, countryLongi);
	}

	public List findByCountryLati(Object countryLati) {
		return findByProperty(COUNTRY_LATI, countryLati);
	}

	public List findByCountryMeas(Object countryMeas) {
		return findByProperty(COUNTRY_MEAS, countryMeas);
	}

	public List findByCountryPop(Object countryPop) {
		return findByProperty(COUNTRY_POP, countryPop);
	}

	public List findByCountryHholds(Object countryHholds) {
		return findByProperty(COUNTRY_HHOLDS, countryHholds);
	}

	public List findAll() {
		log.debug("finding all CountryBasicInfo instances");
		try {
			String queryString = "from CountryBasicInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CountryBasicInfo merge(CountryBasicInfo detachedInstance) {
		log.debug("merging CountryBasicInfo instance");
		try {
			CountryBasicInfo result = (CountryBasicInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CountryBasicInfo instance) {
		log.debug("attaching dirty CountryBasicInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CountryBasicInfo instance) {
		log.debug("attaching clean CountryBasicInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CountryBasicInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CountryBasicInfoDAO) ctx.getBean("CountryBasicInfoDAO");
	}
	public List<CountryBasicInfo> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding CountryBasicInfo instance with conditon: " );
		try {
			List<CountryBasicInfo> result = null;
			int s = CountryBasicInfoAction.getJQS();
			String queryString = "from CountryBasicInfo as model where cityBasicInfo.cityBasicInfoId = "+s;
			String orderRule = "order by countryNum";
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding CountryBasicInfo instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding CountryBasicInfo number with conditon: " );
		try {
			int s = CountryBasicInfoAction.getJQS();
			String queryString = "from CountryBasicInfo as model where cityBasicInfo.cityBasicInfoId ="+s;
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
			log.error("finding CountryBasicInfo number with conditon name failed", re);
			throw re;
		}
	}
	public List findCID (String CNum) {
		log.debug("finding CountryBasicInfo instance with property: ");
		try {
			String queryString = "from CountryBasicInfo as model where countryNum ='"+CNum+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CountryBasicInfo> findBySql(String sql) {
		log.debug("finding CountryBasicInfo instance with sql: "
				+ sql);
		try {
			String queryString = "from CountryBasicInfo as model where "
					+ sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	
}