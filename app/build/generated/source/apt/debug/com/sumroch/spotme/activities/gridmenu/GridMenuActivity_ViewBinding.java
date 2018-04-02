// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.gridmenu;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.daimajia.slider.library.SliderLayout;
import com.sumroch.spotme.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GridMenuActivity_ViewBinding implements Unbinder {
  private GridMenuActivity target;

  private View view2131755256;

  @UiThread
  public GridMenuActivity_ViewBinding(GridMenuActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GridMenuActivity_ViewBinding(final GridMenuActivity target, View source) {
    this.target = target;

    View view;
    target.gridViewMenu = Utils.findRequiredViewAsType(source, R.id.gv_menu, "field 'gridViewMenu'", GridView.class);
    target.spinnerMallName = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'spinnerMallName'", AppCompatSpinner.class);
    target.sliderLayout = Utils.findRequiredViewAsType(source, R.id.slider, "field 'sliderLayout'", SliderLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'navigationView'", NavigationView.class);
    view = Utils.findRequiredView(source, R.id.iv_avatar, "field 'ivAvatar' and method 'onClickedAvatar'");
    target.ivAvatar = Utils.castView(view, R.id.iv_avatar, "field 'ivAvatar'", CircleImageView.class);
    view2131755256 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickedAvatar();
      }
    });
    target.tvName = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tvName'", TextView.class);
    target.tvId = Utils.findRequiredViewAsType(source, R.id.tv_id, "field 'tvId'", TextView.class);
    target.containerToolbar = Utils.findRequiredViewAsType(source, R.id.container_toolbar, "field 'containerToolbar'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GridMenuActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gridViewMenu = null;
    target.spinnerMallName = null;
    target.sliderLayout = null;
    target.navigationView = null;
    target.ivAvatar = null;
    target.tvName = null;
    target.tvId = null;
    target.containerToolbar = null;

    view2131755256.setOnClickListener(null);
    view2131755256 = null;
  }
}
