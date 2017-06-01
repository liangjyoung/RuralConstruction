package com.rural.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.Expert;
import com.rural.expert.action.ExpertAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expert entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.Expert
 * @author MyEclipse Persistence Tools
 */

public class ExpertDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ExpertDAO.class);
	// property constants
	public static final String EXPERT_NUM = "expertNum";
	public static final String EXPERT_NAME = "expertName";
	public static final String EXPERT_TITLE = "expertTitle";
	public static final String EXPERT_POST = "expertPost";
	public static final String EXPERT_WORK_TEL = "expertWorkTel";
	public static final String EXPERT_MOB_TEL = "expertMobTel";
	public static final String EXPERT_COMP = "expertComp";
	public static final String EXPERT_GRA_RELI = "expertGraReli";
	public static final String EXPERT_EMAIL = "expertEmail";
	public static final String EXPERT_WX = "expertWx";
	public static final String EXPERT_ADDRESS = "expertAddress";
	public static final String EXPERT_BANK = "expertBank";
	public static final String EXPERT_ACCOUNT = "expertAccount";

	protected void initDao() {
		// do nothing
	}

	public void save(Expert transientInstance) {
		log.debug("saving Expert instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expert persistentInstance) {
		log.debug("deleting Expert instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Expert findById(java.lang.Integer id) {
		log.debug("getting Expert instance with id: " + id);
		try {
			Expert instance = (Expert) getHibernateTemplate().get(
					"com.rural.bean.Expert", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Expert instance) {
		log.debug("finding Expert instance by example");
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
		log.debug("finding Expert instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expert as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByExpertNum(Object expertNum) {
		return findByProperty(EXPERT_NUM, expertNum);
	}

	public List findByExpertName(Object expertName) {
		return findByProperty(EXPERT_NAME, expertName);
	}

	public List findByExpertTitle(Object expertTitle) {
		return findByProperty(EXPERT_TITLE, expertTitle);
	}

	public List findByExpertPost(Object expertPost) {
		return findByProperty(EXPERT_POST, expertPost);
	}

	public List findByExpertWorkTel(Object expertWorkTel) {
		return findByProperty(EXPERT_WORK_TEL, expertWorkTel);
	}

	public List findByExpertMobTel(Object expertMobTel) {
		return findByProperty(EXPERT_MOB_TEL, expertMobTel);
	}

	public List findByExpertComp(Object expertComp) {
		return findByProperty(EXPERT_COMP, expertComp);
	}

	public List findByExpertGraReli(Object expertGraReli) {
		return findByProperty(EXPERT_GRA_RELI, expertGraReli);
	}

	public List findByExpertEmail(Object expertEmail) {
		return findByProperty(EXPERT_EMAIL, expertEmail);
	}

	public List findByExpertWx(Object expertWx) {
		return findByProperty(EXPERT_WX, expertWx);
	}

	public List findByExpertAddress(Object expertAddress) {
		return findByProperty(EXPERT_ADDRESS, expertAddress);
	}

	public List findByExpertBank(Object expertBank) {
		return findByProperty(EXPERT_BANK, expertBank);
	}

	public List findByExpertAccount(Object expertAccount) {
		return findByProperty(EXPERT_ACCOUNT, expertAccount);
	}

	public List findAll() {
		log.debug("finding all Expert instances");
		try {
			String queryString = "from Expert";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expert merge(Expert detachedInstance) {
		log.debug("merging Expert instance");
		try {
			Expert result = (Expert) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expert instance) {
		log.debug("attaching dirty Expert instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expert instance) {
		log.debug("attaching clean Expert instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpertDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExpertDAO) ctx.getBean("ExpertDAO");
	}
	
	
	public List<Expert> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding Expert instance with conditon: " );
		try {
			List<Expert> result = null;
			String s = ExpertAction.getJQS();
			//String s1=ExpertAction1.getJQS1();
			String queryString = "from Expert where 1=1";
			
			if(s !=null){
				queryString +="and ExpertMajorCatgID like '%"+s+"%'";
				
			}
//				queryString +="and CityBasicInfoID like '%"+cityBasicInfoId+"%'";
			//String orderRule = getOrderRule();
			/*if (sql != null) {
				queryString += " and " + sql;
			}*/
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
			log.error("finding Expert instance with conditon failed", re);
			throw re;
		}
	}
	
	public int getCounts(String sql , List<Object> values){
		log.debug("finding Expert number with conditon: " );
		try {
			String s = ExpertAction.getJQS();
			//String s1=ExpertAction1.getJQS1();
			String queryString = "from Expert where 1=1";
			
			if(s !=null){
				queryString +="and ExpertMajorCatgID like '%"+s+"%'";
				
			}
//				queryString +="and CityBasicInfoID like '%"+cityBasicInfoId+"%'";
			/*if (sql != null) {
				queryString += " and " + sql;
			}*/
			Query query = this.getSession().createQuery(queryString);  
			if (values != null) {
				 for (int i = 0; i < values.size(); i++) {
						query.setParameter(i, values.get(i));
					}
			}
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding Expert number with conditon name failed", re);
			throw re;
		}
	}
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding Expert instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expert as model where model."
				+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}