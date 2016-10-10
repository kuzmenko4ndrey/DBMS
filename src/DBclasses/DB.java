/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neophron
 */
public class DB {
    
    private final String name;
    private final ArrayList<Table> tables = new ArrayList<>();
    
    public DB(String bdname) {
        name = bdname;
    }
    
    public boolean addTable(String tname, TableScheme tscheme) {
        Table t = tscheme.createTable(tname);
        if (t != null) {
            tables.add(t);
            return true;
        }
        return false;
    }
    
    public void dropTable(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                tables.remove(t);
                break;
            }
        }
    }
    
    public boolean addRow(String tname, List<Object> data) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.addRow(data);
            }
        }
        return false;
    }
    
    public void deleteRow(String tname, int n) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                t.deleteRow(n);
            }
        }
    }
    
    public void deleteRepeatedRows(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                t.deleteRepeatedRows();
            }
        }
    }
    
    public ArrayList<String> tableToStringArray(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.toStringArray();
            }
        }
        return null;
    }
    
    public ArrayList<String> getDiffBetwnTabls(String tname1, String tname2) {
        Table t1 = null, t2 = null;
        for (Table t : tables) {
            if (t.getName().equals(tname1)) {
                t1 = t;
            }
        }
        for (Table t : tables) {
            if (t.getName().equals(tname2)) {
                t2 = t;
            }
        }
        if (t1 == null) {
            return null;
        }
        return t1.getDiffBetwnTabls(t2);
    }
    
    public void save(String path) {
        //todo
    }
    
    public static DB load(String path) {
        //todo
        return new DB("null");
    }
    
}
