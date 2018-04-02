package com.sumroch.spotme.api.impl;


import com.sumroch.spotme.api.interfaces.ApiExecutor;
import com.sumroch.spotme.api.interfaces.Callback;

import java.lang.reflect.Constructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class ApiExecutorImpl implements ApiExecutor {

    @Override
    public <REQUEST, RESPONSE> void execute(Class<? extends com.sumroch.spotme.api.interfaces.ApiService<REQUEST, RESPONSE>> apiServiceClass, REQUEST request, Callback<RESPONSE> callback) {
        try {
            Constructor<?> constructor = apiServiceClass.getConstructors()[0];
            ApiService<REQUEST, RESPONSE> service = (ApiService<REQUEST, RESPONSE>) constructor.newInstance(request);
            service.execute(request, callback);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
