// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.dashboard;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DashboardActivity_ViewBinding implements Unbinder {
  private DashboardActivity target;

  private View view2131755515;

  private View view2131755516;

  private View view2131755517;

  private View view2131755518;

  private View view2131755226;

  @UiThread
  public DashboardActivity_ViewBinding(DashboardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DashboardActivity_ViewBinding(final DashboardActivity target, View source) {
    this.target = target;

    View view;
    target.llDashboardHeader = Utils.findRequiredViewAsType(source, R.id.ll_dashboard_header, "field 'llDashboardHeader'", LinearLayout.class);
    target.searchContainer = Utils.findRequiredView(source, R.id.search_container, "field 'searchContainer'");
    view = Utils.findRequiredView(source, R.id.btn_deals, "method 'showDeals'");
    view2131755515 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showDeals(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_recommendation, "method 'showRecommendation'");
    view2131755516 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showRecommendation(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_popular, "method 'showPopular'");
    view2131755517 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showPopular(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_explorer, "method 'showExplorer'");
    view2131755518 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showExplorer(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.back_explore, "method 'back'");
    view2131755226 = view;
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
    DashboardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llDashboardHeader = null;
    target.searchContainer = null;

    view2131755515.setOnClickListener(null);
    view2131755515 = null;
    view2131755516.setOnClickListener(null);
    view2131755516 = null;
    view2131755517.setOnClickListener(null);
    view2131755517 = null;
    view2131755518.setOnClickListener(null);
    view2131755518 = null;
    view2131755226.setOnClickListener(null);
    view2131755226 = null;
  }
}
