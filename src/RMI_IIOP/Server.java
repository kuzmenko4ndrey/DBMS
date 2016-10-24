/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_IIOP;

import javax.naming.InitialContext;
import javax.naming.Context;

/**
 *
 * @author Neophron
 */
public class Server {
    
    public static void main(String[] args) {
        try {
            // Step 1: Instantiate the Hello servant
            DB db;
            
            if (args.length == 0) {
                db = DB.load("E:\\we");
            } else {
                db = DB.load(args[0]);
            }

            // Step 2: Publish the reference in the Naming Service 
            // using JNDI API
            Context initialNamingContext = new InitialContext();
            initialNamingContext.rebind("DBService", db);

            System.out.println("DB Server: Ready...");

         } catch (Exception e) {
            System.out.println("Trouble: " + e);
            e.printStackTrace();
         } 
     }
    
}
