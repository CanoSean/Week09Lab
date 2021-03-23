package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Users;


public class UserDB {
    public Users get(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            Users user = em.find(Users.class, email);
            return user;
        }finally{
            em.close();
        }
    }
    
    
        public List<Users> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
          TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
          List<Users> results = query.getResultList();
            em.close();
            return results;
    }


    public int insert(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);//equivalent to an insert statement
            trans.commit();//commit the changes 
        } catch(Exception e){
            trans.rollback();
        }finally {
            em.close();
            return 1;
        }
    }

    public int update(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);//equivalent to an update statement 
            trans.commit();//commit the changes 
        } catch(Exception e){
            trans.rollback();
        }finally {
            em.close();
            return 1;
        }
    }

    public int delete(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(user));//equivalent to a delete statement 
            trans.commit();//commit the changes 
        } catch(Exception e){
            trans.rollback();
        }finally {
            em.close();
            return 1;
        }
    }
}