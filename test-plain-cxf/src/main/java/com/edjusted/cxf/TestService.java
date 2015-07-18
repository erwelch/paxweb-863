package com.edjusted.cxf;

import com.edjusted.lib.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author ewelch
 * @since 2015/07/18 10:40
 */
@WebService(targetNamespace="http://soap.test.edjusted.com/")
public interface TestService {

    @WebMethod(operationName = "processEvent")
    Response processEvent() throws Exception;

}
