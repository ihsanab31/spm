// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.dashboard;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ViewAnimator;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import com.viewpagerindicator.CirclePageIndicator;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DealsFragment_ViewBinding implements Unbinder {
  private DealsFragment target;

  @UiThread
  public DealsFragment_ViewBinding(DealsFragment target, View source) {
    this.target = target;

    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
    target.pagerPromo = Utils.findRequiredViewAsType(source, R.id.pager_promo, "field 'pagerPromo'", ViewPager.class);
    target.pageIndicator = Utils.findRequiredViewAsType(source, R.id.indicator, "field 'pageIndicator'", CirclePageIndicator.class);
    target.animatorPromo = Utils.findRequiredViewAsType(source, R.id.animator_promo, "field 'animatorPromo'", ViewAnimator.class);
    target.beaconDealsContainer = Utils.findRequiredViewAsType(source, R.id.beacon_deals_container, "field 'beaconDealsContainer'", FrameLayout.class);
    target.exclusiveDealsContainer = Utils.findRequiredViewAsType(source, R.id.exclusive_deals_container, "field 'exclusiveDealsContainer'", FrameLayout.class);
    target.btnExclusiveDealsLoadMore = Utils.findRequiredViewAsType(source, R.id.btn_exclusive_deals_view_more, "field 'btnExclusiveDealsLoadMore'", Button.class);
    target.btnBeaconDealsLoadMore = Utils.findRequiredViewAsType(source, R.id.btn_beacon_deals_view_more, "field 'btnBeaconDealsLoadMore'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DealsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.refreshLayout = null;
    target.pagerPromo = null;
    target.pageIndicator = null;
    target.animatorPromo = null;
    target.beaconDealsContainer = null;
    target.exclusiveDealsContainer = null;
    target.btnExclusiveDealsLoadMore = null;
    target.btnBeaconDealsLoadMore = null;
  }
}
