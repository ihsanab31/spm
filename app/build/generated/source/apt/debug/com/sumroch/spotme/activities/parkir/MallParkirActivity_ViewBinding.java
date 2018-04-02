// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MallParkirActivity_ViewBinding implements Unbinder {
  private MallParkirActivity target;

  private View view2131755278;

  private View view2131755413;

  @UiThread
  public MallParkirActivity_ViewBinding(MallParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MallParkirActivity_ViewBinding(final MallParkirActivity target, View source) {
    this.target = target;

    View view;
    target.ivBanner = Utils.findRequiredViewAsType(source, R.id.iv_pin, "field 'ivBanner'", SimpleDraweeView.class);
    target.tvMallName = Utils.findRequiredViewAsType(source, R.id.tv_mall_name, "field 'tvMallName'", TextView.class);
    target.tvMallAddess = Utils.findRequiredViewAsType(source, R.id.tv_mall_address, "field 'tvMallAddess'", TextView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvShortDescription = Utils.findRequiredViewAsType(source, R.id.tv_short_description, "field 'tvShortDescription'", TextView.class);
    target.tvSpace = Utils.findRequiredViewAsType(source, R.id.tv_space, "field 'tvSpace'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_reserve, "method 'onClick'");
    view2131755278 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_kembali, "method 'kembali'");
    view2131755413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.kembali();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MallParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBanner = null;
    target.tvMallName = null;
    target.tvMallAddess = null;
    target.tvTitle = null;
    target.tvShortDescription = null;
    target.tvSpace = null;

    view2131755278.setOnClickListener(null);
    view2131755278 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
