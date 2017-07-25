/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butchjgo.ejb3democlient;

import com.butchjgo.ejb3demo.EJB3DemoRemote;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public class App {
    private EJB3DemoRemote demoRemote;
    final Hashtable jndiProps = new Hashtable();
    public EJB3DemoRemote getRemoteService() throws NamingException{
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(jndiProps);
        String name = "ejb:/EJB3Demo-1//EJB3Demo!com.butchjgo.ejb3demo.EJB3DemoRemote";
        return (EJB3DemoRemote) context.lookup(name);
    }
    public static void main(String[] args) {
        App demoEJB = new App();
        try{
            EJB3DemoRemote remoteService = demoEJB.getRemoteService();
            System.out.println(remoteService.sayHello("butchjgo.com"));
        } catch(NamingException e){
            e.printStackTrace();
        }
    }
}
