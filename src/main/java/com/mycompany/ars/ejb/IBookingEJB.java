/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Booking;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface IBookingEJB {
    
    public Booking createBooking(Booking booking);

    public Booking updateBooking(Booking booking);

    public Booking deleteBooking(Booking booking);
    
    public Booking findBookingWithId(Long id);
    
    public Booking findBooking(String code);
    
    public List<Booking> findBookingByUser(String user);

    public List<Booking> findAllBooking();

    
}
