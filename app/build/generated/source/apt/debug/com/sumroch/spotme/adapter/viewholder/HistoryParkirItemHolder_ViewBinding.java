// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.adapter.viewholder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HistoryParkirItemHolder_ViewBinding implements Unbinder {
  private HistoryParkirItemHolder target;

  @UiThread
  public HistoryParkirItemHolder_ViewBinding(HistoryParkirItemHolder target, View source) {
    this.target = target;

    target.tvIdParkir = Utils.findRequiredViewAsType(source, R.id.tv_id_parkir, "field 'tvIdParkir'", TextView.class);
    target.tvWaktuMasuk = Utils.findRequiredViewAsType(source, R.id.tv_waktu_masuk, "field 'tvWaktuMasuk'", TextView.class);
    target.tvNameUser = Utils.findRequiredViewAsType(source, R.id.tv_nama_user, "field 'tvNameUser'", TextView.class);
    target.txtnotif = Utils.findRequiredViewAsType(source, R.id.notif_parkir, "field 'txtnotif'", TextView.class);
    target.parkir = Utils.findRequiredViewAsType(source, R.id.tv_id_parki, "field 'parkir'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HistoryParkirItemHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvIdParkir = null;
    target.tvWaktuMasuk = null;
    target.tvNameUser = null;
    target.txtnotif = null;
    target.parkir = null;
  }
}
