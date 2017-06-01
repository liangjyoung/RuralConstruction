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

import com.rural.bean.Invgat;

/**
 * A data access object (DAO) providing persistence and search support for
 * Invgat entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.Invgat
 * @author MyEclipse Persistence Tools
 */

public class InvgatDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(InvgatDAO.class);
	// property constants
	public static final String INVGAT_NUM = "invgatNum";
	public static final String INVGAT_MAJOR = "invgatMajor";
	public static final String INVGAT_NAME = "invgatName";
	public static final String INVGAT_COMP = "invgatComp";
	public static final String INVGAT_TEL = "invgatTel";
	public static final String INVGAT_NOTE = "invgatNote";

	protected void initDao() {
		// do nothing
	}

	public void save(Invgat transientInstance) {
		log.debug("saving Invgat instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Invgat persistentInstance) {
		log.debug("deleting Invgat instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Invgat findById(java.lang.Integer id) {
		log.debug("getting Invgat instance with id: " + id);
		try {
			Invgat instance = (Invgat) getHibernateTemplate().get(
					"com.rural.bean.Invgat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Invgat instance) {
		log.debug("finding Invgat instance by example");
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
		log.debug("finding Invgat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Invgat as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvgatNum(Object invgatNum) {
		return findByProperty(INVGAT_NUM, invgatNum);
	}

	public List findByInvgatMajor(Object invgatMajor) {
		return findByProperty(INVGAT_MAJOR, invgatMajor);
	}

	public List findByInvgatName(Object invgatName) {
		return findByProperty(INVGAT_NAME, invgatName);
	}

	public List findByInvgatComp(Object invgatComp) {
		return findByProperty(INVGAT_COMP, invgatComp);
	}

	public List findByInvgatTel(Object invgatTel) {
		return findByProperty(INVGAT_TEL, invgatTel);
	}

	public List findByInvgatNote(Object invgatNote) {
		return findByProperty(INVGAT_NOTE, invgatNote);
	}

	public List findAll() {
		log.debug("finding all Invgat instances");
		try {
			String queryString = "from Invgat";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Invgat merge(Invgat detachedInstance) {
		log.debug("merging Invgat instance");
		try {
			Invgat result = (Invgat) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Invgat instance) {
		log.debug("attaching dirty Invgat instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Invgat instance) {
		log.debug("attaching clean Invgat instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvgatDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InvgatDAO) ctx.getBean("InvgatDAO");
	}
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding Invgat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Invgat as model where model."
				+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding Invgat number with conditon: " );
		try {
			String queryString = "from Invgat as model ";
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
			log.error("finding Invgat number with conditon name failed", re);
		}
		return 0;
	}
	public List<Invgat> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding Invgat instance with conditon: " );
		try {
			List<Invgat> result = null;
			
			String queryString = "from Invgat as model ";
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
			log.error("finding Invgat instance with conditon failed", re);
			throw re;
		}
	}
}