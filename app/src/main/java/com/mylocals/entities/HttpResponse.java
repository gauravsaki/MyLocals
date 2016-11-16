package com.mylocals.entities;

import java.util.Map;

/**
 * Created by hp on 14/11/2016.
 */
public class HttpResponse {
    // the request url
    public String url;

    // the requester ip
    public String origin;

    // all headers that have been sent
   public Map headers;

    // url arguments
    public Map args;

    // post form parameters
    public Map form;

    // post body json
    public Map json;
}
