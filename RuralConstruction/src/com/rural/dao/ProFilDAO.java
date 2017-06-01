package com.rural.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ProFil;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProFil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.ProFil
 * @author MyEclipse Persistence Tools
 */

public class ProFilDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProFilDAO.class);
	// property constants
	public static final String PRO_FIL_NUM = "proFilNum";
	public static final String PRO_FIL_NAME = "proFilName";
	public static final String PRO_FIL_IDEF = "proFilIdef";
	public static final String PRO_FIL_PUB_COMP = "proFilPubComp";
	public static final String PRO_FIL_EXPL = "proFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(ProFil transientInstance) {
		log.debug("saving ProFil instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProFil persistentInstance) {
		log.debug("deleting ProFil instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProFil findById(java.lang.Integer id) {
		log.debug("getting ProFil instance with id: " + id);
		try {
			ProFil instance = (ProFil) getHibernateTemplate().get(
					"com.rural.bean.ProFil", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProFil instance) {
		log.debug("finding ProFil instance by example");
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
		log.debug("finding ProFil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProFil as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProFilNum(Object proFilNum) {
		return findByProperty(PRO_FIL_NUM, proFilNum);
	}

	public List findByProFilName(Object proFilName) {
		return findByProperty(PRO_FIL_NAME, proFilName);
	}

	public List findByProFilIdef(Object proFilIdef) {
		return findByProperty(PRO_FIL_IDEF, proFilIdef);
	}

	public List findByProFilPubComp(Object proFilPubComp) {
		return findByProperty(PRO_FIL_PUB_COMP, proFilPubComp);
	}

	public List findByProFilExpl(Object proFilExpl) {
		return findByProperty(PRO_FIL_EXPL, proFilExpl);
	}

	public List findAll() {
		log.debug("finding all ProFil instances");
		try {
			String queryString = "from ProFil";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProFil merge(ProFil detachedInstance) {
		log.debug("merging ProFil instance");
		try {
			ProFil result = (ProFil) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProFil instance) {
		log.debug("attaching dirty ProFil instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProFil instance) {
		log.debug("attaching clean ProFil instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProFilDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProFilDAO) ctx.getBean("ProFilDAO");
	}
}