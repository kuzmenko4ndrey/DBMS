/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_IIOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.PortableRemoteObject;

/**
 *
 * @author Neophron
 */
public class DB extends PortableRemoteObject implements IDB {

    private final String name;
    private final ArrayList<Table> tables = new ArrayList<>();

    public DB(String bdname) throws java.rmi.RemoteException{
        name = bdname;
    }

    @Override
    public boolean addTable(String tname, TableScheme tscheme) throws RemoteException {
        Table t = tscheme.createTable(tname);
        if (t != null) {
            tables.add(t);
            return true;
        }
        return false;
    }

    @Override
    public void dropTable(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                tables.remove(t);
                break;
            }
        }
    }

    @Override
    public boolean addRow(String tname, List<Object> data) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.addRow(data);
            }
        }
        return false;
    }

    @Override
    public void deleteRow(String tname, int n) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                t.deleteRow(n);
            }
        }
    }

    @Override
    public void deleteRepeatedRows(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                t.deleteRepeatedRows();
            }
        }
    }

    @Override
    public ArrayList<String> tableToStringArray(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.toStringArray();
            }
        }
        return null;
    }

    @Override
    public ArrayList<String> getDiffBetwnTabls(String tname1, String tname2) throws RemoteException {
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

    @Override
    public void save(String path) throws FileNotFoundException, IOException {
        if (path.charAt(path.length() - 1) != '\\' || path.charAt(path.length() - 1) != '/') {
            path += '\\';
        }
        path += name + '\\';
        File f;
        f = new File(path + "tables");
        f.getParentFile().mkdir();
        f.createNewFile();
        PrintWriter tf = null;
        try {
            tf = new PrintWriter(path + "tables", "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < this.tables.size(); i++) {
            tf.println(tables.get(i).getName());
        }
        tf.close();
        for (Table t : tables) {
            PrintWriter tt = null;
            f = new File(path + t.getName());
            f.createNewFile();
            try {
                tt = new PrintWriter(path + t.getName(), "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (String s : t.toStringArray()) {
                tt.println(s);
            }
            tt.close();
        }
        for (Table t : tables) {
            PrintWriter tt = null;
            f = new File(path + t.getName() + "s");
            f.createNewFile();
            try {
                tt = new PrintWriter(path + t.getName() + "s", "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (String s : t.getStrScheme()) {
                tt.println(s);
            }
            tt.close();
        }
    }

    public static DB load(String path) throws FileNotFoundException, java.rmi.RemoteException{
        File folder = new File(path);
        if (!folder.isDirectory()) {
            throw new FileNotFoundException();
        }
        if (path.charAt(path.length() - 1) != '\\' || path.charAt(path.length() - 1) != '/') {
            path += '\\';
        }
        DB db = new DB(folder.getName());
        File f = new File(path + "tables");
        Scanner tbls = new Scanner(f);
        while (tbls.hasNext()) {
            String t = tbls.nextLine();
            TableScheme ts = new TableScheme();
            f = new File(path + t + "s");
            Scanner tss = new Scanner(f);
            while (tss.hasNext()) {
                String se = tss.nextLine();
                String[] sh = se.split(";");
                ts.add(sh[0], sh[1]);
            }
            db.addTable(t, ts);
            f = new File(path + t);
            Scanner tsc = new Scanner(f);
            while (tsc.hasNext()) {
                String se = tsc.nextLine();
                String[] sh = se.split(";");
                ArrayList<Object> als = new ArrayList<>();
                for (String c : sh) {
                    als.add(c);
                }
                db.addRow(t, als);
            }
        }
        return db;
    }

    @Override
    public ArrayList<ArrayList<Object>> getTableData(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.getData();
            }
        }
        return null;
    }

    @Override
    public ArrayList<String> getTableNames() {
        ArrayList<String> als = new ArrayList<>();
        for (Table t : tables) {
            als.add(t.getName());
        }
        return als;
    }
    
    @Override
    public int getPictureIndex(String tname) {
        for (Table t : tables) {
            if (t.getName().equals(tname)) {
                return t.getPictureIndex();
            }
        }
        return -1;
    }
    
}
