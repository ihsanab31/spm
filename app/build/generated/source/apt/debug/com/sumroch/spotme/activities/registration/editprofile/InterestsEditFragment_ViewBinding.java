// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

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

public class InterestsEditFragment_ViewBinding implements Unbinder {
  private InterestsEditFragment target;

  private View view2131755372;

  @UiThread
  public InterestsEditFragment_ViewBinding(final InterestsEditFragment target, View source) {
    this.target = target;

    View view;
    target.flexboxLayout = Utils.findRequiredViewAsType(source, R.id.flexbox_edit, "field 'flexboxLayout'", FlexboxLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_continue_edit, "method 'onClickedContinue'");
    view2131755372 = view;
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
    InterestsEditFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.flexboxLayout = null;

    view2131755372.setOnClickListener(null);
    view2131755372 = null;
  }
}
