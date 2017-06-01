package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ProCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * ProCont entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.ProCont
 * @author MyEclipse Persistence Tools
 */

public class ProContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ProContDAO.class);
	// property constants
	public static final String PRO_CONT_NUM = "proContNum";
	public static final String PRO_CONT_NAME = "proContName";
	public static final String PRO_CONT_WORK_TEL = "proContWorkTel";
	public static final String PRO_CONT_MOB_TEL = "proContMobTel";
	public static final String PRO_CONT_COMP = "proContComp";
	public static final String PRO_CONT_POST = "proContPost";
	public static final String PRO_NOTE = "proNote";

	protected void initDao() {
		// do nothing
	}

	public void save(ProCont transientInstance) {
		log.debug("saving ProCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ProCont persistentInstance) {
		log.debug("deleting ProCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProCont findById(java.lang.Integer id) {
		log.debug("getting ProCont instance with id: " + id);
		try {
			ProCont instance = (ProCont) getHibernateTemplate().get(
					"com.rural.bean.ProCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ProCont instance) {
		log.debug("finding ProCont instance by example");
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
		log.debug("finding ProCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ProCont as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByProContNum(Object proContNum) {
		return findByProperty(PRO_CONT_NUM, proContNum);
	}

	public List findByProContName(Object proContName) {
		return findByProperty(PRO_CONT_NAME, proContName);
	}

	public List findByProContWorkTel(Object proContWorkTel) {
		return findByProperty(PRO_CONT_WORK_TEL, proContWorkTel);
	}

	public List findByProContMobTel(Object proContMobTel) {
		return findByProperty(PRO_CONT_MOB_TEL, proContMobTel);
	}

	public List findByProContComp(Object proContComp) {
		return findByProperty(PRO_CONT_COMP, proContComp);
	}

	public List findByProContPost(Object proContPost) {
		return findByProperty(PRO_CONT_POST, proContPost);
	}

	public List findByProNote(Object proNote) {
		return findByProperty(PRO_NOTE, proNote);
	}

	public List findAll() {
		log.debug("finding all ProCont instances");
		try {
			String queryString = "from ProCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ProCont merge(ProCont detachedInstance) {
		log.debug("merging ProCont instance");
		try {
			ProCont result = (ProCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ProCont instance) {
		log.debug("attaching dirty ProCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProCont instance) {
		log.debug("attaching clean ProCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ProContDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ProContDAO) ctx.getBean("ProContDAO");
	}
}