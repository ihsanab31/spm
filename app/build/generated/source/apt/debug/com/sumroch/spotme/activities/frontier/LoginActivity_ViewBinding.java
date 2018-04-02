// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.frontier;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131755268;

  private View view2131755269;

  private View view2131755262;

  private View view2131755263;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bt_sign_in, "method 'onSignInClicked'");
    view2131755268 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSignInClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_sign_up, "method 'onSignUpClicked'");
    view2131755269 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSignUpClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sign_up_google, "method 'onClick'");
    view2131755262 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sign_up_facebook, "method 'onClick'");
    view2131755263 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131755268.setOnClickListener(null);
    view2131755268 = null;
    view2131755269.setOnClickListener(null);
    view2131755269 = null;
    view2131755262.setOnClickListener(null);
    view2131755262 = null;
    view2131755263.setOnClickListener(null);
    view2131755263 = null;
  }
}
