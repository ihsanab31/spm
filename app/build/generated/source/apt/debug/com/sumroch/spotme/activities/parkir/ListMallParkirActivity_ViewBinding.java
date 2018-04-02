// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListMallParkirActivity_ViewBinding implements Unbinder {
  private ListMallParkirActivity target;

  private View view2131755264;

  @UiThread
  public ListMallParkirActivity_ViewBinding(ListMallParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListMallParkirActivity_ViewBinding(final ListMallParkirActivity target, View source) {
    this.target = target;

    View view;
    target.containerToolbar = Utils.findRequiredViewAsType(source, R.id.container_toolbar, "field 'containerToolbar'", FrameLayout.class);
    target.rvMallParkir = Utils.findRequiredViewAsType(source, R.id.rv_mall_parkir, "field 'rvMallParkir'", RecyclerView.class);
    target.view = Utils.findRequiredView(source, R.id.view, "field 'view'");
    view = Utils.findRequiredView(source, R.id.back_list_mall, "method 'back'");
    view2131755264 = view;
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
    ListMallParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.containerToolbar = null;
    target.rvMallParkir = null;
    target.view = null;

    view2131755264.setOnClickListener(null);
    view2131755264 = null;
  }
}
