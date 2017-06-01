package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.GoveFilClfy;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoveFilClfy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.GoveFilClfy
 * @author MyEclipse Persistence Tools
 */

public class GoveFilClfyDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(GoveFilClfyDAO.class);
	// property constants
	public static final String GOVE_FIL_CLFY_NUM = "goveFilClfyNum";
	public static final String GOVE_FIL_CLFY_NAME = "goveFilClfyName";
	public static final String GOVE_FIL_CLFY_NOTE = "goveFilClfyNote";

	protected void initDao() {
		// do nothing
	}

	public void save(GoveFilClfy transientInstance) {
		log.debug("saving GoveFilClfy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GoveFilClfy persistentInstance) {
		log.debug("deleting GoveFilClfy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GoveFilClfy findById(java.lang.Integer id) {
		log.debug("getting GoveFilClfy instance with id: " + id);
		try {
			GoveFilClfy instance = (GoveFilClfy) getHibernateTemplate().get(
					"com.rural.bean.GoveFilClfy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoveFilClfy instance) {
		log.debug("finding GoveFilClfy instance by example");
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
		log.debug("finding GoveFilClfy instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GoveFilClfy as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoveFilClfyNum(Object goveFilClfyNum) {
		return findByProperty(GOVE_FIL_CLFY_NUM, goveFilClfyNum);
	}

	public List findByGoveFilClfyName(Object goveFilClfyName) {
		return findByProperty(GOVE_FIL_CLFY_NAME, goveFilClfyName);
	}

	public List findByGoveFilClfyNote(Object goveFilClfyNote) {
		return findByProperty(GOVE_FIL_CLFY_NOTE, goveFilClfyNote);
	}

	public List findAll() {
		log.debug("finding all GoveFilClfy instances");
		try {
			String queryString = "from GoveFilClfy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoveFilClfy merge(GoveFilClfy detachedInstance) {
		log.debug("merging GoveFilClfy instance");
		try {
			GoveFilClfy result = (GoveFilClfy) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoveFilClfy instance) {
		log.debug("attaching dirty GoveFilClfy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoveFilClfy instance) {
		log.debug("attaching clean GoveFilClfy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoveFilClfyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (GoveFilClfyDAO) ctx.getBean("GoveFilClfyDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding GoveFilClfy number with conditon: " );
		try {
			String queryString = "from GoveFilClfy as model ";
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
			log.error("finding GoveFilClfy number with conditon name failed", re);
		}
		return 0;
	}
	public List<GoveFilClfy> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding GoveFilClfy instance with conditon: " );
		try {
			List<GoveFilClfy> result = null;
			String queryString = "from GoveFilClfy as model ";
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
			log.error("finding GoveFilClfy instance with conditon failed", re);
			throw re;
		}
	}
}