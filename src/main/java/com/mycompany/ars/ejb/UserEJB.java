/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sujan
 */
@Stateless
public class UserEJB implements IUserEJB{
    
@PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;
    private Users u;
    
    /***
     * find All Users
     * @return Users List
     */
@Override
    public List<Users> findAllUsers(){
        TypedQuery<Users> typedQuery=entityManager.createNamedQuery("findAllUser",Users.class);
        return typedQuery.getResultList();
    }

    /***
     * Find Users by Parameter
     * @param userName
     * @param password
     * @return Users List
     */
@Override
    public Users findUsersByParam(String userName, String password){
        TypedQuery<Users> typedQuery=entityManager.createNamedQuery("findUserWithParam",Users.class);
        typedQuery.setParameter("uName", userName);
        typedQuery.setParameter("uPassword", password);
        u = typedQuery.getSingleResult();
        System.out.println("Inside Manager");
        System.out.println(u.getUserName());
        System.out.println(u.getPassword());
        System.out.println("End of Manager");
        return typedQuery.getSingleResult();
    }
    
@Override
    public Users findUserByUsername(String userName){
        TypedQuery<Users> typedQuery=entityManager.createNamedQuery("findByUsername",Users.class);
        typedQuery.setParameter("uName", userName);
        return typedQuery.getSingleResult();
    }
    
    /***
     * Create users and persist into database
     * @param users
     * @return Users
     */

@Override
    public Users createUsers(Users users) {
        entityManager.persist(users);
        return users;
    }

    /***
     * remove users from database
     * @param users
     * @return Users
     */
@Override
    public Users deleteUsers(Users users) {
        entityManager.remove(entityManager.merge(users));
        return users;
    }

    /***
     * Update Users
     * @param users
     * @return Users
     */
@Override
    public Users updateUsers(Users users) {

        entityManager.merge(users);
        return users;
    }

}