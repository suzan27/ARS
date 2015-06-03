/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Users;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface IUserEJB {
    
    public List<Users> findAllUsers();
    public Users findUsersByParam(String userName, String password);
    public Users findUserByUsername(String userName);
    public Users createUsers(Users users);
    public Users deleteUsers(Users users);
    public Users updateUsers(Users users);
    
}
