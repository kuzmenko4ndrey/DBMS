/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_IIOP;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neophron
 */
public interface IDB extends java.rmi.Remote{

    boolean addRow(String tname, List<Object> data)throws java.rmi.RemoteException;

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
    
}
