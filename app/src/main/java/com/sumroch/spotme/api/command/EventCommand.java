package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.EventData;

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
public class EventCommand extends ApiService<String, EventData> {

    public EventCommand(String s) {
        super(s);
    }

    @Override
    public Call<ApiResponse<EventData>> getApi() {
        return HttpClient.getInstance().getApi().getEvent(request);
    }
}
