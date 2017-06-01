package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.Pol;

/**
 * A data access object (DAO) providing persistence and search support for Pol
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.rural.bean.Pol
 * @author MyEclipse Persistence Tools
 */

public class PolDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(PolDAO.class);
	// property constants
	public static final String POL_CODE = "polCode";
	public static final String POL_NAME = "polName";

	protected void initDao() {
		// do nothing
	}

	public void save(Pol transientInstance) {
		log.debug("saving Pol instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pol persistentInstance) {
		log.debug("deleting Pol instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pol findById(java.lang.Integer id) {
		log.debug("getting Pol instance with id: " + id);
		try {
			Pol instance = (Pol) getHibernateTemplate().get(
					"com.rural.bean.Pol", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pol instance) {
		log.debug("finding Pol instance by example");
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
		log.debug("finding Pol instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Pol as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPolCode(Object polCode) {
		return findByProperty(POL_CODE, polCode);
	}

	public List findByPolName(Object polName) {
		return findByProperty(POL_NAME, polName);
	}

	public List findAll() {
		log.debug("finding all Pol instances");
		try {
			String queryString = "from Pol";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Pol merge(Pol detachedInstance) {
		log.debug("merging Pol instance");
		try {
			Pol result = (Pol) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Pol instance) {
		log.debug("attaching dirty Pol instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pol instance) {
		log.debug("attaching clean Pol instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PolDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PolDAO) ctx.getBean("PolDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding Pol number with conditon: " );
		try {
			String queryString = "from Pol as model ";
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
			log.error("finding Pol number with conditon name failed", re);
		}
		return 0;
	}
	public List<Pol> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding Pol instance with conditon: " );
		try {
			List<Pol> result = null;
			String queryString = "from Pol as model ";
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
	  
	        result = query.list();  
	        return result;
		} catch (RuntimeException re) {
			log.error("finding Pol instance with conditon failed", re);
			throw re;
		}
	}
}