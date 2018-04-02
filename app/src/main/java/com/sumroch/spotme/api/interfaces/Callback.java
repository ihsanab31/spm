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

public interface Callback<T> {
    /**
     * callback if api request success
     *
     * @param T response of api request
     */
    void onSuccess(T data);

    /**
     * callback if api request failure
     *
     * @param message {@link String} of failure message
     */
    void onFailure(String message);
}
