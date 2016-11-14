/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOAP_Server;


import javax.xml.ws.Endpoint;

/**
 *
 * @author Neophron
 */
public class ServicePublisher {
    
    
    public static void main(String... args) {
        // запускаем веб-сервер на порту 1986
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:6112/wss/DBM", new DBM());
    }
}
