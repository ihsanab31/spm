package com.sumroch.spotme.helper.auth.facebookSignIn;

import org.json.JSONObject;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class FacebookUser {
    public String name;

    public String email;

    public String facebookID;

    public String gender;

    public String about;

    public String bio;

    public String coverPicUrl;

    public String profilePic;

    /**
     * JSON response received. If you want to parse more fields.
     */
    public JSONObject response;

    @Override
    public String toString() {
        return "FacebookUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", facebookID='" + facebookID + '\'' +
                ", gender='" + gender + '\'' +
                ", about='" + about + '\'' +
                ", bio='" + bio + '\'' +
                ", coverPicUrl='" + coverPicUrl + '\'' +
                ", profilePic='" + profilePic + '\'' +
                '}';
    }
}
