package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.GridMenu;

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

public class GridMenuCommand extends ApiService<String, List<GridMenu>> {

    public GridMenuCommand(String s) {
        super(s);
    }

    @Override
    public Call<ApiResponse<List<GridMenu>>> getApi() {
        return HttpClient.getInstance().getApi().getGridMenu(request);
    }
}
