/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBclasses;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neophron
 */
public class DBTest {
    
    public DBTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddTable() {
        System.out.println("addTable");
        String tname = "tbl";
        TableScheme tscheme = new TableScheme();
        tscheme.addInt("1");
        tscheme.addDouble("2");
        tscheme.addChar("3");
        DB instance = new DB("db");
        instance.addTable(tname, tscheme);
        int expResult = 1;
        ArrayList<Object> data = new ArrayList<>();
        data.add(1);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname, data);
        data = new ArrayList<>();
        data.add(1.2);
        data.add(2.3);
        data.add("c");
        instance.addRow(tname, data);
        int result = instance.tableToStringArray(tname).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteRepeatedRows() {
        System.out.println("deleteRepeatedRows");
        String tname = "tbl";
        TableScheme tscheme = new TableScheme();
        tscheme.addInt("1");
        tscheme.addDouble("2");
        tscheme.addChar("3");
        DB instance = new DB("db");
        instance.addTable(tname, tscheme);
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<Object> data = new ArrayList<>();
        data.add(1);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname, data);
        data = new ArrayList<>();
        data.add(2);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname, data);
        data = new ArrayList<>();
        data.add(1);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname, data);
        String s = "1;2.3;c;";
        expResult.add(s);
        s = "2;2.3;c;";
        expResult.add(s);
        instance.deleteRepeatedRows(tname);
        ArrayList<String> result = instance.tableToStringArray(tname);
        Object[] e = expResult.toArray();
        Object[] r = result.toArray();
        assertArrayEquals(e, r);
    }

    @Test
    public void testGetDiffBetwnTabls() {
        System.out.println("getDiffBetwnTabls");
        String tname1 = "tbl1";
        String tname2 = "tbl2";
        TableScheme tscheme = new TableScheme();
        tscheme.addInt("1");
        tscheme.addDouble("2");
        tscheme.addChar("3");
        DB instance = new DB("db");
        instance.addTable(tname1, tscheme);
        instance.addTable(tname2, tscheme);
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<Object> data = new ArrayList<>();
        data.add(1);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname1, data);
        data = new ArrayList<>();
        data.add(2);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname1, data);
        data = new ArrayList<>();
        data.add(1);
        data.add(2.3);
        data.add('c');
        instance.addRow(tname2, data);
        String s = "2;2.3;c;";
        expResult.add(s);
        ArrayList<String> result = instance.getDiffBetwnTabls(tname1, tname2);
        Object[] e = expResult.toArray();
        Object[] r = result.toArray();
        assertArrayEquals(e, r);
    }

        
}
