/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ars.ejb;

import com.mycompany.ars.entity.Payment;
import java.util.List;

/**
 *
 * @author Sujan
 */
public interface IPaymentEJB {
    
     public Payment createPayment(Payment payment);

    public Payment updatePayment(Payment payment);

    public Payment deletePayment(Payment payment);
    
    public Payment findPaymentWithId(Long id);

    public List<Payment> findAllPayment();
    
}
