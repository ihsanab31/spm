// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.notification;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Spinner;
import android.widget.ViewAnimator;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationActivity_ViewBinding implements Unbinder {
  private NotificationActivity target;

  @UiThread
  public NotificationActivity_ViewBinding(NotificationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationActivity_ViewBinding(NotificationActivity target, View source) {
    this.target = target;

    target.rvNotification = Utils.findRequiredViewAsType(source, R.id.rv_notification, "field 'rvNotification'", RecyclerView.class);
    target.animator = Utils.findRequiredViewAsType(source, R.id.animator_notification, "field 'animator'", ViewAnimator.class);
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", Spinner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NotificationActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvNotification = null;
    target.animator = null;
    target.spinnerMallName = null;
  }
}
