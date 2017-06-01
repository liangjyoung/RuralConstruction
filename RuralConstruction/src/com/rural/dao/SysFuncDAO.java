package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.SysFunc;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysFunc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.SysFunc
 * @author MyEclipse Persistence Tools
 */

public class SysFuncDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SysFuncDAO.class);
	// property constants
	public static final String FUNC_NAME = "funcName";

	protected void initDao() {
		// do nothing
	}

	public void save(SysFunc transientInstance) {
		log.debug("saving SysFunc instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SysFunc persistentInstance) {
		log.debug("deleting SysFunc instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SysFunc findById(java.lang.String id) {
		log.debug("getting SysFunc instance with id: " + id);
		try {
			SysFunc instance = (SysFunc) getHibernateTemplate().get(
					"com.rural.bean.SysFunc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SysFunc instance) {
		log.debug("finding SysFunc instance by example");
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
		log.debug("finding SysFunc instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SysFunc as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFuncName(Object funcName) {
		return findByProperty(FUNC_NAME, funcName);
	}

	public List findAll() {
		log.debug("finding all SysFunc instances");
		try {
			String queryString = "from SysFunc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SysFunc merge(SysFunc detachedInstance) {
		log.debug("merging SysFunc instance");
		try {
			SysFunc result = (SysFunc) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SysFunc instance) {
		log.debug("attaching dirty SysFunc instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SysFunc instance) {
		log.debug("attaching clean SysFunc instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SysFuncDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SysFuncDAO) ctx.getBean("SysFuncDAO");
	}
	
	public List findChild(String value) {
	       
        try {
           String queryString = "from SysFunc where SysFuncNum ='"+value+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
    public List findFather() {
        
        try {
           String queryString = "from SysFunc where SysFuncNum is null";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
    
   /* public List findFather(String parentId) {
        
        try {
           String queryString = "from SysFunc where SysFuncNum = '"+parentId+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}*/
 public List findFather(String parentId) {
        
        try {
           String queryString = "from SysFunc where FuncNum = '"+parentId+"'";
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}
}