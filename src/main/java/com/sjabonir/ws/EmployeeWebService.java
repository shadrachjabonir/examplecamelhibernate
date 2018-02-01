package com.sjabonir.ws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

@WebServiceClient(name = "EmployeeServices",
        wsdlLocation = "file:/IdeaProjects/example-camel-hibernate/src/main/resources/META-INF/wsdl/employee.wsdl",
        targetNamespace = "http://www.example.org/EmployeeServices/")
public class EmployeeWebService extends Service {
    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/EmployeeServices/", "EmployeeServices");
    public final static QName EmployeeServicesSOAP = new QName("http://www.example.org/EmployeeServices/", "EmployeeServicesSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/IdeaProjects/example-camel-hibernate/src/main/resources/META-INF/wsdl/employee.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EmployeeWebService.class.getName())
                    .log(java.util.logging.Level.INFO,
                            "Can not initialize the default wsdl from {0}", "file:/IdeaProjects/example-camel-hibernate/src/main/resources/META-INF/wsdl/employee.wsdl");
        }
        WSDL_LOCATION = url;
    }
    public EmployeeWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EmployeeWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EmployeeWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EmployeeWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "EmployeeServicesSOAP")
    public EmployeeService getEmployeeServicesSOAP() {
        return super.getPort(EmployeeServicesSOAP, EmployeeService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeServices
     */
    @WebEndpoint(name = "EmployeeServicesSOAP")
    public EmployeeService getEmployeeServicesSOAP(WebServiceFeature... features) {
        return super.getPort(EmployeeServicesSOAP, EmployeeService.class, features);
    }
}
