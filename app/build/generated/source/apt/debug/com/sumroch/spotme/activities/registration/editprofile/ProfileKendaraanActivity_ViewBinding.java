// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileKendaraanActivity_ViewBinding implements Unbinder {
  private ProfileKendaraanActivity target;

  private View view2131755312;

  private View view2131755413;

  @UiThread
  public ProfileKendaraanActivity_ViewBinding(ProfileKendaraanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileKendaraanActivity_ViewBinding(final ProfileKendaraanActivity target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.list_kendaraan, "field 'recyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.add_data, "method 'pindah'");
    view2131755312 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pindah();
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
    ProfileKendaraanActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;

    view2131755312.setOnClickListener(null);
    view2131755312 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
