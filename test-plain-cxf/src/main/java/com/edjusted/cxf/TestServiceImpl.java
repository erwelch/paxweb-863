package com.edjusted.cxf;

import com.edjusted.lib.Response;

/**
 * @author ewelch
 * @since 2015/07/18 10:41
 */
public class TestServiceImpl implements TestService {

    @Override
    public Response processEvent() throws Exception {
        Response resp = new Response();
        resp.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return resp;
    }
}
