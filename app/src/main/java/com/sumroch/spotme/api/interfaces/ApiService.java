package com.sumroch.spotme.api.interfaces;

import com.sumroch.spotme.api.ApiResponse;

import retrofit2.Call;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public interface ApiService<REQUEST, RESPONSE> {
    void execute(REQUEST request, Callback<RESPONSE> callback);

    Call<ApiResponse<RESPONSE>> getApi();
}
