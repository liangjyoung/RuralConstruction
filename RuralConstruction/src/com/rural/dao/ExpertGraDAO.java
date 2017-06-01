package com.rural.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.ExpertGra;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExpertGra entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.rural.bean.ExpertGra
 * @author MyEclipse Persistence Tools
 */

public class ExpertGraDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ExpertGraDAO.class);
	// property constants
	public static final String EVAL_CONT_ID = "evalContId";
	public static final String SCO = "sco";
	public static final String GRA_DEV = "graDev";
	public static final String GRA_REA = "graRea";
	public static final String BEL_STATE = "belState";
	public static final String EXPERT_GRA_NOTE = "expertGraNote";

	protected void initDao() {
		// do nothing
	}

	public void save(ExpertGra transientInstance) {
		log.debug("saving ExpertGra instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ExpertGra persistentInstance) {
		log.debug("deleting ExpertGra instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExpertGra findById(java.lang.Integer id) {
		log.debug("getting ExpertGra instance with id: " + id);
		try {
			ExpertGra instance = (ExpertGra) getHibernateTemplate().get(
					"com.rural.bean.ExpertGra", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExpertGra instance) {
		log.debug("finding ExpertGra instance by example");
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
		log.debug("finding ExpertGra instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ExpertGra as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEvalContId(Object evalContId) {
		return findByProperty(EVAL_CONT_ID, evalContId);
	}

	public List findBySco(Object sco) {
		return findByProperty(SCO, sco);
	}

	public List findByGraDev(Object graDev) {
		return findByProperty(GRA_DEV, graDev);
	}

	public List findByGraRea(Object graRea) {
		return findByProperty(GRA_REA, graRea);
	}

	public List findByBelState(Object belState) {
		return findByProperty(BEL_STATE, belState);
	}

	public List findByExpertGraNote(Object expertGraNote) {
		return findByProperty(EXPERT_GRA_NOTE, expertGraNote);
	}

	public List findAll() {
		log.debug("finding all ExpertGra instances");
		try {
			String queryString = "from ExpertGra";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ExpertGra merge(ExpertGra detachedInstance) {
		log.debug("merging ExpertGra instance");
		try {
			ExpertGra result = (ExpertGra) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ExpertGra instance) {
		log.debug("attaching dirty ExpertGra instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExpertGra instance) {
		log.debug("attaching clean ExpertGra instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpertGraDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExpertGraDAO) ctx.getBean("ExpertGraDAO");
	}
	public List<ExpertGra> findByConditionAndPager(String sql, List<Object> values, int from, int length) {
		// TODO Auto-generated method stub
		log.debug("finding ExpertGra instance with conditon: " );
		try {
			List<ExpertGra> result = null;
			String queryString = "from ExpertGra as model ";
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
			log.error("finding ExpertGra instance with conditon failed", re);
			throw re;
		}
	}
	
	
	public int getCounts(String sql, List<Object> values) {
		// TODO Auto-generated method stub
		log.debug("finding ExpertGra number with conditon: " );
		try {
			String queryString = "from ExpertGra as model ";
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
			log.error("finding ExpertGra number with conditon name failed", re);
		}
		return 0;
	}

	public List findBySql(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding ExpertGra instance with sql: " + sql);
		try {
			String queryString = "from ExpertGra as model where " + sql;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by sql failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("deprecation")
	public Map<Integer, String> findByProtoSql(String sql)throws Exception{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn = session.connection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			Map<Integer, String> records = new HashMap<Integer, String>();
			while(rs.next())
			{
				records.put(rs.getInt("EvalContID"), rs.getString("AvgSco"));
			}
			return records;
		} finally {
			// TODO Auto-generated catch block
			if(rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}
	}
	
	public void updateByProtoSql(String sql)throws Exception{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn = session.connection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try {
			pstmt.executeUpdate();
		} finally {
			// TODO Auto-generated catch block
			if(pstmt != null)
				pstmt.close();
			if(conn != null && !conn.isClosed())
				conn.close();
		}
	}
}