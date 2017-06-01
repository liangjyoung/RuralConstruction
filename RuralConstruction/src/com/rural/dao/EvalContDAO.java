package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalCont entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.EvalCont
 * @author MyEclipse Persistence Tools
 */

public class EvalContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalContDAO.class);
	// property constants
	public static final String EVAL_CONT_NUM = "evalContNum";
	public static final String EVAL_CONT_DES = "evalContDes";
	public static final String EVAL_CONT_SCORE = "evalContScore";
	public static final String BUL_REQ = "bulReq";
	public static final String EVAL_CONT_SCOR_METH = "evalContScorMeth";
	public static final String SUBJ_OBJEC_VALU = "subjObjecValu";
	public static final String EVAL_CONT_SEQ_NUM = "evalContSeqNum";
	public static final String EVAL_CONT_NOTE = "evalContNote";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalCont transientInstance) {
		log.debug("saving EvalCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalCont persistentInstance) {
		log.debug("deleting EvalCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalCont findById(java.lang.Integer id) {
		log.debug("getting EvalCont instance with id: " + id);
		try {
			EvalCont instance = (EvalCont) getHibernateTemplate().get(
					"com.rural.bean.EvalCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalCont instance) {
		log.debug("finding EvalCont instance by example");
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
		log.debug("finding EvalCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EvalCont as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEvalContNum(Object evalContNum) {
		return findByProperty(EVAL_CONT_NUM, evalContNum);
	}

	public List findByEvalContDes(Object evalContDes) {
		return findByProperty(EVAL_CONT_DES, evalContDes);
	}

	public List findByEvalContScore(Object evalContScore) {
		return findByProperty(EVAL_CONT_SCORE, evalContScore);
	}

	public List findByBulReq(Object bulReq) {
		return findByProperty(BUL_REQ, bulReq);
	}

	public List findByEvalContScorMeth(Object evalContScorMeth) {
		return findByProperty(EVAL_CONT_SCOR_METH, evalContScorMeth);
	}

	public List findBySubjObjecValu(Object subjObjecValu) {
		return findByProperty(SUBJ_OBJEC_VALU, subjObjecValu);
	}

	public List findByEvalContSeqNum(Object evalContSeqNum) {
		return findByProperty(EVAL_CONT_SEQ_NUM, evalContSeqNum);
	}

	public List findByEvalContNote(Object evalContNote) {
		return findByProperty(EVAL_CONT_NOTE, evalContNote);
	}

	public List findAll() {
		log.debug("finding all EvalCont instances");
		try {
			String queryString = "from EvalCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalCont merge(EvalCont detachedInstance) {
		log.debug("merging EvalCont instance");
		try {
			EvalCont result = (EvalCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalCont instance) {
		log.debug("attaching dirty EvalCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalCont instance) {
		log.debug("attaching clean EvalCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalContDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EvalContDAO) ctx.getBean("EvalContDAO");
	}
	
	public List<EvalCont> findByConditionAndPager(String sql, List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalCont instance with conditon: " );
		try {
			List<EvalCont> result = null;
			String queryString = "from EvalCont as model ";
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
			log.error("finding EvalCont instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getEvalmethCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalCont number with conditon: " );
		try {
			String queryString = "from EvalCont as model ";
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
			log.error("finding EvalCont number with conditon name failed", re);
		}
		return 0;
	}
	
	
	public List findBycondition(String propertyName) {
		log.debug("finding EvalCont instance with property: ");
		try {
			String queryString = " from EvalCont where EvalContNum like '"+propertyName+".%'";
					
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}