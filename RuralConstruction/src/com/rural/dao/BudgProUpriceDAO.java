package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.BudgProUprice;
import com.rural.budgetpro.action.BudgetProAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * BudgProUprice entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.BudgProUprice
 * @author MyEclipse Persistence Tools
 */

public class BudgProUpriceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(BudgProUpriceDAO.class);
	// property constants
	public static final String BUDG_PRO_UPRICE_NUM = "budgProUpriceNum";
	public static final String BUDG_PRO_NAME = "budgProName";
	public static final String BUDG_PRO_UPRICE = "budgProUprice";
	public static final String BUDG_PRO_UPRICE_COMP = "budgProUpriceComp";
	public static final String BUDG_PRO_UPRICE_EXPL = "budgProUpriceExpl";

	protected void initDao() {
		// do nothing
	}

	public void save(BudgProUprice transientInstance) {
		log.debug("saving BudgProUprice instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BudgProUprice persistentInstance) {
		log.debug("deleting BudgProUprice instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BudgProUprice findById(java.lang.Integer id) {
		log.debug("getting BudgProUprice instance with id: " + id);
		try {
			BudgProUprice instance = (BudgProUprice) getHibernateTemplate()
					.get("com.rural.bean.BudgProUprice", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BudgProUprice instance) {
		log.debug("finding BudgProUprice instance by example");
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
		log.debug("finding BudgProUprice instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BudgProUprice as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBudgProUpriceNum(Object budgProUpriceNum) {
		return findByProperty(BUDG_PRO_UPRICE_NUM, budgProUpriceNum);
	}

	public List findByBudgProName(Object budgProName) {
		return findByProperty(BUDG_PRO_NAME, budgProName);
	}

	public List findByBudgProUprice(Object budgProUprice) {
		return findByProperty(BUDG_PRO_UPRICE, budgProUprice);
	}

	public List findByBudgProUpriceComp(Object budgProUpriceComp) {
		return findByProperty(BUDG_PRO_UPRICE_COMP, budgProUpriceComp);
	}

	public List findByBudgProUpriceExpl(Object budgProUpriceExpl) {
		return findByProperty(BUDG_PRO_UPRICE_EXPL, budgProUpriceExpl);
	}

	public List findAll() {
		log.debug("finding all BudgProUprice instances");
		try {
			String queryString = "from BudgProUprice";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BudgProUprice merge(BudgProUprice detachedInstance) {
		log.debug("merging BudgProUprice instance");
		try {
			BudgProUprice result = (BudgProUprice) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BudgProUprice instance) {
		log.debug("attaching dirty BudgProUprice instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BudgProUprice instance) {
		log.debug("attaching clean BudgProUprice instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BudgProUpriceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (BudgProUpriceDAO) ctx.getBean("BudgProUpriceDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding BudgProUprice number with conditon: " );
		try {
			String s = BudgetProAction.getJQS();
			String queryString = "from BudgProUprice as model where BudgProCatgNum ='"+s+"'";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding BudgProUprice number with conditon name failed", re);
			System.out.println(re);
			throw re;
		}
	}

	public List<BudgProUprice> findByConditionAndPager(String sql,
			List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding BudgProUprice instance with conditon: " );
		try {
			List<BudgProUprice> result = null;
			//String s = BudgetProAction.getJQS();
			//String queryString = "from BudgProUprice as model where BudgProCatgNum = '"+s+"'";
			String queryString = "from BudgProUprice as model ";
			//String orderRule = getOrderRule();
			if (sql != null) {
				//queryString += " and " + sql;
				queryString += " where " + sql;
			}
			
			Query query = this.getSession().createQuery(queryString);//+orderRule);  
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
			log.error("finding BudgProUprice instance with conditon failed", re);
			throw re;
		}
	}
	
	public int getEvalmethCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding BudgProUprice number with conditon: " );
		try {
			String queryString = "from BudgProUprice as model ";
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
			log.error("finding BudgProUprice number with conditon name failed", re);
		}
		return 0;
	}
}