// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.GridView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AvailableParkirActivity_ViewBinding implements Unbinder {
  private AvailableParkirActivity target;

  private View view2131755214;

  @UiThread
  public AvailableParkirActivity_ViewBinding(AvailableParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AvailableParkirActivity_ViewBinding(final AvailableParkirActivity target, View source) {
    this.target = target;

    View view;
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", Spinner.class);
    target.gvData = Utils.findRequiredViewAsType(source, R.id.gv_data, "field 'gvData'", GridView.class);
    view = Utils.findRequiredView(source, R.id.back_available, "method 'back'");
    view2131755214 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AvailableParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinnerMallName = null;
    target.gvData = null;

    view2131755214.setOnClickListener(null);
    view2131755214 = null;
  }
}
