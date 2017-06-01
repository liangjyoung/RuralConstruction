package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.VilBasicInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * VilBasicInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.VilBasicInfo
 * @author MyEclipse Persistence Tools
 */

public class VilBasicInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VilBasicInfoDAO.class);
	// property constants
	public static final String VIL_NUM = "vilNum";
	public static final String VIL_NAME = "vilName";
	public static final String VIL_LONGI = "vilLongi";
	public static final String VIL_LATI = "vilLati";
	public static final String VIL_MEAS = "vilMeas";
	public static final String VIL_POP = "vilPop";
	public static final String VIL_HHOLDS = "vilHholds";
	public static final String VIL_NATURAL = "vilNatural";

	protected void initDao() {
		// do nothing
	}

	public void save(VilBasicInfo transientInstance) {
		log.debug("saving VilBasicInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VilBasicInfo persistentInstance) {
		log.debug("deleting VilBasicInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VilBasicInfo findById(java.lang.Integer id) {
		log.debug("getting VilBasicInfo instance with id: " + id);
		try {
			VilBasicInfo instance = (VilBasicInfo) getHibernateTemplate().get(
					"com.rural.bean.VilBasicInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VilBasicInfo instance) {
		log.debug("finding VilBasicInfo instance by example");
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
		log.debug("finding VilBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VilBasicInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty11(String propertyName, Object value) {
		log.debug("finding VilBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VilBasicInfo as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	

	public List findByVilNum(Object vilNum) {
		return findByProperty(VIL_NUM, vilNum);
	}

	public List findByVilName(Object vilName) {
		return findByProperty(VIL_NAME, vilName);
	}

	public List findByVilLongi(Object vilLongi) {
		return findByProperty(VIL_LONGI, vilLongi);
	}

	public List findByVilLati(Object vilLati) {
		return findByProperty(VIL_LATI, vilLati);
	}

	public List findByVilMeas(Object vilMeas) {
		return findByProperty(VIL_MEAS, vilMeas);
	}

	public List findByVilPop(Object vilPop) {
		return findByProperty(VIL_POP, vilPop);
	}

	public List findByVilHholds(Object vilHholds) {
		return findByProperty(VIL_HHOLDS, vilHholds);
	}

	public List findByVilNatural(Object vilNatural) {
		return findByProperty(VIL_NATURAL, vilNatural);
	}

	public List findAll() {
		log.debug("finding all VilBasicInfo instances");
		try {
			String queryString = "from VilBasicInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VilBasicInfo merge(VilBasicInfo detachedInstance) {
		log.debug("merging VilBasicInfo instance");
		try {
			VilBasicInfo result = (VilBasicInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VilBasicInfo instance) {
		log.debug("attaching dirty VilBasicInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VilBasicInfo instance) {
		log.debug("attaching clean VilBasicInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VilBasicInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (VilBasicInfoDAO) ctx.getBean("VilBasicInfoDAO");
	}
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding VilBasicInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VilBasicInfo as model where model."
					+ propertyName + "= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding VilBasicInfo number with conditon: " );
		try {
			String queryString = "from VilBasicInfo as model ";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			List<?> list = query.list();
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			re.printStackTrace();
			log.error("finding VilBasicInfo number with conditon name failed", re);
		}
		return 0;
	}
	
	
	
	public List<VilBasicInfo> findByConditionAndPager( String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding VilBasicInfo instance with conditon: " );
		try {
			
			
			List<VilBasicInfo> result = null;
			String queryString = "from VilBasicInfo as model ";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				for (int i = 0; i < values.size(); i++) {
					query.setParameter(i, values.get(i));
				}
			}
	        query.setFirstResult(from);  
	        query.setMaxResults(length);  
	        query.list();
	  
	        result = query.list();  
	        
	       
	        return result;
		} catch (RuntimeException re) {
			log.error("finding VilBasicInfo instance with conditon failed", re);
			throw re;
		}
	}
	public List findAll1(Integer TownBasicInfoID) {
		log.debug("finding VilBasicInfo instance with property:");
		try {
			String queryString = "from VilBasicInfo where townBasicInfo.townBasicInfoId='"+TownBasicInfoID+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<VilBasicInfo> findBySql(String sql) {
		log.debug("finding VilBasicInfo instance with sql: "
				+ sql);
		try {
			String queryString = "from VilBasicInfo as model where "
					+ sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
}