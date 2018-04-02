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

public class TanggapiFragment_ViewBinding implements Unbinder {
  private TanggapiFragment target;

  @UiThread
  public TanggapiFragment_ViewBinding(TanggapiFragment target, View source) {
    this.target = target;

    target.lvData = Utils.findRequiredViewAsType(source, R.id.list_parkir_completed, "field 'lvData'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TanggapiFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lvData = null;
  }
}
