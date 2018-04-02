package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.SurveyData;

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

public class SurveyCommand extends ApiService<Object, List<SurveyData>> {

    public SurveyCommand(Object o) {
        super(o);
    }

    @Override
    public Call<ApiResponse<List<SurveyData>>> getApi() {
        return HttpClient.getInstance("tag").getApi().getSurvey();
    }
}
