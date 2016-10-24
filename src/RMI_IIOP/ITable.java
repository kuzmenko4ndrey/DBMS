/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_IIOP;

import java.util.ArrayList;

/**
 *
 * @author Neophron
 */
public interface ITable extends java.rmi.Remote {

    ArrayList<String> getColNames()throws java.rmi.RemoteException;

    ArrayList<ArrayList<Object>> getData()throws java.rmi.RemoteException;

    String getName()throws java.rmi.RemoteException;

    int getPictureIndex()throws java.rmi.RemoteException;

    ArrayList<String> getStrScheme()throws java.rmi.RemoteException;

    ArrayList<String> toStringArray()throws java.rmi.RemoteException;
    
}
