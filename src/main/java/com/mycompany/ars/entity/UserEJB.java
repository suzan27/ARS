/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

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
public class UserEJB {
    
@PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;
    
    /***
     * find All Users
     * @return Users List
     */
    public List<Users> findAllUsers(){
        TypedQuery<Users> typedQuery=entityManager.createNamedQuery("findAllUser",Users.class);
        return typedQuery.getResultList();
    }

    /***
     * Find Users by id
     * @param id
     * @return Users List
     */
    public Users findUsersById(String userName, String password){
        TypedQuery<Users> typedQuery=entityManager.createNamedQuery("findUserWithId",Users.class);
        typedQuery.setParameter("uName", userName);
        typedQuery.setParameter("uPassword", password);
        return typedQuery.getSingleResult();
    }
    /***
     * Create game and persist into database
     * @param users
     * @return Users
     */

    public Users createUsers(Users users) {
        entityManager.persist(users);
        return users;
    }

    /***
     * remove game from database
     * @param users
     * @return Users
     */
    public Users deleteUsers(Users users) {
        entityManager.remove(entityManager.merge(users));
        return users;
    }

    /***
     * Update Users
     * @param users
     * @return Users
     */
    public Users updateUsers(Users users) {

        entityManager.merge(users);
        return users;
    }

}