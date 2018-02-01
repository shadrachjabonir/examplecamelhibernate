package com.sjabonir.ws;

import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public EmployeeRequest createEmployeeRequest() {
        return new EmployeeRequest();
    }
    public EmployeeResponse createEmployeeResponse() {
        return new EmployeeResponse();
    }
}
