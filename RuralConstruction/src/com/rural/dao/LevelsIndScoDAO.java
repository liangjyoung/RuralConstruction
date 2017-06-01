package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.LevelsIndSco;
import com.rural.bean.VilDataCollRec;

/**
 	* A data access object (DAO) providing persistence and search support for LevelsIndSco entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.rural.bean.LevelsIndSco
  * @author MyEclipse Persistence Tools 
 */

public class LevelsIndScoDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(LevelsIndScoDAO.class);
		//property constants
	public static final String LEVELS_IND_SCO = "levelsIndSco";



	protected void initDao() {
		//do nothing
	}
    
    public void save(LevelsIndSco transientInstance) {
        log.debug("saving LevelsIndSco instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LevelsIndSco persistentInstance) {
        log.debug("deleting LevelsIndSco instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LevelsIndSco findById( java.lang.Integer id) {
        log.debug("getting LevelsIndSco instance with id: " + id);
        try {
            LevelsIndSco instance = (LevelsIndSco) getHibernateTemplate()
                    .get("com.rural.bean.LevelsIndSco", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LevelsIndSco instance) {
        log.debug("finding LevelsIndSco instance by example");
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
      log.debug("finding LevelsIndSco instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LevelsIndSco as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLevelsIndSco(Object levelsIndSco
	) {
		return findByProperty(LEVELS_IND_SCO, levelsIndSco
		);
	}
	

	public List findAll() {
		log.debug("finding all LevelsIndSco instances");
		try {
			String queryString = "from LevelsIndSco";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LevelsIndSco merge(LevelsIndSco detachedInstance) {
        log.debug("merging LevelsIndSco instance");
        try {
            LevelsIndSco result = (LevelsIndSco) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LevelsIndSco instance) {
        log.debug("attaching dirty LevelsIndSco instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LevelsIndSco instance) {
        log.debug("attaching clean LevelsIndSco instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static LevelsIndScoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (LevelsIndScoDAO) ctx.getBean("LevelsIndScoDAO");
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding LevelsIndSco instance with sql: " + sql);
		try {
			String queryString = "from LevelsIndSco as model where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	
	
	
public List<LevelsIndSco> findLevelsIndSco(String evalIndNum, int VilEvalScoId) {
		
	LevelsIndSco levelsIndSco = new  LevelsIndSco();
		
		
		try {
			String queryString = "from LevelsIndSco as model where evalSystInd.evalIndNum ='"+evalIndNum+"' and vilEvalSco.vilEvalScoId ="+VilEvalScoId;
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

}