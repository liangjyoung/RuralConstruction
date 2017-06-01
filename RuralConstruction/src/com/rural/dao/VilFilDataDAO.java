package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.VilFilData;

/**
 * A data access object (DAO) providing persistence and search support for
 * VilFilData entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.VilFilData
 * @author MyEclipse Persistence Tools
 */

public class VilFilDataDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(VilFilDataDAO.class);
	// property constants
	public static final String VIL_FIL_IDEF = "vilFilIdef";
	public static final String VIL_FIL_EXPL = "vilFilExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(VilFilData transientInstance) {
		log.debug("saving VilFilData instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VilFilData persistentInstance) {
		log.debug("deleting VilFilData instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VilFilData findById(java.lang.Integer id) {
		log.debug("getting VilFilData instance with id: " + id);
		try {
			VilFilData instance = (VilFilData) getHibernateTemplate().get(
					"com.rural.bean.VilFilData", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VilFilData instance) {
		log.debug("finding VilFilData instance by example");
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
		log.debug("finding VilFilData instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VilFilData as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVilFilIdef(Object vilFilIdef) {
		return findByProperty(VIL_FIL_IDEF, vilFilIdef);
	}

	public List findByVilFilExpl(Object vilFilExpl) {
		return findByProperty(VIL_FIL_EXPL, vilFilExpl);
	}

	public List findAll() {
		log.debug("finding all VilFilData instances");
		try {
			String queryString = "from VilFilData";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VilFilData merge(VilFilData detachedInstance) {
		log.debug("merging VilFilData instance");
		try {
			VilFilData result = (VilFilData) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VilFilData instance) {
		log.debug("attaching dirty VilFilData instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			System.out.println(re);
			throw re;
		}
	}

	public void attachClean(VilFilData instance) {
		log.debug("attaching clean VilFilData instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VilFilDataDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VilFilDataDAO) ctx.getBean("VilFilDataDAO");
	}

	@SuppressWarnings("unchecked")
	public List<VilFilData> findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding VilFilData instance with sql: " + sql);
		try {
			String queryString = "from VilFilData as model where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	public List findRecIDAndInvID(int  RecID, int invojid) {
		log.debug("finding VilFilData instance with property: ");
		try {
			String queryString = "from VilFilData as model where vilDataCollRec.vilDataCollRecId = "+RecID+" and invesObj.invesObjId = "+invojid;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}