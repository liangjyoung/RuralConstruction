package com.rural.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.VilFil;
import com.rural.govfile.action.VilFilAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * VilFil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.VilFil
 * @author MyEclipse Persistence Tools
 */

public class VilFilDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(VilFilDAO.class);
	// property constants
	public static final String VIL_FIL_NUM = "vilFilNum";
	public static final String VIL_FIL_NAME = "vilFilName";
	public static final String VIL_FIL_IDEF = "vilFilIdef";
	public static final String VIL_FIL_PUB_COMP = "vilFilPubComp";
	public static final String VIL_FIL_EXPL = "vilFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(VilFil transientInstance) {
		log.debug("saving VilFil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VilFil persistentInstance) {
		log.debug("deleting VilFil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VilFil findById(java.lang.Integer id) {
		log.debug("getting VilFil instance with id: " + id);
		try {
			VilFil instance = (VilFil) getHibernateTemplate().get(
					"com.rural.bean.VilFil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VilFil instance) {
		log.debug("finding VilFil instance by example");
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
		log.debug("finding VilFil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VilFil as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVilFilNum(Object vilFilNum) {
		return findByProperty(VIL_FIL_NUM, vilFilNum);
	}

	public List findByVilFilName(Object vilFilName) {
		return findByProperty(VIL_FIL_NAME, vilFilName);
	}

	public List findByVilFilIdef(Object vilFilIdef) {
		return findByProperty(VIL_FIL_IDEF, vilFilIdef);
	}

	public List findByVilFilPubComp(Object vilFilPubComp) {
		return findByProperty(VIL_FIL_PUB_COMP, vilFilPubComp);
	}

	public List findByVilFilExpl(Object vilFilExpl) {
		return findByProperty(VIL_FIL_EXPL, vilFilExpl);
	}

	public List findAll() {
		log.debug("finding all VilFil instances");
		try {
			String queryString = "from VilFil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VilFil merge(VilFil detachedInstance) {
		log.debug("merging VilFil instance");
		try {
			VilFil result = (VilFil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VilFil instance) {
		log.debug("attaching dirty VilFil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VilFil instance) {
		log.debug("attaching clean VilFil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VilFilDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VilFilDAO) ctx.getBean("VilFilDAO");
	}
	public List<VilFil> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding VilFil instance with conditon: " );
		try {
			List<VilFil> result = null;
			String s = VilFilAction.getJQS();
			String queryString = "from VilFil as model where GoveFilClfyID= '"+s+"'";
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);//+orderRule);  
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
			log.error("finding VilFil instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding VilFil number with conditon: " );
		try {
			String s = VilFilAction.getJQS();
			String queryString = "from VilFil as model where GoveFilClfyID ='"+s+"'";
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding VilFil number with conditon name failed", re);
			throw re;
		}
	}
}