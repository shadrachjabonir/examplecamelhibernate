package com.sjabonir.ws;


import com.sjabonir.entity.Employee;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://www.example.org/EmployeeServices/", name = "EmployeeServices")
@XmlSeeAlso({ObjectFactory.class})
public interface EmployeeService {
    @WebMethod(action = "http://www.example.org/EmployeeServices/getAccountBalance")
    @RequestWrapper(localName = "getEmployeeRequest", targetNamespace = "http://www.example.org/EmployeeServices/", className = "com.sjabonir.ws.EmployeeRequest")
    @ResponseWrapper(localName = "getEmployeeResponse", targetNamespace = "http://www.example.org/EmployeeServices/", className = "com.sjabonir.ws.EmployeeResponse")
    @WebResult(name = "accountBalance", targetNamespace = "")
    public Employee getEmployee(
            @WebParam(name = "id", targetNamespace = "")
                    int id
    );
}
