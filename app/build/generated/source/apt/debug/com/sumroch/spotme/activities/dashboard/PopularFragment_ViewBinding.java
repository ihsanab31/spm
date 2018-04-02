// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.dashboard;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PopularFragment_ViewBinding implements Unbinder {
  private PopularFragment target;

  @UiThread
  public PopularFragment_ViewBinding(PopularFragment target, View source) {
    this.target = target;

    target.popularDealsContainer = Utils.findRequiredViewAsType(source, R.id.popular_deals_container, "field 'popularDealsContainer'", FrameLayout.class);
    target.pagerDealsContainer = Utils.findRequiredViewAsType(source, R.id.deals_container, "field 'pagerDealsContainer'", FrameLayout.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PopularFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.popularDealsContainer = null;
    target.pagerDealsContainer = null;
    target.refreshLayout = null;
  }
}
