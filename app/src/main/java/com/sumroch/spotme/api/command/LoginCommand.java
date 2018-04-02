package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.LoginData;

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

public class LoginCommand extends ApiService<LoginData.Request, LoginData> {

    public LoginCommand(LoginData.Request request) {
        super(request);
    }

    @Override
    public Call<ApiResponse<LoginData>> getApi() {
        return HttpClient.getInstance("tag").getApi().login(
                request.getEmail(),
                request.getPassword()
        );
    }
}
