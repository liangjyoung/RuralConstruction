package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.InvgatDwork;
import com.rural.invgatdwork.action.InvgatDworkAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvgatDwork entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.InvgatDwork
 * @author MyEclipse Persistence Tools
 */

public class InvgatDworkDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InvgatDworkDAO.class);
	// property constants
	public static final String INVGAT_DWORK_NOTE = "invgatDworkNote";

	protected void initDao() {
		// do nothing
	}

	public void save(InvgatDwork transientInstance) {
		log.debug("saving InvgatDwork instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InvgatDwork persistentInstance) {
		log.debug("deleting InvgatDwork instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvgatDwork findById(java.lang.Integer id) {
		log.debug("getting InvgatDwork instance with id: " + id);
		try {
			InvgatDwork instance = (InvgatDwork) getHibernateTemplate().get(
					"com.rural.bean.InvgatDwork", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InvgatDwork instance) {
		log.debug("finding InvgatDwork instance by example");
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
		log.debug("finding InvgatDwork instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from InvgatDwork as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvgatDworkNote(Object invgatDworkNote) {
		return findByProperty(INVGAT_DWORK_NOTE, invgatDworkNote);
	}

	public List findAll() {
		log.debug("finding all InvgatDwork instances");
		try {
			String queryString = "from InvgatDwork";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InvgatDwork merge(InvgatDwork detachedInstance) {
		log.debug("merging InvgatDwork instance");
		try {
			InvgatDwork result = (InvgatDwork) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InvgatDwork instance) {
		log.debug("attaching dirty InvgatDwork instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvgatDwork instance) {
		log.debug("attaching clean InvgatDwork instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvgatDworkDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InvgatDworkDAO) ctx.getBean("InvgatDworkDAO");
	}
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding InvgatDwork number with conditon: " );
		try {
			int s = Integer.parseInt(InvgatDworkAction.getJQI().trim());
			String queryString = "from InvgatDwork as model where  VilBasicInfoID = "+s;
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
			log.error("finding InvgatDwork number with conditon name failed", re);
			throw re;
		}
	}
	
	public List<InvgatDwork> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding InvgatDwork instance with conditon: " );
		try {
			List<InvgatDwork> result = null;
			int s = Integer.parseInt(InvgatDworkAction.getJQI().trim());
			String queryString = "from InvgatDwork as model where InvgatID = "+s;
			
			//String orderRule = getOrderRule();
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);//+orderRule);  
			System.out.println(query);
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
			log.error("finding InvgatDwork instance with conditon failed", re);
			throw re;
		}
	}
	/**
	public List findByVilName(String vilNum){
		log.debug("finding VilBasicInfot list with VilNum: " );
		try {
			String queryString = "from VilBasicInfot vb where vb.VilNum = '" + vilNum + "'";
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("finding StuEvaluationResult list with loginName failed", re);
			throw re;
		}
	}
	**/	
	public List findByVilBasicInfoID(int vilBasicInfoID){
		log.debug("finding InvgatDwork list with vilBasicInfoID: " );
		try {
			//List<Invgat> result = null;
			//String s = InvgatDworkAction.getJQI();
			//String queryString = "from Invgat as model where InvgatNum = '"+s+"'";
			String queryString = "from InvgatDwork as model where vilBasicInfoID ="+vilBasicInfoID;
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("finding InvgatDwork instance with conditon failed", re);
			throw re;
		}
	}
}