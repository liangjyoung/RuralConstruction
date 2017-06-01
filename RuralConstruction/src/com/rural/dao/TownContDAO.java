package com.rural.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.TownCont;

/**
 * A data access object (DAO) providing persistence and search support for
 * TownCont entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.TownCont
 * @author MyEclipse Persistence Tools
 */

public class TownContDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TownContDAO.class);
	// property constants
	public static final String TOWN_CONT_NUM = "townContNum";
	public static final String TOWN_CONT_NAME = "townContName";
	public static final String TOWN_CONT_WORK_TEL = "townContWorkTel";
	public static final String TOWN_CONT_MOB_TEL = "townContMobTel";
	public static final String TOWN_CONT_COMP = "townContComp";
	public static final String TOWN_CONT_POST = "townContPost";
	public static final String TOWN_CONT_NOTE = "townContNote";

	protected void initDao() {
		// do nothing
	}

	public void save(TownCont transientInstance) {
		log.debug("saving TownCont instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TownCont persistentInstance) {
		log.debug("deleting TownCont instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TownCont findById(java.lang.Integer id) {
		log.debug("getting TownCont instance with id: " + id);
		try {
			TownCont instance = (TownCont) getHibernateTemplate().get(
					"com.rural.bean.TownCont", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TownCont instance) {
		log.debug("finding TownCont instance by example");
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
		log.debug("finding TownCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TownCont as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTownContNum(Object townContNum) {
		return findByProperty(TOWN_CONT_NUM, townContNum);
	}

	public List findByTownContName(Object townContName) {
		return findByProperty(TOWN_CONT_NAME, townContName);
	}

	public List findByTownContWorkTel(Object townContWorkTel) {
		return findByProperty(TOWN_CONT_WORK_TEL, townContWorkTel);
	}

	public List findByTownContMobTel(Object townContMobTel) {
		return findByProperty(TOWN_CONT_MOB_TEL, townContMobTel);
	}

	public List findByTownContComp(Object townContComp) {
		return findByProperty(TOWN_CONT_COMP, townContComp);
	}

	public List findByTownContPost(Object townContPost) {
		return findByProperty(TOWN_CONT_POST, townContPost);
	}

	public List findByTownContNote(Object townContNote) {
		return findByProperty(TOWN_CONT_NOTE, townContNote);
	}

	public List findAll() {
		log.debug("finding all TownCont instances");
		try {
			String queryString = "from TownCont";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TownCont merge(TownCont detachedInstance) {
		log.debug("merging TownCont instance");
		try {
			TownCont result = (TownCont) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TownCont instance) {
		log.debug("attaching dirty TownCont instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TownCont instance) {
		log.debug("attaching clean TownCont instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TownContDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TownContDAO) ctx.getBean("TownContDAO");
	}
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding TownCont number with conditon: " );
		try {
			String queryString = "from TownCont as model ";
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
			log.error("finding CitysCont number with conditon name failed", re);
		}
		return 0;
	}
	
	
	
	public int getCounts(int townContID, String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding VilBasicInfo number with conditon: " );
		try {
			String queryString = "from TownCont as model where TownContID ="+ townContID;
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding TownCont number with conditon name failed", re);
		}
		return 0;
	}
	
	public int getContCount(int townBasicInfoID, String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding VilBasicInfo number with conditon: " );
		try {
			String queryString = "from TownCont as model where townBasicInfoID ="+ townBasicInfoID;
			if (sql != null) {
				queryString += " and " + sql;
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
			log.error("finding TownCont number with conditon name failed", re);
		}
		return 0;
	}
	public List<TownCont> findByConditionAndPager(String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding TownCont instance with conditon: " );
		try {
			List<TownCont> result = null;
			String queryString = "from TownCont as model ";
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
			log.error("finding TownCont instance with conditon failed", re);
			throw re;
		}
	}
	public List<TownCont> findByConditionAndPager(int townBasicInfoID, String sql, List<Object> values,
			int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding TownCont instance with conditon: " );
		try {
			//System.out.println(VillageCompartmentAction.townNo);
			
			List<TownCont> result = null;
			String queryString = "from TownCont as model where TownBasicInfoID ="+townBasicInfoID;
			String orderRule = "order by townContNum";
			if (sql != null) {
				queryString += " and " + sql;
			}
			Query query = this.getSession().createQuery(queryString + orderRule);  
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
	public List findByProperty1(String propertyName, Object value) {
		log.debug("finding TownCont instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TownCont as model where model."
					+ propertyName +"= '"+value+"'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}