// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.gridmenu;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bottlerocketstudios.barcode.generation.ui.BarcodeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MemberActivity_ViewBinding implements Unbinder {
  private MemberActivity target;

  @UiThread
  public MemberActivity_ViewBinding(MemberActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MemberActivity_ViewBinding(MemberActivity target, View source) {
    this.target = target;

    target.barcodeView = Utils.findRequiredViewAsType(source, R.id.bv_data, "field 'barcodeView'", BarcodeView.class);
    target.tvData = Utils.findRequiredViewAsType(source, R.id.tv_data, "field 'tvData'", TextView.class);
    target.tvData1 = Utils.findRequiredViewAsType(source, R.id.tv_data_phone, "field 'tvData1'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MemberActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.barcodeView = null;
    target.tvData = null;
    target.tvData1 = null;
  }
}
