/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Airlines;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface IAirlinesEJB {

    public Airlines createAirline(Airlines airline);

    public Airlines updateAirline(Airlines airline);

    public Airlines deleteAirline(Airlines airline);
    
    public Airlines findAirlineWithId(String id);
    
    public Airlines findAirline(String code);
    
    public Airlines addOrUpdate(Airlines airlines );

    public List<Airlines> findAllAirline();

    public List<Airlines> findAirlineByName(String airlineName);

}
