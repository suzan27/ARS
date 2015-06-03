/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Cancellation;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface ICancellationEJB {
    
     public Cancellation createCancellation(Cancellation cancellation);

    public Cancellation updateCancellation(Cancellation cancellation);

    public Cancellation deleteCancellation(Cancellation cancellation);
    
    public Cancellation findCancellationWithId(Long id);

    public List<Cancellation> findAllCancellation();
    
}
