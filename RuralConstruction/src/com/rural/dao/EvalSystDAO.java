package com.rural.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalSyst;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalSyst entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.EvalSyst
 * @author MyEclipse Persistence Tools
 */

public class EvalSystDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalSystDAO.class);
	// property constants
	public static final String EVAL_SYST_NAME = "evalSystName";
	public static final String EVAL_SYST_NOTE = "evalSystNote";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalSyst transientInstance) {
		log.debug("saving EvalSyst instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalSyst persistentInstance) {
		log.debug("deleting EvalSyst instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalSyst findById(java.lang.Integer id) {
		log.debug("getting EvalSyst instance with id: " + id);
		try {
			EvalSyst instance = (EvalSyst) getHibernateTemplate().get(
					"com.rural.bean.EvalSyst", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalSyst instance) {
		log.debug("finding EvalSyst instance by example");
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
		log.debug("finding EvalSyst instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EvalSyst as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEvalSystName(Object evalSystName) {
		return findByProperty(EVAL_SYST_NAME, evalSystName);
	}

	public List findByEvalSystNote(Object evalSystNote) {
		return findByProperty(EVAL_SYST_NOTE, evalSystNote);
	}

	public List findAll() {
		log.debug("finding all EvalSyst instances");
		try {
			String queryString = "from EvalSyst";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalSyst merge(EvalSyst detachedInstance) {
		log.debug("merging EvalSyst instance");
		try {
			EvalSyst result = (EvalSyst) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalSyst instance) {
		log.debug("attaching dirty EvalSyst instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalSyst instance) {
		log.debug("attaching clean EvalSyst instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalSystDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EvalSystDAO) ctx.getBean("EvalSystDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalSyst number with conditon: " );
		try {
			String queryString = "from EvalSyst as model ";
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
			log.error("finding EvalSyst number with conditon name failed", re);
		}
		return 0;
	}
	
	public List<EvalSyst> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalSyst instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<EvalSyst> result = null;
			String queryString = "from EvalSyst as model";
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
			log.error("finding EvalSyst instance with conditon failed", re);
			throw re;
		}
	}
}