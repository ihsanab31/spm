// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.notification;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationDetailActivity_ViewBinding implements Unbinder {
  private NotificationDetailActivity target;

  @UiThread
  public NotificationDetailActivity_ViewBinding(NotificationDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationDetailActivity_ViewBinding(NotificationDetailActivity target, View source) {
    this.target = target;

    target.cvImage = Utils.findRequiredViewAsType(source, R.id.cv_image, "field 'cvImage'", CardView.class);
    target.ivEvent = Utils.findRequiredViewAsType(source, R.id.iv_event, "field 'ivEvent'", SimpleDraweeView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvExpired = Utils.findRequiredViewAsType(source, R.id.tv_expired, "field 'tvExpired'", TextView.class);
    target.tvShortDescription = Utils.findRequiredViewAsType(source, R.id.tv_short_description, "field 'tvShortDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cvImage = null;
    target.ivEvent = null;
    target.tvTitle = null;
    target.tvExpired = null;
    target.tvShortDescription = null;
  }
}
