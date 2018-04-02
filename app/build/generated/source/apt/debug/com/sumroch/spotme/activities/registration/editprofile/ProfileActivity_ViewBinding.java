// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sumroch.spotme.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  private View view2131755289;

  private View view2131755290;

  private View view2131755291;

  private View view2131755293;

  private View view2131755294;

  private View view2131755413;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(final ProfileActivity target, View source) {
    this.target = target;

    View view;
    target.foto = Utils.findRequiredViewAsType(source, R.id.iv_picture_editf, "field 'foto'", CircleImageView.class);
    target.nama = Utils.findRequiredViewAsType(source, R.id.name_pro, "field 'nama'", TextView.class);
    view = Utils.findRequiredView(source, R.id.txt_akun, "method 'onClickText'");
    view2131755289 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickText(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_kendaraan, "method 'onClickText'");
    view2131755290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickText(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_kontak, "method 'onClickText'");
    view2131755291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickText(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_ganti_pass, "method 'onClickText'");
    view2131755293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickText(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_logout, "method 'onClickText'");
    view2131755294 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickText(p0);
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
    ProfileActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.foto = null;
    target.nama = null;

    view2131755289.setOnClickListener(null);
    view2131755289 = null;
    view2131755290.setOnClickListener(null);
    view2131755290 = null;
    view2131755291.setOnClickListener(null);
    view2131755291 = null;
    view2131755293.setOnClickListener(null);
    view2131755293 = null;
    view2131755294.setOnClickListener(null);
    view2131755294 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
  }
}
