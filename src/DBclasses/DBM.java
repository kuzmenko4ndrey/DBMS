/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBclasses;

import java.io.FileNotFoundException;

/**
 *
 * @author Neophron
 */
public class DBM {
    
    private DB db;
    
    public void createNewDB(String name) {
        db = new DB(name);
    }
    
    public void loadDBFrom(String path) throws FileNotFoundException {
        db = DB.load(path);
    }
    
    public DB getDB() {
        return db;
    }
    
}
