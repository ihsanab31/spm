// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReserveParkirActivity_ViewBinding implements Unbinder {
  private ReserveParkirActivity target;

  private View view2131755322;

  private View view2131755318;

  private View view2131755278;

  private View view2131755321;

  @UiThread
  public ReserveParkirActivity_ViewBinding(ReserveParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReserveParkirActivity_ViewBinding(final ReserveParkirActivity target, View source) {
    this.target = target;

    View view;
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvEmail = Utils.findRequiredViewAsType(source, R.id.tv_email, "field 'tvEmail'", TextView.class);
    target.tvPhone = Utils.findRequiredViewAsType(source, R.id.tv_phone, "field 'tvPhone'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.tlType = Utils.findRequiredViewAsType(source, R.id.tl_type, "field 'tlType'", TabLayout.class);
    view = Utils.findRequiredView(source, R.id.tv_parkir_location, "field 'tvParkirLocation' and method 'onClickParkirLocation'");
    target.tvParkirLocation = Utils.castView(view, R.id.tv_parkir_location, "field 'tvParkirLocation'", TextView.class);
    view2131755322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickParkirLocation();
      }
    });
    target.containerToolbar = Utils.findRequiredViewAsType(source, R.id.container_toolbar, "field 'containerToolbar'", FrameLayout.class);
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", Spinner.class);
    target.spinnerPlat = Utils.findRequiredViewAsType(source, R.id.spinnerku, "field 'spinnerPlat'", EditText.class);
    view = Utils.findRequiredView(source, R.id.back_reserve, "method 'back'");
    view2131755318 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_reserve, "method 'onClickReserve'");
    view2131755278 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickReserve();
      }
    });
    view = Utils.findRequiredView(source, R.id.find_plat, "method 'find'");
    view2131755321 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.find();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ReserveParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvName = null;
    target.tvEmail = null;
    target.tvPhone = null;
    target.tvTime = null;
    target.tlType = null;
    target.tvParkirLocation = null;
    target.containerToolbar = null;
    target.spinnerMallName = null;
    target.spinnerPlat = null;

    view2131755322.setOnClickListener(null);
    view2131755322 = null;
    view2131755318.setOnClickListener(null);
    view2131755318 = null;
    view2131755278.setOnClickListener(null);
    view2131755278 = null;
    view2131755321.setOnClickListener(null);
    view2131755321 = null;
  }
}
