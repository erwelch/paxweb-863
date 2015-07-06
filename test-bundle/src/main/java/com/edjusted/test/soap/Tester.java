package com.edjusted.test.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author ewelch
 * @since 2015/07/06 16:18
 */
@WebService
public interface Tester {

    @WebMethod(operationName = "processEvent")
    Response processEvent() throws Exception;

}
