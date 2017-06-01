package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalExpertDist;
import com.rural.expertselect.action.ExpertSelectAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalExpertDist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.EvalExpertDist
 * @author MyEclipse Persistence Tools
 */

public class EvalExpertDistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalExpertDistDAO.class);
	// property constants
	public static final String IS_SUB = "isSub";
	public static final String EVAL_EXPERT_DIST_NOTE = "evalExpertDistNote";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalExpertDist transientInstance) {
		log.debug("saving EvalExpertDist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalExpertDist persistentInstance) {
		log.debug("deleting EvalExpertDist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalExpertDist findById(java.lang.Integer id) {
		log.debug("getting EvalExpertDist instance with id: " + id);
		try {
			EvalExpertDist instance = (EvalExpertDist) getHibernateTemplate()
					.get("com.rural.bean.EvalExpertDist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalExpertDist instance) {
		log.debug("finding EvalExpertDist instance by example");
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
		log.debug("finding EvalExpertDist instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EvalExpertDist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIsSub(Object isSub) {
		return findByProperty(IS_SUB, isSub);
	}

	public List findByEvalExpertDistNote(Object evalExpertDistNote) {
		return findByProperty(EVAL_EXPERT_DIST_NOTE, evalExpertDistNote);
	}

	public List findAll() {
		log.debug("finding all EvalExpertDist instances");
		try {
			String queryString = "from EvalExpertDist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalExpertDist merge(EvalExpertDist detachedInstance) {
		log.debug("merging EvalExpertDist instance");
		try {
			EvalExpertDist result = (EvalExpertDist) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalExpertDist instance) {
		log.debug("attaching dirty EvalExpertDist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalExpertDist instance) {
		log.debug("attaching clean EvalExpertDist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalExpertDistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EvalExpertDistDAO) ctx.getBean("EvalExpertDistDAO");
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<EvalExpertDist> findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding EvalExpertDist instance with sql: "
				+ sql);
		try {
			String queryString = "from EvalExpertDist where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalExpertDist number with conditon: " );
		try {
			String queryString = "from EvalExpertDist as model ";
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
			log.error("finding EvalExpertDist number with conditon name failed", re);
		}
		return 0;
	}
	
	
	
	public List<EvalExpertDist> findByConditionAndPager( String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalExpertDist instance with conditon: " );
		try {
			
			
			List<EvalExpertDist> result = null;
			String queryString = "from EvalExpertDist as model ";
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
	        query.list();
	  
	        result = query.list();  
	        
	       
	        return result;
		} catch (RuntimeException re) {
			log.error("finding EvalExpertDist instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public List<EvalExpertDist> findByConditionAndPager2( String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalExpertDist instance with conditon: " );
		try {
			
			
			List<EvalExpertDist> result = null;
			Integer s = ExpertSelectAction.getDfid();
			String queryString = "from EvalExpertDist as model where VilEvalScoID="+s;
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding EvalExpertDist instance with conditon failed", re);
			throw re;
		}
	}
}