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

public class ProfilePassworActivity_ViewBinding implements Unbinder {
  private ProfilePassworActivity target;

  private View view2131755317;

  private View view2131755413;

  @UiThread
  public ProfilePassworActivity_ViewBinding(ProfilePassworActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfilePassworActivity_ViewBinding(final ProfilePassworActivity target, View source) {
    this.target = target;

    View view;
    target.pass_lama = Utils.findRequiredViewAsType(source, R.id.et_pass_lama, "field 'pass_lama'", EditText.class);
    target.pass_baru = Utils.findRequiredViewAsType(source, R.id.et_pass_baru, "field 'pass_baru'", EditText.class);
    target.pass_kon = Utils.findRequiredViewAsType(source, R.id.et_password_konfirm, "field 'pass_kon'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_simpan_pass, "method 'simpan'");
    view2131755317 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.simpan();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_kembali, "method 'kembali'");
    view2131755413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.kembali();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfilePassworActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pass_lama = null;
    target.pass_baru = null;
    target.pass_kon = null;

    view2131755317.setOnClickListener(null);
    view2131755317 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
