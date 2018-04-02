// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileKontaActivity_ViewBinding implements Unbinder {
  private ProfileKontaActivity target;

  private View view2131755413;

  @UiThread
  public ProfileKontaActivity_ViewBinding(ProfileKontaActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileKontaActivity_ViewBinding(final ProfileKontaActivity target, View source) {
    this.target = target;

    View view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
