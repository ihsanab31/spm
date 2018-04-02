// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.dialog;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogParkir_ViewBinding implements Unbinder {
  private DialogParkir target;

  private View view2131755348;

  private View view2131755349;

  @UiThread
  public DialogParkir_ViewBinding(DialogParkir target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DialogParkir_ViewBinding(final DialogParkir target, View source) {
    this.target = target;

    View view;
    target.textView = Utils.findRequiredViewAsType(source, R.id.dat_plat, "field 'textView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.edit_plat, "method 'edit'");
    view2131755348 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.edit();
      }
    });
    view = Utils.findRequiredView(source, R.id.pilih_plat, "method 'pilih'");
    view2131755349 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pilih();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DialogParkir target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;

    view2131755348.setOnClickListener(null);
    view2131755348 = null;
    view2131755349.setOnClickListener(null);
    view2131755349 = null;
  }
}
