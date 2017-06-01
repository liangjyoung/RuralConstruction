package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Query;
import com.rural.bean.InvesObj;
import com.rural.bean.InvesObj;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvesObj entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.InvesObj
 * @author MyEclipse Persistence Tools
 */

public class InvesObjDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InvesObjDAO.class);
	// property constants
	public static final String INVES_OBJ_CODE = "invesObjCode";
	public static final String INVES_OBJ_NAME = "invesObjName";
	public static final String INVES_OBJ_COMP = "invesObjComp";
	public static final String INVES_OBJ_LENGT = "invesObjLengt";
	public static final String IS_MUST_COLL_DATA = "isMustCollData";
	public static final String INVES_OBJ_NOTE = "invesObjNote";

	protected void initDao() {
		// do nothing
	}

	public void save(InvesObj transientInstance) {
		log.debug("saving InvesObj instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InvesObj persistentInstance) {
		log.debug("deleting InvesObj instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvesObj findById(java.lang.Integer id) {
		log.debug("getting InvesObj instance with id: " + id);
		try {
			InvesObj instance = (InvesObj) getHibernateTemplate().get(
					"com.rural.bean.InvesObj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InvesObj instance) {
		log.debug("finding InvesObj instance by example");
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
		log.debug("finding InvesObj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from InvesObj as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvesObjCode(Object invesObjCode) {
		return findByProperty(INVES_OBJ_CODE, invesObjCode);
	}

	public List findByInvesObjName(Object invesObjName) {
		return findByProperty(INVES_OBJ_NAME, invesObjName);
	}

	public List findByInvesObjComp(Object invesObjComp) {
		return findByProperty(INVES_OBJ_COMP, invesObjComp);
	}

	public List findByInvesObjLengt(Object invesObjLengt) {
		return findByProperty(INVES_OBJ_LENGT, invesObjLengt);
	}

	public List findByIsMustCollData(Object isMustCollData) {
		return findByProperty(IS_MUST_COLL_DATA, isMustCollData);
	}

	public List findByInvesObjNote(Object invesObjNote) {
		return findByProperty(INVES_OBJ_NOTE, invesObjNote);
	}

	public List findAll() {
		log.debug("finding all InvesObj instances");
		try {
			String queryString = "from InvesObj";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InvesObj merge(InvesObj detachedInstance) {
		log.debug("merging InvesObj instance");
		try {
			InvesObj result = (InvesObj) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InvesObj instance) {
		log.debug("attaching dirty InvesObj instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvesObj instance) {
		log.debug("attaching clean InvesObj instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvesObjDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InvesObjDAO) ctx.getBean("InvesObjDAO");
	}
	
	
	
	public List<InvesObj> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding InvesObj instance with conditon: " );
		try {
			List<InvesObj> result = null;
		//	String s =InvesObjAction.getJQS();
			String queryString = " from InvesObj as model ";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString+"order by invesObjCode");//+orderRule);  
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
			log.error("finding InvesObj instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding InvesObj number with conditon: " );
		try {
			//String s = InvesObjAction.getJQS();
		String queryString = " from InvesObj  as model";
		//	String queryString = "select * from InvesObj  where InvesPro.InvesProNum = '"+s+"'";
		//	String queryString = "select * from InvesObj  where InvesPro.InvesProNum = '01.01.00.00'";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding InvesObj number with conditon name failed", re);
			throw re;
		}
	}
	
	
	
	
	public int getObjCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding InvesObj number with conditon: " );
		try {
			String queryString = "from InvesObj as model ";
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
			log.error("finding InvesObj number with conditon name failed", re);
		}
		return 0;
	}
}