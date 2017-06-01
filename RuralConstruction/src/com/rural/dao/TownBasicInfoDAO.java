package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.admiDivisions.action.TownBasicInfoAction;
import com.rural.bean.TownBasicInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * TownBasicInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.TownBasicInfo
 * @author MyEclipse Persistence Tools
 */

public class TownBasicInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TownBasicInfoDAO.class);
	// property constants
	public static final String TOWN_NUM = "townNum";
	public static final String TOWN_NAME = "townName";
	public static final String TOWN_LONGI = "townLongi";
	public static final String TOWN_LATI = "townLati";
	public static final String TOWN_MEAS = "townMeas";
	public static final String TOWN_POP = "townPop";
	public static final String TOWN_HHOLDS = "townHholds";

	protected void initDao() {
		// do nothing
	}

	public void save(TownBasicInfo transientInstance) {
		log.debug("saving TownBasicInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TownBasicInfo persistentInstance) {
		log.debug("deleting TownBasicInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TownBasicInfo findById(java.lang.Integer id) {
		log.debug("getting TownBasicInfo instance with id: " + id);
		try {
			TownBasicInfo instance = (TownBasicInfo) getHibernateTemplate()
					.get("com.rural.bean.TownBasicInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TownBasicInfo instance) {
		log.debug("finding TownBasicInfo instance by example");
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
		log.debug("finding TownBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TownBasicInfo as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding TownBasicInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TownBasicInfo as model where model."
					+ propertyName + "= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTownNum(Object townNum) {
		return findByProperty(TOWN_NUM, townNum);
	}

	public List findByTownName(Object townName) {
		return findByProperty(TOWN_NAME, townName);
	}

	public List findByTownLongi(Object townLongi) {
		return findByProperty(TOWN_LONGI, townLongi);
	}

	public List findByTownLati(Object townLati) {
		return findByProperty(TOWN_LATI, townLati);
	}

	public List findByTownMeas(Object townMeas) {
		return findByProperty(TOWN_MEAS, townMeas);
	}

	public List findByTownPop(Object townPop) {
		return findByProperty(TOWN_POP, townPop);
	}

	public List findByTownHholds(Object townHholds) {
		return findByProperty(TOWN_HHOLDS, townHholds);
	}

	public List findAll() {
		log.debug("finding all TownBasicInfo instances");
		try {
			String queryString = "from TownBasicInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TownBasicInfo merge(TownBasicInfo detachedInstance) {
		log.debug("merging TownBasicInfo instance");
		try {
			TownBasicInfo result = (TownBasicInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TownBasicInfo instance) {
		log.debug("attaching dirty TownBasicInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TownBasicInfo instance) {
		log.debug("attaching clean TownBasicInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TownBasicInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TownBasicInfoDAO) ctx.getBean("TownBasicInfoDAO");
	}
	public List<TownBasicInfo> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding TownBasicInfo instance with conditon: " );
		try {
			List<TownBasicInfo> result = null;
			int s = TownBasicInfoAction.getJQS();
			String queryString = "from TownBasicInfo as model where countryBasicInfo.countryBasicInfoId = "+s;
			String orderRule = "order by townNum";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString +orderRule);  
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
			log.error("finding TownBasicInfo instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding TownBasicInfo number with conditon: " );
		try {
			int s = TownBasicInfoAction.getJQS();
			String queryString = "from TownBasicInfo as model where countryBasicInfo.countryBasicInfoId ="+s;
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
			log.error("finding TownBasicInfo number with conditon name failed", re);
			throw re;
		}
   }
	public List findAll1(Integer CountryBasicInfoID) {
		log.debug("finding TownBasicInfo instance with property:");
		try {
			String queryString = "from TownBasicInfo where countryBasicInfo.countryBasicInfoId='"+CountryBasicInfoID+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findTID (String TNum) {
		log.debug("finding TownBasicInfo instance with property: ");
		try {
			String queryString = "from TownBasicInfo as model where townNum ='"+TNum+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TownBasicInfo> findBySql(String sql) {
		log.debug("finding TownBasicInfo instance with sql: "
				+ sql);
		try {
			String queryString = "from TownBasicInfo as model where "
					+ sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
}