// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileAddActivity_ViewBinding implements Unbinder {
  private ProfileAddActivity target;

  private View view2131755303;

  private View view2131755413;

  @UiThread
  public ProfileAddActivity_ViewBinding(ProfileAddActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileAddActivity_ViewBinding(final ProfileAddActivity target, View source) {
    this.target = target;

    View view;
    target.tlType = Utils.findRequiredViewAsType(source, R.id.tl_type_add, "field 'tlType'", TabLayout.class);
    target.plat = Utils.findRequiredViewAsType(source, R.id.et_plat_no, "field 'plat'", AutoCompleteTextView.class);
    target.warna = Utils.findRequiredViewAsType(source, R.id.et_warna_mobil, "field 'warna'", EditText.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinator, "field 'coordinatorLayout'", CoordinatorLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_simpan_ken, "method 'simpan_kedaraan'");
    view2131755303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.simpan_kedaraan();
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
    ProfileAddActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tlType = null;
    target.plat = null;
    target.warna = null;
    target.coordinatorLayout = null;

    view2131755303.setOnClickListener(null);
    view2131755303 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
