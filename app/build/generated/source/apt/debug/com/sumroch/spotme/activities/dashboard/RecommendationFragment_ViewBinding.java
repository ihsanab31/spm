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

public class RecommendationFragment_ViewBinding implements Unbinder {
  private RecommendationFragment target;

  @UiThread
  public RecommendationFragment_ViewBinding(RecommendationFragment target, View source) {
    this.target = target;

    target.recommendationListContainer = Utils.findRequiredViewAsType(source, R.id.recommendation_deals_container, "field 'recommendationListContainer'", FrameLayout.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refresh_layout, "field 'refreshLayout'", SwipeRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecommendationFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recommendationListContainer = null;
    target.refreshLayout = null;
  }
}
