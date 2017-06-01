package com.rural.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rural.bean.InvesObjData;
import com.rural.villageColldData.action.ColldDataDUIXIANGAction;

/**
 * A data access object (DAO) providing persistence and search support for
 * InvesObjData entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.rural.bean.InvesObjData
 * @author MyEclipse Persistence Tools
 */

public class InvesObjDataDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InvesObjDataDAO.class);
	// property constants
	public static final String INVES_OBJ_DATA_VALU = "invesObjDataValu";
	public static final String INVES_OBJ_NOTE = "invesObjNote";

	protected void initDao() {
		// do nothing
	}

	public void save(InvesObjData transientInstance) {
		log.debug("saving InvesObjData instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(InvesObjData persistentInstance) {
		log.debug("deleting InvesObjData instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvesObjData findById(java.lang.Integer id) {
		log.debug("getting InvesObjData instance with id: " + id);
		try {
			InvesObjData instance = (InvesObjData) getHibernateTemplate().get(
					"com.rural.bean.InvesObjData", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(InvesObjData instance) {
		log.debug("finding InvesObjData instance by example");
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
		log.debug("finding InvesObjData instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from InvesObjData as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInvesObjDataValu(Object invesObjDataValu) {
		return findByProperty(INVES_OBJ_DATA_VALU, invesObjDataValu);
	}

	public List findByInvesObjNote(Object invesObjNote) {
		return findByProperty(INVES_OBJ_NOTE, invesObjNote);
	}

	public List findAll() {
		log.debug("finding all InvesObjData instances");
		try {
			String queryString = "from InvesObjData";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public InvesObjData merge(InvesObjData detachedInstance) {
		log.debug("merging InvesObjData instance");
		try {
			InvesObjData result = (InvesObjData) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(InvesObjData instance) {
		log.debug("attaching dirty InvesObjData instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvesObjData instance) {
		log.debug("attaching clean InvesObjData instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InvesObjDataDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InvesObjDataDAO) ctx.getBean("InvesObjDataDAO");
	}
	
	
	public List findByDataCollDicEntryId(int DataCollDicEntryId){
		log.debug("finding InvesObjData list with DataCollDicEntryID: " );
		try {
			//List<Invgat> result = null;
			//String s = InvgatDworkAction.getJQI();
			//String queryString = "from Invgat as model where InvgatNum = '"+s+"'";
			String queryString = "from InvesObjData as model where DataCollDicEntryID ="+DataCollDicEntryId;
			Query query = this.getSession().createQuery(queryString);  
	        return query.list(); 
		} catch (RuntimeException re) {
			log.error("finding InvesObjData instance with conditon failed", re);
			throw re;
		}
	}
	public List findByVilDataCollRecId1(int VilDataCollRecId){
		log.debug("finding InvesObjData instance with property: ");
		try {
			String queryString = "from InvesObjData as model where vilDataCollRec.vilDataCollRecId = "+VilDataCollRecId;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public int getCounts(String sql) {
		// TODO Auto-generated method stub
		log.debug("finding InvesObjData number with conditon: " );
		try {
			String queryString = "from InvesObjData as model";
			if (sql != null) {
				queryString += " where " + sql;
			}
			Query query = this.getSession().createQuery(queryString);  
			int rows = query.list().size();  
	        return rows;
		} catch (RuntimeException re) {
			log.error("finding BudgProUprice number with conditon name failed", re);
			System.out.println(re);
			throw re;
		}
	}
	public int getCounts(String sql , List<Object> values){
		log.debug("finding InvesObjData number with conditon: " );
		try {
			
			//String s1=ColldDataDUIXIANGAction.getJQS1();
			/*String queryString = "select model  from InvesObjData as model ,InvesObj as model where InvesObjData.model.invesObjID =InvesObj.model.invesObjID";
			if(s!=null){
				queryString += "and  InvesProNum like '%"+s+"%'";
			}*/
			String queryString = "from InvesObjData where 1=1 ";
			if (sql != null) {
				queryString += " and " + sql;
			}
			/*if(s1!=null){
				queryString +=" and VilDataCollRecId ='"+s1+"'";
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
			log.error("finding VilDataCollRec number with conditon name failed", re);
			throw re;
		}
	}
	
	
	
	
	public List<InvesObjData> findByConditionAndPager(String sql , List<Object> values, int from ,int length){
		log.debug("finding InvesObjData instance with conditon: " );
	
		try {
			List<InvesObjData> result = null;
			//String s1=ColldDataDUIXIANGAction.getJQS1();
			/*String queryString = "select model  from InvesObjData as a ,InvesObj as b where a.model.invesObjID =b.model.invesObjID";
			if(s!=null){
				queryString += "and  InvesProNum like '%"+s+"%'";
			}*/
			String queryString = "from InvesObjData where 1=1 ";
			if (sql != null) {
				queryString += " and " + sql;
			}
			/*if(s1!=null){
				queryString +=" and VilDataCollRecId ='"+s1+"'";
			}*/
			Query query = this.getSession().createQuery(queryString+" order by invesObjId");  
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
			log.error("finding InvesObjData instance with conditon failed", re);
			throw re;
		}
	}
	
	
	
	public List findInvIDAndRecD(int  RecID, int invojid) {
		log.debug("finding InvesObjData instance with property: ");
		try {
			String queryString = "from InvesObjData as model where vilDataCollRec.vilDataCollRecId = "+RecID+" and invesObj.invesObjId = "+invojid;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findInvIDAndRecD1(int VilDataCollRecId,int  InvesObjId ) {
		log.debug("finding InvesObjData instance with property: ");
		try {
			String queryString = "from InvesObjData as model where vilDataCollRec.vilDataCollRecId = "+VilDataCollRecId+" and invesObj.invesObjId = "+InvesObjId;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//带返回值的存储过程
	public String saveScoreAuto(String sss) throws SQLException{
		
		String message;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Connection conn=session.connection();
		CallableStatement proc = conn.prepareCall("{call proc_EvalContSubScoByVilEvalScoIDOut(?,?)}");
		//注意：这里是传入输入参数
		proc.setString(1,sss); 
		//注意：这里是注册输出参数
		proc.registerOutParameter(2,java.sql.Types.NVARCHAR);
		//执行存储过程
		proc.execute();
		//获取执行完的存储过程的返回值
		message =proc.getString(2);
		proc.close();
		conn.close();
		session.close();
		sf.close();
		return message;
	}
	public void delete1(InvesObjData persistentInstance) {//通过调查对象编号和村庄采集记录删除记录
		log.debug("deleting InvesObjData instance");
		try {
			
			getSession().createQuery("delete from InvesObjData where vilDataCollRec.vilDataCollRecId=" + 
			persistentInstance.getVilDataCollRec().getVilDataCollRecId() +" and invesObj.invesObjId =" 
			+ persistentInstance.getInvesObj().getInvesObjId()).executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	
}