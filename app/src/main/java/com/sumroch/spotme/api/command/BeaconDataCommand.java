package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.BeaconData;

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

public class BeaconDataCommand extends ApiService<BeaconData.Request, List<BeaconData>> {

    public BeaconDataCommand(BeaconData.Request request) {
        super(request);
    }

    @Override
    public Call<ApiResponse<List<BeaconData>>> getApi() {
        return HttpClient.getInstance("tag").getApi().getBeaconData(
                request.getUuid(),
                request.getLimit(),
                request.getOffset()
        );
    }
}
