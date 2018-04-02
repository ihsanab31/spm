package com.sumroch.spotme.api.interfaces;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public interface ApiExecutor {

    /**
     * method for execute api request
     *
     * @param apiService {@link ApiService}
     * @param request    REQUEST abstract field for request object
     */
    <REQUEST, RESPONSE> void execute(Class<? extends ApiService<REQUEST, RESPONSE>> apiServiceClass,
                                     REQUEST request,
                                     Callback<RESPONSE> callback);
}
