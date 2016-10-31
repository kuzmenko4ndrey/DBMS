/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_JRMP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Neophron
 */
public interface IDB extends java.rmi.Remote{

    boolean addRow(String tname, List<Object> data)throws java.rmi.RemoteException;
    
    static DB load(String path) throws FileNotFoundException, java.rmi.RemoteException{
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

    boolean addTable(String tname, TableScheme tscheme)throws java.rmi.RemoteException;

    void deleteRepeatedRows(String tname)throws java.rmi.RemoteException;

    void deleteRow(String tname, int n)throws java.rmi.RemoteException;

    void dropTable(String tname)throws java.rmi.RemoteException;

    ArrayList<String> getDiffBetwnTabls(String tname1, String tname2)throws java.rmi.RemoteException;

    ArrayList<ArrayList<Object>> getTableData(String tname)throws java.rmi.RemoteException;

    ArrayList<String> getTableNames()throws java.rmi.RemoteException;

    void save(String path) throws FileNotFoundException, IOException, java.rmi.RemoteException;

    ArrayList<String> tableToStringArray(String tname)throws java.rmi.RemoteException;
    
    int getPictureIndex(String tname)throws java.rmi.RemoteException;
    
    String getName()throws java.rmi.RemoteException;
    
}
