package com.rural.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.EvalContInvesObj;
import com.rural.bean.EvalContSubSco;
import com.rural.bean.LevelsIndSco;

/**
 * A data access object (DAO) providing persistence and search support for
 * EvalContSubSco entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.EvalContSubSco
 * @author MyEclipse Persistence Tools
 */

public class EvalContSubScoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EvalContSubScoDAO.class);
	// property constants
	public static final String AUTO_EVAL_SCO = "autoEvalSco";
	public static final String EXPERT_EVAL_CONT_TOT_GRA = "expertEvalContTotGra";
	public static final String VIL_EVAL_CONT_TOT_GRA = "vilEvalContTotGra";
	public static final String EVAL_METH = "evalMeth";

	protected void initDao() {
		// do nothing
	}

	public void save(EvalContSubSco transientInstance) {
		log.debug("saving EvalContSubSco instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EvalContSubSco persistentInstance) {
		log.debug("deleting EvalContSubSco instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EvalContSubSco findById(java.lang.Integer id) {
		log.debug("getting EvalContSubSco instance with id: " + id);
		try {
			EvalContSubSco instance = (EvalContSubSco) getHibernateTemplate()
					.get("com.rural.bean.EvalContSubSco", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EvalContSubSco instance) {
		log.debug("finding EvalContSubSco instance by example");
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
		log.debug("finding EvalContSubSco instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EvalContSubSco as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAutoEvalSco(Object autoEvalSco) {
		return findByProperty(AUTO_EVAL_SCO, autoEvalSco);
	}

	public List findByExpertEvalContTotGra(Object expertEvalContTotGra) {
		return findByProperty(EXPERT_EVAL_CONT_TOT_GRA, expertEvalContTotGra);
	}

	public List findByVilEvalContTotGra(Object vilEvalContTotGra) {
		return findByProperty(VIL_EVAL_CONT_TOT_GRA, vilEvalContTotGra);
	}

	public List findByEvalMeth(Object evalMeth) {
		return findByProperty(EVAL_METH, evalMeth);
	}

	public List findAll() {
		log.debug("finding all EvalContSubSco instances");
		try {
			String queryString = "from EvalContSubSco";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EvalContSubSco merge(EvalContSubSco detachedInstance) {
		log.debug("merging EvalContSubSco instance");
		try {
			EvalContSubSco result = (EvalContSubSco) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EvalContSubSco instance) {
		log.debug("attaching dirty EvalContSubSco instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EvalContSubSco instance) {
		log.debug("attaching clean EvalContSubSco instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EvalContSubScoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EvalContSubScoDAO) ctx.getBean("EvalContSubScoDAO");
	}
	
	public List findByContScore(int  vilscore, int evalcontid) {
		log.debug("finding EvalContSubSco instance with property: ");
		try {
			String queryString = "from EvalContSubSco as model where vilEvalScoId = "+vilscore+" and evalContId = "+evalcontid;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco instance with sql: " + sql);
		try {
			String queryString = "from EvalContSubSco as model where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco number with conditon: " );
		try {
			String queryString = "from EvalContSubSco as model ";
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
			log.error("finding EvalContSubSco number with conditon name failed", re);
		}
		return 0;
	}
	
	public List<EvalContSubSco> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<EvalContSubSco> result = null;
			String queryString = "from EvalContSubSco as model";
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
	        query.list();
	        result = query.list(); 
	        return result;
		} catch (RuntimeException re) {
			log.error("finding EvalContSubSco instance with conditon failed", re);
			throw re;
		}
	}
	
	public List<EvalContSubSco> findBytwopageandcon(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<EvalContSubSco> result = null;
			String queryString = "select eval from EvalContSubSco eval, EvalCont cont";
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
	        query.list();
	        result = query.list(); 
	        return result;
		} catch (RuntimeException re) {
			log.error("finding EvalContSubSco instance with conditon failed", re);
			System.out.println("------------->"+re);
			throw re;
		}
	}
	
	public List<EvalContSubSco> findByConditionAndPager(int vilEvalScoID,String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco instance with conditon: " );
		try {
			List<EvalContSubSco> result = null;
			//String queryString = "from EvalContSubSco as model ";
			//String orderRule = getOrderRule();
			String queryString = "from EvalContSubSco as model where vilEvalScoId ="+vilEvalScoID;
			//String orderRule ="order by citysContNum";
			if (sql != null) {
				//queryString += " where " + sql;
				queryString += " and " + sql;
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
			log.error("finding EvalContSubSco instance with conditon failed", re);
			throw re;
		}
	}
	
	public EvalContSubSco findByVilAndEval(int VilEvalID, int EvlScoreID) {
		log.debug("finding EvalContSubSco instance with property: ");
		try {
			String queryString = "from EvalContSubSco as model where vilEvalSco.vilEvalScoId = "+VilEvalID+"and evalScoId = "+EvlScoreID;
			 Query query=this.getSession().createQuery(queryString);
	            System.out.println(query.list());
			return (EvalContSubSco)query.list().get(0);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int getCountssss(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding EvalContSubSco number with conditon: " );
		try {
			String queryString = "select eval from EvalContSubSco eval, EvalCont cont";
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
			log.error("finding EvalContSubSco number with conditon name failed", re);
		}
		return 0;
	}
	
	
	
	public List<EvalContSubSco> findEvalContSubSco(int evalContId, int VilEvalScoId) {
		
		EvalContSubSco evalContSubSco = new  EvalContSubSco();
			
			
			try {
				String queryString = "from EvalContSubSco as model where evalCont.evalContId ="+evalContId+" and vilEvalSco.vilEvalScoId ="+VilEvalScoId;
				Query query = this.getSession().createQuery(queryString);  
		        return query.list(); 
			} catch (RuntimeException re) {
				log.error("find by property name failed", re);
				throw re;
			}
		}
}