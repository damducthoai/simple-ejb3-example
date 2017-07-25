/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butchjgo.ejb3demo;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Stateless
@Local(EJB3DemoLocal.class)
@Remote(EJB3DemoRemote.class)
public class EJB3Demo implements EJB3DemoLocal,EJB3DemoRemote{

    @Override
    public String sayHello(String name) {
        return String.format("Hello %s!",name);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
