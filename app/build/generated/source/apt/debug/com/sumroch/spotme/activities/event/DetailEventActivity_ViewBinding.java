// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.event;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailEventActivity_ViewBinding implements Unbinder {
  private DetailEventActivity target;

  private View view2131755228;

  @UiThread
  public DetailEventActivity_ViewBinding(DetailEventActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailEventActivity_ViewBinding(final DetailEventActivity target, View source) {
    this.target = target;

    View view;
    target.tvToolbar = Utils.findRequiredViewAsType(source, R.id.tv_toolbar, "field 'tvToolbar'", TextView.class);
    target.cvImage = Utils.findRequiredViewAsType(source, R.id.cv_image, "field 'cvImage'", CardView.class);
    target.ivEvent = Utils.findRequiredViewAsType(source, R.id.iv_event, "field 'ivEvent'", SimpleDraweeView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvExpired = Utils.findRequiredViewAsType(source, R.id.tv_expired, "field 'tvExpired'", TextView.class);
    target.tvShortDescription = Utils.findRequiredViewAsType(source, R.id.tv_short_description, "field 'tvShortDescription'", TextView.class);
    view = Utils.findRequiredView(source, R.id.back_event_detail, "method 'back'");
    view2131755228 = view;
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
    DetailEventActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvToolbar = null;
    target.cvImage = null;
    target.ivEvent = null;
    target.tvTitle = null;
    target.tvExpired = null;
    target.tvShortDescription = null;

    view2131755228.setOnClickListener(null);
    view2131755228 = null;
  }
}
