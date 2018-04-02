package com.sumroch.spotme.api.impl;

import com.sumroch.spotme.SpotMe;
import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.interfaces.Callback;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public abstract class ApiService<REQUEST, RESPONSE> implements com.sumroch.spotme.api.interfaces.ApiService<REQUEST, RESPONSE> {
    protected REQUEST request;

    public ApiService(REQUEST request) {
        this.request = request;
    }

    @Override
    public void execute(REQUEST request, final Callback<RESPONSE> callback) {
        getApi().enqueue(new retrofit2.Callback<ApiResponse<RESPONSE>>() {
            @Override
            public void onResponse(Call<ApiResponse<RESPONSE>> call, Response<ApiResponse<RESPONSE>> response) {
                if (response.isSuccessful()) {
                    SpotMe.log(ApiService.this.getClass().getSimpleName() + " Request Success");
                    ApiResponse<RESPONSE> apiResponse = response.body();
                    if (apiResponse.getStatus() >= 200 && apiResponse.getStatus() < 300) {
                        callback.onSuccess(apiResponse.getData());
                    } else {
                        SpotMe.log(ApiService.this.getClass().getSimpleName() + " But status code not success");
                        callback.onFailure(apiResponse.getMessage());
                    }
                } else {
                    SpotMe.log(ApiService.this.getClass().getSimpleName() + " Request Failed (" + response.code() + ")");
                    callback.onFailure(getFailedMessage(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<RESPONSE>> call, Throwable t) {
                SpotMe.log(ApiService.this.getClass().getSimpleName() + " Request Failed (" + t.getMessage() + ")");
                callback.onFailure(t.getMessage());
            }
        });
    }


    /**
     * @param statusCode int of response code
     * @return String of failed message if request code not 200
     */
    private String getFailedMessage(int statusCode) {
        switch (statusCode) {
            case 400:
                return "Client Error Bad Request";
            case 403:
                return "Client Error Forbidden";
            case 409:
                return "Client Error Conflict";
            case 401:
                return "Client Error Unauthorized";
            case 404:
                return "Client Error Not Found";
            case 500:
                return "Server Error Internal Server Error";
            case 503:
                return "Server Error Service Unavailable";
            default:
                return "Something when wrong";
        }
    }
}
