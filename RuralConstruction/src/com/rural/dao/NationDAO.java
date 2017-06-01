package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.Nation;

/**
 * A data access object (DAO) providing persistence and search support for
 * Nation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.Nation
 * @author MyEclipse Persistence Tools
 */

public class NationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(NationDAO.class);
	// property constants
	public static final String NATION_CODE = "nationCode";
	public static final String NATION_NAME = "nationName";

	protected void initDao() {
		// do nothing
	}

	public void save(Nation transientInstance) {
		log.debug("saving Nation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Nation persistentInstance) {
		log.debug("deleting Nation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Nation findById(java.lang.Integer id) {
		log.debug("getting Nation instance with id: " + id);
		try {
			Nation instance = (Nation) getHibernateTemplate().get(
					"com.rural.bean.Nation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Nation instance) {
		log.debug("finding Nation instance by example");
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
		log.debug("finding Nation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Nation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNationCode(Object nationCode) {
		return findByProperty(NATION_CODE, nationCode);
	}

	public List findByNationName(Object nationName) {
		return findByProperty(NATION_NAME, nationName);
	}

	public List findAll() {
		log.debug("finding all Nation instances");
		try {
			String queryString = "from Nation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Nation merge(Nation detachedInstance) {
		log.debug("merging Nation instance");
		try {
			Nation result = (Nation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Nation instance) {
		log.debug("attaching dirty Nation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Nation instance) {
		log.debug("attaching clean Nation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NationDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NationDAO) ctx.getBean("NationDAO");
	}
	
	public List<Nation> findByConditionAndPager(String sql,	List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding Nation instance with conditon: " );
		try {
			List<Nation> result = null;
			String queryString = "from Nation as model ";
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
			log.error("finding Nation instance with conditon failed", re);
			throw re;
		}
	}

	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding Nation number with conditon: " );
		try {
			String queryString = "from Nation as model ";
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
			log.error("finding Nation number with conditon name failed", re);
		}
		return 0;
	}
}