// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EditPhotoActivity_ViewBinding implements Unbinder {
  private EditPhotoActivity target;

  @UiThread
  public EditPhotoActivity_ViewBinding(EditPhotoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EditPhotoActivity_ViewBinding(EditPhotoActivity target, View source) {
    this.target = target;

    target.foto = Utils.findRequiredViewAsType(source, R.id.foto, "field 'foto'", SimpleDraweeView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EditPhotoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.foto = null;
  }
}
