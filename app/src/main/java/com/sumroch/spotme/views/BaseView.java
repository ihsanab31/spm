package com.sumroch.spotme.views;

import android.support.annotation.StringRes;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public interface BaseView {

    void showProgressDialog(String message);

    void showProgressDialog(@StringRes int message);

    void dismissProgressDialog();

    void showMessage(String message);

    void showMessage(@StringRes int message);
}
