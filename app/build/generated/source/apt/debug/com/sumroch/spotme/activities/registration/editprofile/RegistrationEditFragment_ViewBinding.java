// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegistrationEditFragment_ViewBinding implements Unbinder {
  private RegistrationEditFragment target;

  private View view2131755370;

  @UiThread
  public RegistrationEditFragment_ViewBinding(final RegistrationEditFragment target, View source) {
    this.target = target;

    View view;
    target.etUsername = Utils.findRequiredViewAsType(source, R.id.et_username_edit, "field 'etUsername'", EditText.class);
    target.etEmail = Utils.findRequiredViewAsType(source, R.id.et_email_edit, "field 'etEmail'", EditText.class);
    target.etPassword = Utils.findRequiredViewAsType(source, R.id.et_password_edit, "field 'etPassword'", EditText.class);
    target.etConfirmPassword = Utils.findRequiredViewAsType(source, R.id.et_confirm_password_edit, "field 'etConfirmPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_continue, "method 'onClickedContinue'");
    view2131755370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickedContinue();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RegistrationEditFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etUsername = null;
    target.etEmail = null;
    target.etPassword = null;
    target.etConfirmPassword = null;

    view2131755370.setOnClickListener(null);
    view2131755370 = null;
  }
}
