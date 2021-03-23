package dataaccess;

import javax.persistence.EntityManager;
import models.Users;

public class UserDB {
    public Users get(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Users user = em.find(Users.class, email);
            return user;
        } finally {
            em.close();
        }
    }
}
