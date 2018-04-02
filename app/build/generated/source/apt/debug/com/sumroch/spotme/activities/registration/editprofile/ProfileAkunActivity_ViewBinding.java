// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileAkunActivity_ViewBinding implements Unbinder {
  private ProfileAkunActivity target;

  private View view2131755311;

  private View view2131755413;

  @UiThread
  public ProfileAkunActivity_ViewBinding(ProfileAkunActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileAkunActivity_ViewBinding(final ProfileAkunActivity target, View source) {
    this.target = target;

    View view;
    target.nama = Utils.findRequiredViewAsType(source, R.id.et_nama_profile, "field 'nama'", EditText.class);
    target.email = Utils.findRequiredViewAsType(source, R.id.et_email_profile, "field 'email'", EditText.class);
    target.tgl_lahir = Utils.findRequiredViewAsType(source, R.id.et_tgl_profile, "field 'tgl_lahir'", EditText.class);
    target.no_hp = Utils.findRequiredViewAsType(source, R.id.et_tlpn_profile, "field 'no_hp'", EditText.class);
    target.rd_edit = Utils.findRequiredViewAsType(source, R.id.rd_edit, "field 'rd_edit'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.simp, "method 'simpan'");
    view2131755311 = view;
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
    ProfileAkunActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nama = null;
    target.email = null;
    target.tgl_lahir = null;
    target.no_hp = null;
    target.rd_edit = null;

    view2131755311.setOnClickListener(null);
    view2131755311 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
