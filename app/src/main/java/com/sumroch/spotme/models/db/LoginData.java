package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

@Data
@NoArgsConstructor
public class LoginData {

    @SerializedName("token")
    @Expose
    private String token;
//    @SerializedName("user")
//    @Expose
//    private Profile data;
//    @SerializedName("mall")
//    @Expose
//    private List<Mall> mallList;

    @Data
    @NoArgsConstructor
    public static class Request {

        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("password")
        @Expose
        private String password;

        public Request(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }
}
