/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_JRMP;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
            IDB db;
            
            if (args.length == 0) {
                db = IDB.load("E:\\we");
                System.out.println("loaded we");
            } else {
                db = IDB.load(args[0]);
                System.out.println("loaded " + args[0]);
            }

            // Step 2: Publish the reference in the Naming Service 
            // using JNDI API
            Registry r = LocateRegistry.createRegistry(6117);
            Naming.rebind("rmi://127.0.0.1:6117/DBService", db);

            System.out.println("DB Server: Ready...");

         } catch (Exception e) {
            System.out.println("Trouble: " + e);
            e.printStackTrace();
         } 
     }
    
}
