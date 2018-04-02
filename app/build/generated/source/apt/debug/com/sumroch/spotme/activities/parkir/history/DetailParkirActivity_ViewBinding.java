// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.parkir.history;

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

public class DetailParkirActivity_ViewBinding implements Unbinder {
  private DetailParkirActivity target;

  private View view2131755242;

  private View view2131755413;

  @UiThread
  public DetailParkirActivity_ViewBinding(DetailParkirActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailParkirActivity_ViewBinding(final DetailParkirActivity target, View source) {
    this.target = target;

    View view;
    target.mobil = Utils.findRequiredViewAsType(source, R.id.txt_mobil_detail, "field 'mobil'", TextView.class);
    target.name = Utils.findRequiredViewAsType(source, R.id.txt_name_detail, "field 'name'", TextView.class);
    target.phone = Utils.findRequiredViewAsType(source, R.id.txt_phone_detail, "field 'phone'", TextView.class);
    target.plat = Utils.findRequiredViewAsType(source, R.id.txt_platmbl_detail, "field 'plat'", TextView.class);
    target.lokasi = Utils.findRequiredViewAsType(source, R.id.txt_lokasi_detail, "field 'lokasi'", TextView.class);
    target.status = Utils.findRequiredViewAsType(source, R.id.txt_status_detail, "field 'status'", TextView.class);
    target.tanggal = Utils.findRequiredViewAsType(source, R.id.tanggal_masuk, "field 'tanggal'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_selesai, "method 'selesai'");
    view2131755242 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selesai();
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
    DetailParkirActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mobil = null;
    target.name = null;
    target.phone = null;
    target.plat = null;
    target.lokasi = null;
    target.status = null;
    target.tanggal = null;

    view2131755242.setOnClickListener(null);
    view2131755242 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
