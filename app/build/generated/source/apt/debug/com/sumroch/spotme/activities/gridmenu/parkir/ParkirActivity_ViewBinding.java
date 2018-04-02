// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.gridmenu.parkir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ParkirActivity_ViewBinding implements Unbinder {
  private ParkirActivity target;

  @UiThread
  public ParkirActivity_ViewBinding(ParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ParkirActivity_ViewBinding(ParkirActivity target, View source) {
    this.target = target;

    target.lvParkir = Utils.findRequiredViewAsType(source, R.id.lv_parkir, "field 'lvParkir'", ListView.class);
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", Spinner.class);
    target.containerToolbar = Utils.findRequiredViewAsType(source, R.id.container_toolbar, "field 'containerToolbar'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvParkir = null;
    target.spinnerMallName = null;
    target.containerToolbar = null;
  }
}
