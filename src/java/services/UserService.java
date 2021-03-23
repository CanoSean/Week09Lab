package services;

import dataaccess.UserDB;
import java.util.List;
import models.Users;

public class UserService {
    private UserDB userDB;
    
    public UserService(){
        userDB = new UserDB();
    }
    public List<Users> getAllUsers() throws Exception{
        return userDB.getAll();
    }
    
    public Users get(String email) throws Exception {
        return userDB.get(email);
    }
    
    public int delete(String email) throws Exception{
        Users toDelete = userDB.get(email);
        
        if(toDelete.getEmail().equals("sait.cprg.352+admin@gmail.com")){
            return 0;
        }else{
            return userDB.delete(toDelete);
        }
    }
    
    
    public int update(Users user) throws Exception{
        if(user == null){
            return 0;
        }
        return userDB.update(user);
    }
    
    public int insert(Users user) throws Exception{
        if(user == null)
            return 0;
        return userDB.insert(user);
        
    }
    
    
}