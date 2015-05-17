/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.entity;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sujan
 */
public class FlightEJBTest {
    
    public FlightEJBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAllFlight method, of class FlightEJB.
     */
    @Test
    public void testFindAllFlight() throws Exception {
        System.out.println("findAllFlight");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        List<Flight> expResult = null;
        List<Flight> result = instance.findAllFlight();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFlightById method, of class FlightEJB.
     */
    @Test
    public void testFindFlightById() throws Exception {
        System.out.println("findFlightById");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        List<Flight> expResult = null;
        List<Flight> result = instance.findFlightById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFlightByTitle method, of class FlightEJB.
     */
    @Test
    public void testFindFlightByTitle() throws Exception {
        System.out.println("findFlightByTitle");
        String flightNo = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        List<Flight> expResult = null;
        List<Flight> result = instance.findFlightByTitle(flightNo);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createFlight method, of class FlightEJB.
     */
    @Test
    public void testCreateFlight() throws Exception {
        System.out.println("createFlight");
        Flight flight = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        Flight expResult = null;
        Flight result = instance.createFlight(flight);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFlight method, of class FlightEJB.
     */
    @Test
    public void testDeleteFlight() throws Exception {
        System.out.println("deleteFlight");
        Flight flight = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        Flight expResult = null;
        Flight result = instance.deleteFlight(flight);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFlight method, of class FlightEJB.
     */
    @Test
    public void testUpdateFlight() throws Exception {
        System.out.println("updateFlight");
        Flight flight = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FlightEJB instance = (FlightEJB)container.getContext().lookup("java:global/classes/FlightEJB");
        Flight expResult = null;
        Flight result = instance.updateFlight(flight);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
