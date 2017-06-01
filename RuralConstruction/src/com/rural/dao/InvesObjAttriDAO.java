package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.InvesObjAttri;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvesObjAttri entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.InvesObjAttri
 * @author MyEclipse Persistence Tools
 */

public class InvesObjAttriDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InvesObjAttriDAO.class);
	// property constants
	public static final String INVES_OBJ_ATTRI_NUM = "invesObjAttriNum";
	public static final String INVES_OBJ_ATTRI_NAME = "invesObjAttriName";

	protected void initDao() {
		// do nothing
	}

	public void save(InvesObjAttri transientInstance) {
		log.debug("saving InvesObjAttri instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InvesObjAttri persistentInstance) {
		log.debug("deleting InvesObjAttri instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvesObjAttri findById(java.lang.Integer id) {
		log.debug("getting InvesObjAttri instance with id: " + id);
		try {
			InvesObjAttri instance = (InvesObjAttri) getHibernateTemplate()
					.get("com.rural.bean.InvesObjAttri", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InvesObjAttri instance) {
		log.debug("finding InvesObjAttri instance by example");
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
		log.debug("finding InvesObjAttri instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from InvesObjAttri as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvesObjAttriNum(Object invesObjAttriNum) {
		return findByProperty(INVES_OBJ_ATTRI_NUM, invesObjAttriNum);
	}

	public List findByInvesObjAttriName(Object invesObjAttriName) {
		return findByProperty(INVES_OBJ_ATTRI_NAME, invesObjAttriName);
	}

	public List findAll() {
		log.debug("finding all InvesObjAttri instances");
		try {
			String queryString = "from InvesObjAttri";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InvesObjAttri merge(InvesObjAttri detachedInstance) {
		log.debug("merging InvesObjAttri instance");
		try {
			InvesObjAttri result = (InvesObjAttri) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InvesObjAttri instance) {
		log.debug("attaching dirty InvesObjAttri instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvesObjAttri instance) {
		log.debug("attaching clean InvesObjAttri instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvesObjAttriDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InvesObjAttriDAO) ctx.getBean("InvesObjAttriDAO");
	}
	
	public List<InvesObjAttri> findByConditionAndPager(String sql,	List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding InvesObjAttri instance with conditon: " );
		try {
			List<InvesObjAttri> result = null;
			String queryString = "from InvesObjAttri as model ";
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
			log.error("finding InvesObjAttri instance with conditon failed", re);
			throw re;
		}
	}

	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding InvesObjAttri number with conditon: " );
		try {
			String queryString = "from InvesObjAttri as model ";
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
			log.error("finding InvesObjAttri number with conditon name failed", re);
		}
		return 0;
	}
}