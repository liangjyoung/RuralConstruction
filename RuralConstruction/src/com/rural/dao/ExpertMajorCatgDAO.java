package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ExpertMajorCatg;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExpertMajorCatg entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.ExpertMajorCatg
 * @author MyEclipse Persistence Tools
 */

public class ExpertMajorCatgDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ExpertMajorCatgDAO.class);
	// property constants
	public static final String EXPERT_MAJOR_NUM = "expertMajorNum";
	public static final String EXPERT_MAJOR_CATG = "expertMajorCatg";

	protected void initDao() {
		// do nothing
	}

	public void save(ExpertMajorCatg transientInstance) {
		log.debug("saving ExpertMajorCatg instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ExpertMajorCatg persistentInstance) {
		log.debug("deleting ExpertMajorCatg instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExpertMajorCatg findById(java.lang.Integer id) {
		log.debug("getting ExpertMajorCatg instance with id: " + id);
		try {
			ExpertMajorCatg instance = (ExpertMajorCatg) getHibernateTemplate()
					.get("com.rural.bean.ExpertMajorCatg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExpertMajorCatg instance) {
		log.debug("finding ExpertMajorCatg instance by example");
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
		log.debug("finding ExpertMajorCatg instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ExpertMajorCatg as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExpertMajorNum(Object expertMajorNum) {
		return findByProperty(EXPERT_MAJOR_NUM, expertMajorNum);
	}

	public List findByExpertMajorCatg(Object expertMajorCatg) {
		return findByProperty(EXPERT_MAJOR_CATG, expertMajorCatg);
	}

	public List findAll() {
		log.debug("finding all ExpertMajorCatg instances");
		try {
			String queryString = "from ExpertMajorCatg";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ExpertMajorCatg merge(ExpertMajorCatg detachedInstance) {
		log.debug("merging ExpertMajorCatg instance");
		try {
			ExpertMajorCatg result = (ExpertMajorCatg) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ExpertMajorCatg instance) {
		log.debug("attaching dirty ExpertMajorCatg instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExpertMajorCatg instance) {
		log.debug("attaching clean ExpertMajorCatg instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpertMajorCatgDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ExpertMajorCatgDAO) ctx.getBean("ExpertMajorCatgDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding ExpertMajorCatg number with conditon: " );
		try {
			String queryString = "from ExpertMajorCatg as model ";
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
			log.error("finding ExpertMajorCatg number with conditon name failed", re);
		}
		return 0;
	}
	public List<ExpertMajorCatg> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding ExpertMajorCatg instance with conditon: " );
		try {
			List<ExpertMajorCatg> result = null;
			String queryString = "from ExpertMajorCatg as model ";
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
			log.error("finding ExpertMajorCatg instance with conditon failed", re);
			throw re;
		}
	}
}