// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.event;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EventDetailActivity_ViewBinding implements Unbinder {
  private EventDetailActivity target;

  @UiThread
  public EventDetailActivity_ViewBinding(EventDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EventDetailActivity_ViewBinding(EventDetailActivity target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.tvShortDescription = Utils.findRequiredViewAsType(source, R.id.tv_short_description, "field 'tvShortDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EventDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.tvShortDescription = null;
  }
}
