package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.PrmtMeas;

/**
 	* A data access object (DAO) providing persistence and search support for PrmtMeas entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.rural.bean.PrmtMeas
  * @author MyEclipse Persistence Tools 
 */

public class PrmtMeasDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PrmtMeasDAO.class);
		//property constants
	public static final String PRMT_MEAS = "prmtMeas";
	public static final String PRMT_MEAS_COMP = "prmtMeasComp";
	public static final String PRMT_MEAS_VALUE = "prmtMeasValue";
	public static final String EXPECT_PRMT_SCO = "expectPrmtSco";
	public static final String PRMT_MEAS_NOTE = "prmtMeasNote";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PrmtMeas transientInstance) {
        log.debug("saving PrmtMeas instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PrmtMeas persistentInstance) {
        log.debug("deleting PrmtMeas instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PrmtMeas findById( java.lang.Integer id) {
        log.debug("getting PrmtMeas instance with id: " + id);
        try {
            PrmtMeas instance = (PrmtMeas) getHibernateTemplate()
                    .get("com.rural.bean.PrmtMeas", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PrmtMeas instance) {
        log.debug("finding PrmtMeas instance by example");
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
      log.debug("finding PrmtMeas instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PrmtMeas as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPrmtMeas(Object prmtMeas
	) {
		return findByProperty(PRMT_MEAS, prmtMeas
		);
	}
	
	public List findByPrmtMeasComp(Object prmtMeasComp
	) {
		return findByProperty(PRMT_MEAS_COMP, prmtMeasComp
		);
	}
	
	public List findByPrmtMeasValue(Object prmtMeasValue
	) {
		return findByProperty(PRMT_MEAS_VALUE, prmtMeasValue
		);
	}
	
	public List findByExpectPrmtSco(Object expectPrmtSco
	) {
		return findByProperty(EXPECT_PRMT_SCO, expectPrmtSco
		);
	}
	
	public List findByPrmtMeasNote(Object prmtMeasNote
	) {
		return findByProperty(PRMT_MEAS_NOTE, prmtMeasNote
		);
	}
	

	public List findAll() {
		log.debug("finding all PrmtMeas instances");
		try {
			String queryString = "from PrmtMeas";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PrmtMeas merge(PrmtMeas detachedInstance) {
        log.debug("merging PrmtMeas instance");
        try {
            PrmtMeas result = (PrmtMeas) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PrmtMeas instance) {
        log.debug("attaching dirty PrmtMeas instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PrmtMeas instance) {
        log.debug("attaching clean PrmtMeas instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PrmtMeasDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PrmtMeasDAO) ctx.getBean("PrmtMeasDAO");
	}
	
	public List<PrmtMeas> findByConditionAndPager(String sql, List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding PrmtMeas instance with conditon: " );
		try {
			List<PrmtMeas> result = null;
			String queryString = "from PrmtMeas as model";
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
			log.error("finding PrmtMeas instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding PrmtMeas number with conditon: " );
		try {
			String queryString = "from PrmtMeas as model ";
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
			log.error("finding PrmtMeas number with conditon name failed", re);
		}
		return 0;
	}
}