package com.sumroch.spotme.api.command;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.HistoryParkir;
import com.sumroch.spotme.models.db.Parkir;

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

public class ParkirCommand extends ApiService<Parkir.Request, List<HistoryParkir>> {

    public ParkirCommand(Parkir.Request request) {
        super(request);
    }

    @Override
    public Call<ApiResponse<List<HistoryParkir>>> getApi() {
        return HttpClient.getInstance().getApi().submitParkir(
                request.getIdUser(),
                request.getIdMall(),
                request.getIdLokasi(),
                request.getPlatNomor(),
                request.getJenisKendaraan()
        );
    }
}
