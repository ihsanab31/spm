package com.sumroch.spotme.models.db;

import java.util.Random;

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
public class User {

    private String id;
    private String name;
    private String avatar;
    private int notifUser;
    private int notifSetting;

    public User(String id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    public static User getDummyUser() {
        User user = new User();
        user.setId("#" + String.valueOf(new Random().nextInt(1234567) + 1234567));
        user.setName("User" + user.getId());
        user.setAvatar("");
        user.setNotifUser(new Random().nextInt(99));
        user.setNotifSetting(new Random().nextInt(99));
        return user;
    }
}
