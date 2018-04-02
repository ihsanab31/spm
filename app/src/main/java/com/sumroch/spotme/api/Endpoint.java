package com.sumroch.spotme.api;

import com.sumroch.spotme.models.Deals;
import com.sumroch.spotme.models.db.BeaconData;
import com.sumroch.spotme.models.db.DataParkir;
import com.sumroch.spotme.models.db.EventData;
import com.sumroch.spotme.models.db.GridMenu;
import com.sumroch.spotme.models.db.HistoryParkir;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.MasterData;
import com.sumroch.spotme.models.db.ParkirLocation;
import com.sumroch.spotme.models.db.SurveyData;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public interface Endpoint {

    @GET("product")
    Call<ApiResponse<List<Deals>>> getProduct(
            @Query("limit") int limit,
            @Query("offset") int offset,
            @Query("filter") String productFilter,
            @Query("subfilter") String productSubFilter,
            @Query("merchant") String showMerchant,
            @Query("by_category") String categoryId
    );

    @GET("mall")
    Call<ApiResponse<List<Mall>>> getMall();

    @GET("gridmenu")
    Call<ApiResponse<List<GridMenu>>> getGridMenu(@Query("mall_name") String mallName);

    @GET("beacon/{uuid}")
    Call<ApiResponse<List<BeaconData>>> getBeaconData(
            @Path("uuid") String uuid,
            @Query("limit") String limit,
            @Query("offset") String offset
    );

    @POST("user/login")
    Call<ApiResponse<LoginData>> login(
            @Query("email") String email,
            @Query("password") String password
    );

    @GET("survey")
    Call<ApiResponse<List<SurveyData>>> getSurvey();

    //    @Multipart
//    @POST("user/register")
//    Call<ApiResponse<Object>> register(
//            @Part("username") RequestBody username,
//            @Part("email") RequestBody email,
//            @Part("password") RequestBody password,
//            @Part MultipartBody.Part photo,
//            @Part("name") RequestBody name,
//            @Part("no_hp") RequestBody no_hp,
//            @Part("jenis_kelamin") RequestBody jenis_kelamin,
//            @Part("dob") RequestBody dob,
//            @Part("id_survey_interest[]") RequestBody id_survey_interest
//    );

    @FormUrlEncoded
    @POST("user/update")
    Call<ApiResponse<LoginData>> update(
            @Field("id") Integer id,
            @Field("name") String name,
            @Field("username") String  username,
            @Field("email") String email,
            @Field("dob") String dob,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("no_hp") String no_hp,
            @Field("photo") String photo,
            @Field("id_survey_interest[]") String id_survey_interest
    );

    @Multipart
    @POST("user/register")
    Call<ApiResponse<LoginData>> register(
            @Part MultipartBody.Part username,
            @Part MultipartBody.Part email,
            @Part MultipartBody.Part password,
            @Part MultipartBody.Part photo,
            @Part MultipartBody.Part name,
            @Part MultipartBody.Part no_hp,
            @Part MultipartBody.Part jenis_kelamin,
            @Part MultipartBody.Part dob,
            @Part MultipartBody.Part id_survey_interest
    );

    @GET("get_data_master/{token}")
    Call<ApiResponse<MasterData>> getMasterData(@Path("token") String token);

    @GET("data_parkir")
    Call<ApiResponse<List<DataParkir>>> getDataParkir();

    @FormUrlEncoded
    @POST("parkir")
    Call<ApiResponse<List<HistoryParkir>>> submitParkir(
            @Field("id_user") Integer idUser,
            @Field("id_mall") Integer idMall,
            @Field("id_lokasi") Integer idLokasi,
            @Field("plat_nomor") String platNomor,
            @Field("jenis_kendaraan") String jenisKendaraan
    );

    @GET("lokasi_parkir/{id}")
    Call<ApiResponse<List<ParkirLocation>>> getParkirLocation(@Path("id") String id);

    @GET("event/{id}")
    Call<ApiResponse<EventData>> getEvent(@Path("id") String id);
}
