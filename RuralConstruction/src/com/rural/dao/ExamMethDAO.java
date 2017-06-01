package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ExamMeth;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExamMeth entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.ExamMeth
 * @author MyEclipse Persistence Tools
 */

public class ExamMethDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ExamMethDAO.class);
	// property constants
	public static final String EXAM_METH_CODE = "examMethCode";
	public static final String EXAM_METH_NAME = "examMethName";
	public static final String EXAM_METH_NOTE = "examMethNote";

	protected void initDao() {
		// do nothing
	}

	public void save(ExamMeth transientInstance) {
		log.debug("saving ExamMeth instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ExamMeth persistentInstance) {
		log.debug("deleting ExamMeth instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExamMeth findById(java.lang.Integer id) {
		log.debug("getting ExamMeth instance with id: " + id);
		try {
			ExamMeth instance = (ExamMeth) getHibernateTemplate().get(
					"com.rural.bean.ExamMeth", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExamMeth instance) {
		log.debug("finding ExamMeth instance by example");
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
		log.debug("finding ExamMeth instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ExamMeth as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExamMethCode(Object examMethCode) {
		return findByProperty(EXAM_METH_CODE, examMethCode);
	}

	public List findByExamMethName(Object examMethName) {
		return findByProperty(EXAM_METH_NAME, examMethName);
	}

	public List findByExamMethNote(Object examMethNote) {
		return findByProperty(EXAM_METH_NOTE, examMethNote);
	}

	public List findAll() {
		log.debug("finding all ExamMeth instances");
		try {
			String queryString = "from ExamMeth";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ExamMeth merge(ExamMeth detachedInstance) {
		log.debug("merging ExamMeth instance");
		try {
			ExamMeth result = (ExamMeth) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ExamMeth instance) {
		log.debug("attaching dirty ExamMeth instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExamMeth instance) {
		log.debug("attaching clean ExamMeth instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExamMethDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExamMethDAO) ctx.getBean("ExamMethDAO");
	}
}