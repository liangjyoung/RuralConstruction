package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalContInvesObj;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalContInvesObj entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.EvalContInvesObj
 * @author MyEclipse Persistence Tools
 */

public class EvalContInvesObjDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalContInvesObjDAO.class);
	// property constants
	public static final String IS_MUS = "isMus";
	public static final String EVAL_CONT_INVES_OBJ_SCOR_VALU = "evalContInvesObjScorValu";
	public static final String EVAL_CONT_INVES_OBJ_NOTE = "evalContInvesObjNote";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalContInvesObj transientInstance) {
		log.debug("saving EvalContInvesObj instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalContInvesObj persistentInstance) {
		log.debug("deleting EvalContInvesObj instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalContInvesObj findById(java.lang.Integer id) {
		log.debug("getting EvalContInvesObj instance with id: " + id);
		try {
			EvalContInvesObj instance = (EvalContInvesObj) getHibernateTemplate()
					.get("com.rural.bean.EvalContInvesObj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalContInvesObj instance) {
		log.debug("finding EvalContInvesObj instance by example");
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
		log.debug("finding EvalContInvesObj instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EvalContInvesObj as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsMus(Object isMus) {
		return findByProperty(IS_MUS, isMus);
	}

	public List findByEvalContInvesObjScorValu(Object evalContInvesObjScorValu) {
		return findByProperty(EVAL_CONT_INVES_OBJ_SCOR_VALU,
				evalContInvesObjScorValu);
	}

	public List findByEvalContInvesObjNote(Object evalContInvesObjNote) {
		return findByProperty(EVAL_CONT_INVES_OBJ_NOTE, evalContInvesObjNote);
	}

	public List findAll() {
		log.debug("finding all EvalContInvesObj instances");
		try {
			String queryString = "from EvalContInvesObj";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalContInvesObj merge(EvalContInvesObj detachedInstance) {
		log.debug("merging EvalContInvesObj instance");
		try {
			EvalContInvesObj result = (EvalContInvesObj) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalContInvesObj instance) {
		log.debug("attaching dirty EvalContInvesObj instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalContInvesObj instance) {
		log.debug("attaching clean EvalContInvesObj instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalContInvesObjDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EvalContInvesObjDAO) ctx.getBean("EvalContInvesObjDAO");
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContInvesObj number with conditon: " );
		try {
			String queryString = "from EvalContInvesObj as model ";
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
			log.error("finding EvalContInvesObj number with conditon name failed", re);
		}
		return 0;
	}
	
	public List<EvalContInvesObj> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContInvesObj instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<EvalContInvesObj> result = null;
			String queryString = "from EvalContInvesObj as model";
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
			log.error("finding EvalContInvesObj instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public List findCondition(String EvalMethID, String InvesObjid) {
		log.debug("finding EvalContInvesObj instance with property: " );
		try {
			String queryString = "from EvalContInvesObj as model where invesObj.invesObjId = "+InvesObjid+" and evalCont.evalContId = "+EvalMethID;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
}