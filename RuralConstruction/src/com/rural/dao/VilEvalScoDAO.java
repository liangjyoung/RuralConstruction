package com.rural.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.VilEvalSco;

/**
 	* A data access object (DAO) providing persistence and search support for VilEvalSco entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.rural.bean.VilEvalSco
  * @author MyEclipse Persistence Tools 
 */

public class VilEvalScoDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(VilEvalScoDAO.class);
		//property constants
	public static final String EXPERT_EVAL_TOT_GRA = "expertEvalTotGra";
	public static final String AUTO_EVAL_TOT_GRA = "autoEvalTotGra";
	public static final String VIL_EVAL_TOT_GRA = "vilEvalTotGra";
	public static final String VIL_EVAL_SCO_NOTE = "vilEvalScoNote";



	protected void initDao() {
		//do nothing
	}
    
    public void save(VilEvalSco transientInstance) {
        log.debug("saving VilEvalSco instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(VilEvalSco persistentInstance) {
        log.debug("deleting VilEvalSco instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VilEvalSco findById( java.lang.Integer id) {
        log.debug("getting VilEvalSco instance with id: " + id);
        try {
            VilEvalSco instance = (VilEvalSco) getHibernateTemplate()
                    .get("com.rural.bean.VilEvalSco", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(VilEvalSco instance) {
        log.debug("finding VilEvalSco instance by example");
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
      log.debug("finding VilEvalSco instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from VilEvalSco as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExpertEvalTotGra(Object expertEvalTotGra
	) {
		return findByProperty(EXPERT_EVAL_TOT_GRA, expertEvalTotGra
		);
	}
	
	public List findByAutoEvalTotGra(Object autoEvalTotGra
	) {
		return findByProperty(AUTO_EVAL_TOT_GRA, autoEvalTotGra
		);
	}
	
	public List findByVilEvalTotGra(Object vilEvalTotGra
	) {
		return findByProperty(VIL_EVAL_TOT_GRA, vilEvalTotGra
		);
	}
	
	public List findByVilEvalScoNote(Object vilEvalScoNote
	) {
		return findByProperty(VIL_EVAL_SCO_NOTE, vilEvalScoNote
		);
	}
	

	public List findAll() {
		log.debug("finding all VilEvalSco instances");
		try {
			String queryString = "from VilEvalSco";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public VilEvalSco merge(VilEvalSco detachedInstance) {
        log.debug("merging VilEvalSco instance");
        try {
            VilEvalSco result = (VilEvalSco) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VilEvalSco instance) {
        log.debug("attaching dirty VilEvalSco instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VilEvalSco instance) {
        log.debug("attaching clean VilEvalSco instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static VilEvalScoDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (VilEvalScoDAO) ctx.getBean("VilEvalScoDAO");
	}
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding VilEvalSco instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VilEvalSco as model where model."
					+ propertyName + "="+ value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List<VilEvalSco> findByConditionAndPager(String sql, List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding VilEvalSco instance with conditon: " );
		try {
			List<VilEvalSco> result = null;
			String queryString = "from VilEvalSco as model ";
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
			log.error("finding VilEvalSco instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding VilEvalSco number with conditon: " );
		try {
			String queryString = "from VilEvalSco as model ";
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
			log.error("finding VilEvalSco number with conditon name failed", re);
		}
		return 0;
	}
	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding VilEvalSco instance with sql: " + sql);
		try {
			String queryString = "from VilEvalSco as model where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
}