/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Booking;
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
public class BookingEJB implements IBookingEJB {

    @PersistenceContext(unitName = "airlinePU")
    private EntityManager entityManager;

    /**
     * *
     * create Booking and persist in database
     *
     * @param booking
     * @return Booking
     */
    @Override
    public Booking createBooking(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    /**
     * *
     * update booking details
     *
     * @param booking
     * @return booking
     */
    @Override
    public Booking updateBooking(Booking booking) {
        entityManager.merge(booking);
        return booking;
    }

    /**
     * *
     * delete bookings from database
     *
     * @param booking
     * @return
     */
    @Override
    public Booking deleteBooking(Booking booking) {
        entityManager.remove(entityManager.merge(booking));
        return booking;
    }

    /**
     * *
     * find all bookings list
     *
     * @return list
     */
    @Override
    public List<Booking> findAllBooking() {
        TypedQuery<Booking> typedQuery = entityManager.createNamedQuery("findAllBooking", Booking.class);
        return typedQuery.getResultList();
    }

    /**
     * *
     * find booking with id
     *
     * @param id
     * @return
     */
    @Override
    public Booking findBookingWithId(Long id) {
        TypedQuery<Booking> typedQuery = entityManager.createNamedQuery("findBookingWithId", Booking.class);
        typedQuery.setParameter("bId", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<Booking> findBookingByUser(String user) {
        TypedQuery<Booking> typedQuery = entityManager.createNamedQuery("findBookingDoneByUser", Booking.class);
       typedQuery.setParameter("bCustomerId", user);
        return typedQuery.getResultList();
    }

    @Override
    public Booking findBooking(String code) {
        Booking booking=this.entityManager.find(Booking.class, code);
        return booking;
    }

}
