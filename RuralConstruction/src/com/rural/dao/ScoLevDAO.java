package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ScoLev;

/**
 	* A data access object (DAO) providing persistence and search support for ScoLev entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.rural.bean.ScoLev
  * @author MyEclipse Persistence Tools 
 */

public class ScoLevDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ScoLevDAO.class);
		//property constants
	public static final String SCO_LEV_CODE = "scoLevCode";
	public static final String SCO_LEV_NAME = "scoLevName";
	public static final String SCO_UP = "scoUp";
	public static final String SCO_DOWN = "scoDown";



	protected void initDao() {
		//do nothing
	}
    
    public void save(ScoLev transientInstance) {
        log.debug("saving ScoLev instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ScoLev persistentInstance) {
        log.debug("deleting ScoLev instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ScoLev findById( java.lang.Integer id) {
        log.debug("getting ScoLev instance with id: " + id);
        try {
            ScoLev instance = (ScoLev) getHibernateTemplate()
                    .get("com.rural.bean.ScoLev", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ScoLev instance) {
        log.debug("finding ScoLev instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ScoLev instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ScoLev as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByScoLevCode(Object scoLevCode
	) {
		return findByProperty(SCO_LEV_CODE, scoLevCode
		);
	}
	
	public List findByScoLevName(Object scoLevName
	) {
		return findByProperty(SCO_LEV_NAME, scoLevName
		);
	}
	
	public List findByScoUp(Object scoUp
	) {
		return findByProperty(SCO_UP, scoUp
		);
	}
	
	public List findByScoDown(Object scoDown
	) {
		return findByProperty(SCO_DOWN, scoDown
		);
	}
	

	public List findAll() {
		log.debug("finding all ScoLev instances");
		try {
			String queryString = "from ScoLev";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ScoLev merge(ScoLev detachedInstance) {
        log.debug("merging ScoLev instance");
        try {
            ScoLev result = (ScoLev) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ScoLev instance) {
        log.debug("attaching dirty ScoLev instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ScoLev instance) {
        log.debug("attaching clean ScoLev instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ScoLevDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ScoLevDAO) ctx.getBean("ScoLevDAO");
	}
	
	
	public List<ScoLev> findByConditionAndPager(String sql, List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding ScoLev instance with conditon: " );
		try {
			List<ScoLev> result = null;
			String queryString = "from ScoLev as model ";
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
			log.error("finding ScoLev instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding ScoLev number with conditon: " );
		try {
			String queryString = "from ScoLev as model ";
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
			log.error("finding ScoLev number with conditon name failed", re);
		}
		return 0;
	}
	
}