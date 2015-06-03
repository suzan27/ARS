/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Flight;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface IFlightEJB {
   
    public Flight addOrUpdateFlight(Flight flight);
    
    public Flight deleteFlight(Flight flight);

    public List<Flight> findAllFlight();
    
    public List<Flight> findFlightById(Long id);
    
    public Flight findFlight(String code);

    public List<Flight> findFlightByParam(String param);
}
