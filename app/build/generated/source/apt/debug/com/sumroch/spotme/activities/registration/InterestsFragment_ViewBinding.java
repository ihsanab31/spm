// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.flexbox.FlexboxLayout;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InterestsFragment_ViewBinding implements Unbinder {
  private InterestsFragment target;

  private View view2131755370;

  @UiThread
  public InterestsFragment_ViewBinding(final InterestsFragment target, View source) {
    this.target = target;

    View view;
    target.flexboxLayout = Utils.findRequiredViewAsType(source, R.id.flexbox, "field 'flexboxLayout'", FlexboxLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_continue, "method 'onClickedContinue'");
    view2131755370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickedContinue();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    InterestsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flexboxLayout = null;

    view2131755370.setOnClickListener(null);
    view2131755370 = null;
  }
}
