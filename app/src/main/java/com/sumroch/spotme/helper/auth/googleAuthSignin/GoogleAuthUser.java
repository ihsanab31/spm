package com.sumroch.spotme.helper.auth.googleAuthSignin;

import android.net.Uri;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class GoogleAuthUser {

    public String name;

    public String email;

    public String idToken;

    public String id;

    public String familyName;

    public Uri photoUrl;


    @Override
    public String toString() {
        return "GoogleAuthUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", idToken='" + idToken + '\'' +
                ", id='" + id + '\'' +
                ", familyName='" + familyName + '\'' +
                ", photoUrl=" + photoUrl +
                '}';
    }
}
