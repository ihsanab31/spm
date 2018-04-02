// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.event;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EventActivity_ViewBinding implements Unbinder {
  private EventActivity target;

  private View view2131755247;

  @UiThread
  public EventActivity_ViewBinding(EventActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EventActivity_ViewBinding(final EventActivity target, View source) {
    this.target = target;

    View view;
    target.rvData = Utils.findRequiredViewAsType(source, R.id.rv_data, "field 'rvData'", RecyclerView.class);
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", Spinner.class);
    target.containerToolbar = Utils.findRequiredViewAsType(source, R.id.container_toolbar, "field 'containerToolbar'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.back_event, "method 'back'");
    view2131755247 = view;
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
    EventActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvData = null;
    target.spinnerMallName = null;
    target.containerToolbar = null;

    view2131755247.setOnClickListener(null);
    view2131755247 = null;
  }
}
