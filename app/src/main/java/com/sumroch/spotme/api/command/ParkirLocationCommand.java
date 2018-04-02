package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.ParkirLocation;

import java.util.List;

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

public class ParkirLocationCommand extends ApiService<String, List<ParkirLocation>> {

    public ParkirLocationCommand(String s) {
        super(s);
    }

    @Override
    public Call<ApiResponse<List<ParkirLocation>>> getApi() {
        return HttpClient.getInstance().getApi().getParkirLocation(request);
    }
}
