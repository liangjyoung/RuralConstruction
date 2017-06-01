package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.Edu;

/**
 * A data access object (DAO) providing persistence and search support for Edu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.rural.bean.Edu
 * @author MyEclipse Persistence Tools
 */

public class EduDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EduDAO.class);
	// property constants
	public static final String EDU_CODE = "eduCode";
	public static final String EDU_NAME = "eduName";

	protected void initDao() {
		// do nothing
	}

	public void save(Edu transientInstance) {
		log.debug("saving Edu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Edu persistentInstance) {
		log.debug("deleting Edu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Edu findById(java.lang.Integer id) {
		log.debug("getting Edu instance with id: " + id);
		try {
			Edu instance = (Edu) getHibernateTemplate().get(
					"com.rural.bean.Edu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Edu instance) {
		log.debug("finding Edu instance by example");
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
		log.debug("finding Edu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Edu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEduCode(Object eduCode) {
		return findByProperty(EDU_CODE, eduCode);
	}

	public List findByEduName(Object eduName) {
		return findByProperty(EDU_NAME, eduName);
	}

	public List findAll() {
		log.debug("finding all Edu instances");
		try {
			String queryString = "from Edu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Edu merge(Edu detachedInstance) {
		log.debug("merging Edu instance");
		try {
			Edu result = (Edu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Edu instance) {
		log.debug("attaching dirty Edu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Edu instance) {
		log.debug("attaching clean Edu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduDAO) ctx.getBean("EduDAO");
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding Edu number with conditon: " );
		try {
			String queryString = "from Edu as model ";
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
			log.error("finding Edu number with conditon name failed", re);
		}
		return 0;
	}
	public List<Edu> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding Edu instance with conditon: " );
		try {
			List<Edu> result = null;
			String queryString = "from Edu as model ";
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
			log.error("finding Edu instance with conditon failed", re);
			throw re;
		}
	}
}