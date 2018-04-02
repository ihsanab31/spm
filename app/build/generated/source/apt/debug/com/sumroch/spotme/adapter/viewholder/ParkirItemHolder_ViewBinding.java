// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.adapter.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ParkirItemHolder_ViewBinding implements Unbinder {
  private ParkirItemHolder target;

  @UiThread
  public ParkirItemHolder_ViewBinding(ParkirItemHolder target, View source) {
    this.target = target;

    target.tvFloor = Utils.findRequiredViewAsType(source, R.id.tv_floor, "field 'tvFloor'", TextView.class);
    target.tvAvailableSpaces = Utils.findRequiredViewAsType(source, R.id.tv_available_spaces, "field 'tvAvailableSpaces'", TextView.class);
    target.pbUsageSpaces = Utils.findRequiredViewAsType(source, R.id.pb_usage_spaces, "field 'pbUsageSpaces'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ParkirItemHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvFloor = null;
    target.tvAvailableSpaces = null;
    target.pbUsageSpaces = null;
  }
}
