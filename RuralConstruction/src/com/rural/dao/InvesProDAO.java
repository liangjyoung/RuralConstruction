package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.InvesPro;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvesPro entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.InvesPro
 * @author MyEclipse Persistence Tools
 */

public class InvesProDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InvesProDAO.class);
	// property constants
	public static final String INVES_PRO_NAME = "invesProName";
	public static final String INVES_PRO_NOTE = "invesProNote";

	protected void initDao() {
		// do nothing
	}

	public void save(InvesPro transientInstance) {
		log.debug("saving InvesPro instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InvesPro persistentInstance) {
		log.debug("deleting InvesPro instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvesPro findById(java.lang.String id) {
		log.debug("getting InvesPro instance with id: " + id);
		try {
			InvesPro instance = (InvesPro) getHibernateTemplate().get(
					"com.rural.bean.InvesPro", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InvesPro instance) {
		log.debug("finding InvesPro instance by example");
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
		log.debug("finding InvesPro instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from InvesPro as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvesProName(Object invesProName) {
		return findByProperty(INVES_PRO_NAME, invesProName);
	}

	public List findByInvesProNote(Object invesProNote) {
		return findByProperty(INVES_PRO_NOTE, invesProNote);
	}

	public List findAll() {
		log.debug("finding all InvesPro instances");
		try {
			String queryString = "from InvesPro";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InvesPro merge(InvesPro detachedInstance) {
		log.debug("merging InvesPro instance");
		try {
			InvesPro result = (InvesPro) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InvesPro instance) {
		log.debug("attaching dirty InvesPro instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvesPro instance) {
		log.debug("attaching clean InvesPro instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvesProDAO getFromApplicationContext(ApplicationContext ctx) {
		return (InvesProDAO) ctx.getBean("InvesProDAO");
	}
	
public List findFather(String parentId) {
        
        try {
           String queryString = "from InvesPro where InvesProNum = '"+parentId+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
 
 
 public List findChild(String value) {
       
        try {
           String queryString = "from InvesPro where UpInvesProNum ='"+value+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public List findFather() {
        
        try {
           String queryString = "from InvesPro where UpInvesProNum is null";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
}