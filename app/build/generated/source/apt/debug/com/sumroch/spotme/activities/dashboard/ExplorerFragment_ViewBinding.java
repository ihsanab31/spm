// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.dashboard;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ViewAnimator;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ExplorerFragment_ViewBinding implements Unbinder {
  private ExplorerFragment target;

  private View view2131755366;

  @UiThread
  public ExplorerFragment_ViewBinding(final ExplorerFragment target, View source) {
    this.target = target;

    View view;
    target.mallContainer = Utils.findRequiredView(source, R.id.mall_container, "field 'mallContainer'");
    target.rvMall = Utils.findRequiredViewAsType(source, R.id.rv_mall, "field 'rvMall'", RecyclerView.class);
    target.mallAnimator = Utils.findRequiredViewAsType(source, R.id.mall_animator, "field 'mallAnimator'", ViewAnimator.class);
    view = Utils.findRequiredView(source, R.id.btn_close, "method 'onCloseMallContainer'");
    view2131755366 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCloseMallContainer();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ExplorerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mallContainer = null;
    target.rvMall = null;
    target.mallAnimator = null;

    view2131755366.setOnClickListener(null);
    view2131755366 = null;
  }
}
