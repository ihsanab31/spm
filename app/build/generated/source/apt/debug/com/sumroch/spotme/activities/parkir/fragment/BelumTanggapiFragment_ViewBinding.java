// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BelumTanggapiFragment_ViewBinding implements Unbinder {
  private BelumTanggapiFragment target;

  @UiThread
  public BelumTanggapiFragment_ViewBinding(BelumTanggapiFragment target, View source) {
    this.target = target;

    target.lvData = Utils.findRequiredViewAsType(source, R.id.list_parkir_progress, "field 'lvData'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BelumTanggapiFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvData = null;
  }
}
