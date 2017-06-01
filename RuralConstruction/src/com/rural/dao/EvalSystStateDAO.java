package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalSystState;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalSystState entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.EvalSystState
 * @author MyEclipse Persistence Tools
 */

public class EvalSystStateDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalSystStateDAO.class);
	// property constants
	public static final String EVAL_SYST_STATE_NUM = "evalSystStateNum";
	public static final String EVAL_SYST_STATE_DES = "evalSystStateDes";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalSystState transientInstance) {
		log.debug("saving EvalSystState instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalSystState persistentInstance) {
		log.debug("deleting EvalSystState instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalSystState findById(java.lang.Integer id) {
		log.debug("getting EvalSystState instance with id: " + id);
		try {
			EvalSystState instance = (EvalSystState) getHibernateTemplate()
					.get("com.rural.bean.EvalSystState", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalSystState instance) {
		log.debug("finding EvalSystState instance by example");
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
		log.debug("finding EvalSystState instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EvalSystState as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEvalSystStateNum(Object evalSystStateNum) {
		return findByProperty(EVAL_SYST_STATE_NUM, evalSystStateNum);
	}

	public List findByEvalSystStateDes(Object evalSystStateDes) {
		return findByProperty(EVAL_SYST_STATE_DES, evalSystStateDes);
	}

	public List findAll() {
		log.debug("finding all EvalSystState instances");
		try {
			String queryString = "from EvalSystState";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalSystState merge(EvalSystState detachedInstance) {
		log.debug("merging EvalSystState instance");
		try {
			EvalSystState result = (EvalSystState) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalSystState instance) {
		log.debug("attaching dirty EvalSystState instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalSystState instance) {
		log.debug("attaching clean EvalSystState instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalSystStateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EvalSystStateDAO) ctx.getBean("EvalSystStateDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalSystState number with conditon: " );
		try {
			String queryString = "from EvalSystState as model ";
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
			log.error("finding EvalSystState number with conditon name failed", re);
		}
		return 0;
	}
	public List<EvalSystState> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalSystState instance with conditon: " );
		try {
			List<EvalSystState> result = null;
			String queryString = "from EvalSystState as model ";
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
			log.error("finding EvalSystState instance with conditon failed", re);
			throw re;
		}
	}
}