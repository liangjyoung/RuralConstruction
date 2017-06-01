package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalSystInd;
import com.rural.evalsystem.action.EvalSysAction;

/**
 	* A data access object (DAO) providing persistence and search support for EvalSystInd entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.rural.bean.EvalSystInd
  * @author MyEclipse Persistence Tools 
 */

public class EvalSystIndDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(EvalSystIndDAO.class);
		//property constants
	public static final String EXPERT_MAJOR_CATG_ID = "expertMajorCatgId";
	public static final String EVAL_SYST_ID = "evalSystId";
	public static final String EVAL_IND_NAME = "evalIndName";
	public static final String EVAL_IND_SEQ_NUM = "evalIndSeqNum";
	public static final String EVAL_IND_SCORE = "evalIndScore";
	public static final String EVAL_IND_IS_LEAF = "evalIndIsLeaf";
	public static final String EVAL_IND_NOTE = "evalIndNote";



	protected void initDao() {
		//do nothing
	}
    
    public void save(EvalSystInd transientInstance) {
        log.debug("saving EvalSystInd instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EvalSystInd persistentInstance) {
        log.debug("deleting EvalSystInd instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EvalSystInd findById( java.lang.String id) {
        log.debug("getting EvalSystInd instance with id: " + id);
        try {
            EvalSystInd instance = (EvalSystInd) getHibernateTemplate()
                    .get("com.rural.bean.EvalSystInd", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EvalSystInd instance) {
        log.debug("finding EvalSystInd instance by example");
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
      log.debug("finding EvalSystInd instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EvalSystInd as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExpertMajorCatgId(Object expertMajorCatgId
	) {
		return findByProperty(EXPERT_MAJOR_CATG_ID, expertMajorCatgId
		);
	}
	
	public List findByEvalSystId(Object evalSystId
	) {
		return findByProperty(EVAL_SYST_ID, evalSystId
		);
	}
	
	public List findByEvalIndName(Object evalIndName
	) {
		return findByProperty(EVAL_IND_NAME, evalIndName
		);
	}
	
	public List findByEvalIndSeqNum(Object evalIndSeqNum
	) {
		return findByProperty(EVAL_IND_SEQ_NUM, evalIndSeqNum
		);
	}
	
	public List findByEvalIndScore(Object evalIndScore
	) {
		return findByProperty(EVAL_IND_SCORE, evalIndScore
		);
	}
	
	public List findByEvalIndIsLeaf(Object evalIndIsLeaf
	) {
		return findByProperty(EVAL_IND_IS_LEAF, evalIndIsLeaf
		);
	}
	
	public List findByEvalIndNote(Object evalIndNote
	) {
		return findByProperty(EVAL_IND_NOTE, evalIndNote
		);
	}
	

	public List findAll() {
		log.debug("finding all EvalSystInd instances");
		try {
			String queryString = "from EvalSystInd";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EvalSystInd merge(EvalSystInd detachedInstance) {
        log.debug("merging EvalSystInd instance");
        try {
            EvalSystInd result = (EvalSystInd) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EvalSystInd instance) {
        log.debug("attaching dirty EvalSystInd instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EvalSystInd instance) {
        log.debug("attaching clean EvalSystInd instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EvalSystIndDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EvalSystIndDAO) ctx.getBean("EvalSystIndDAO");
	}
public List findFather() {
        
        try {
        	int s = EvalSysAction.getTreeS();
           String queryString = "from EvalSystInd  where UpEvalIndNum is null and EvalSystID ="+s;
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           System.out.println(re);
           throw re;
        }
  	}


   public List findChild(String value) {
       
        try {
        	int s = EvalSysAction.getTreeS();
           String queryString = "from EvalSystInd where UpEvalIndNum ='"+value+"' and EvalSystID ="+s;
  		 return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
           log.error("find by property name failed", re);
           throw re;
        }
  	}

   public List<EvalSystInd> findBySql(String sql) {
	// TODO Auto-generated method stub
	log.debug("finding EvalSystInd instance with sql: " + sql);
	try {
		String queryString = "from EvalSystInd as model where " + sql;
		return getHibernateTemplate().find(queryString);
	} catch (RuntimeException re) {
		log.error("find by sql failed", re);
		throw re;
	}
}
}