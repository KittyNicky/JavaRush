package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    SecurityChecker securityChecker = new SecurityCheckerImpl();
    SimpleConnector simpleConnector;

    public SecurityProxyConnector(String simpleConnector) {
        this.simpleConnector = new SimpleConnector(simpleConnector);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck()) simpleConnector.connect();
        else System.out.println("Unsuccessfully connected");
    }
}
