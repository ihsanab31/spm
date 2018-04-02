// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.adapter.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ParkirLocationItemHolder_ViewBinding implements Unbinder {
  private ParkirLocationItemHolder target;

  @UiThread
  public ParkirLocationItemHolder_ViewBinding(ParkirLocationItemHolder target, View source) {
    this.target = target;

    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.mobil = Utils.findRequiredViewAsType(source, R.id.image_mobil, "field 'mobil'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ParkirLocationItemHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.mobil = null;
  }
}
