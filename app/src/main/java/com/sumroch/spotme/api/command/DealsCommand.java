package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.Deals;

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

public class DealsCommand extends ApiService<Deals.Request, List<Deals>> {
    public DealsCommand(Deals.Request request) {
        super(request);
    }

    @Override
    public Call<ApiResponse<List<Deals>>> getApi() {
        return HttpClient.getInstance().getApi().getProduct(
                request.getLimit(),
                request.getOffset(),
                request.getType(),
                request.getSubFilter(),
                request.getShowMerchant(),
                String.valueOf(request.getCategoryId() == null ? "" : request.getCategoryId()));
    }
}
