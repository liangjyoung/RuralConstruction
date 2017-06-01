package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.TownCont;
import com.rural.bean.VilCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * VilCont entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.VilCont
 * @author MyEclipse Persistence Tools
 */

public class VilContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(VilContDAO.class);
	// property constants
	public static final String VIL_CONT_NUM = "vilContNum";
	public static final String VIL_CONT_NAME = "vilContName";
	public static final String VIL_CONT_WORK_TEL = "vilContWorkTel";
	public static final String VIL_CONT_MOB_TEL = "vilContMobTel";
	public static final String VIL_CONT_COMP = "vilContComp";
	public static final String VIL_CONT_POST = "vilContPost";
	public static final String VIL_CONT_NOTE = "vilContNote";

	protected void initDao() {
		// do nothing
	}

	public void save(VilCont transientInstance) {
		log.debug("saving VilCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VilCont persistentInstance) {
		log.debug("deleting VilCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VilCont findById(java.lang.Integer id) {
		log.debug("getting VilCont instance with id: " + id);
		try {
			VilCont instance = (VilCont) getHibernateTemplate().get(
					"com.rural.bean.VilCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VilCont instance) {
		log.debug("finding VilCont instance by example");
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
		log.debug("finding VilCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VilCont as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVilContNum(Object vilContNum) {
		return findByProperty(VIL_CONT_NUM, vilContNum);
	}

	public List findByVilContName(Object vilContName) {
		return findByProperty(VIL_CONT_NAME, vilContName);
	}

	public List findByVilContWorkTel(Object vilContWorkTel) {
		return findByProperty(VIL_CONT_WORK_TEL, vilContWorkTel);
	}

	public List findByVilContMobTel(Object vilContMobTel) {
		return findByProperty(VIL_CONT_MOB_TEL, vilContMobTel);
	}

	public List findByVilContComp(Object vilContComp) {
		return findByProperty(VIL_CONT_COMP, vilContComp);
	}

	public List findByVilContPost(Object vilContPost) {
		return findByProperty(VIL_CONT_POST, vilContPost);
	}

	public List findByVilContNote(Object vilContNote) {
		return findByProperty(VIL_CONT_NOTE, vilContNote);
	}

	public List findAll() {
		log.debug("finding all VilCont instances");
		try {
			String queryString = "from VilCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VilCont merge(VilCont detachedInstance) {
		log.debug("merging VilCont instance");
		try {
			VilCont result = (VilCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VilCont instance) {
		log.debug("attaching dirty VilCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VilCont instance) {
		log.debug("attaching clean VilCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VilContDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VilContDAO) ctx.getBean("VilContDAO");
	}
	
	public List<VilCont> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding VilCont instance with conditon: " );
		try {
			List<VilCont> result = null;
			String queryString = "from VilCont as model ";
			String orderRule = "order by vilContNum";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString+orderRule);  
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
			log.error("finding TownCont instance with conditon failed", re);
			throw re;
		}
	}
	
	
	
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding VilCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VilCont as model where model."
					+ propertyName +"= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding VilCont number with conditon: " );
		try {
			String queryString = "from VilCont as model ";
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
			log.error("finding VilCont number with conditon name failed", re);
		}
		return 0;
	}
	
	public List<VilCont> findByConditionAndPager(int vilBasicInfoID, String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding VilCont instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<VilCont> result = null;
			String queryString = "from VilCont as model where vilBasicInfo.vilBasicInfoId ="+vilBasicInfoID;
			//String orderRule = getOrderRule();
			if (sql != null) {
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
	        query.list();
	  
	        result = query.list();  
	        
	       
	        return result;
		} catch (RuntimeException re) {
			log.error("finding TownCont instance with conditon failed", re);
			throw re;
		}
	}
}