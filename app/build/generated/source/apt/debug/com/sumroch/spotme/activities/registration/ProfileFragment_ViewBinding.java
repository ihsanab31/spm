// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileFragment_ViewBinding implements Unbinder {
  private ProfileFragment target;

  private View view2131755379;

  private View view2131755386;

  private View view2131755387;

  private View view2131755388;

  private View view2131755370;

  private View view2131755380;

  @UiThread
  public ProfileFragment_ViewBinding(final ProfileFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_picture, "field 'civPicture' and method 'onClickPicture'");
    target.civPicture = Utils.castView(view, R.id.iv_picture, "field 'civPicture'", SimpleDraweeView.class);
    view2131755379 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickPicture();
      }
    });
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name, "field 'etName'", EditText.class);
    target.etPhoneNumber = Utils.findRequiredViewAsType(source, R.id.et_phone_number, "field 'etPhoneNumber'", EditText.class);
    target.rgSex = Utils.findRequiredViewAsType(source, R.id.rg_sex, "field 'rgSex'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.rb_man, "field 'rgMale' and method 'onCheckedChange'");
    target.rgMale = Utils.castView(view, R.id.rb_man, "field 'rgMale'", RadioButton.class);
    view2131755386 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onCheckedChange(Utils.castParam(p0, "onCheckedChanged", 0, "onCheckedChange", 0, RadioButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_woman, "field 'rgFemale' and method 'onCheckedChange'");
    target.rgFemale = Utils.castView(view, R.id.rb_woman, "field 'rgFemale'", RadioButton.class);
    view2131755387 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onCheckedChange(Utils.castParam(p0, "onCheckedChanged", 0, "onCheckedChange", 0, RadioButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.et_dob, "field 'etDOB' and method 'onClickDOB'");
    target.etDOB = Utils.castView(view, R.id.et_dob, "field 'etDOB'", EditText.class);
    view2131755388 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickDOB();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_continue, "method 'onClickedContinue'");
    view2131755370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickedContinue();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_picture_edit, "method 'onClickPicture'");
    view2131755380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickPicture();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.civPicture = null;
    target.etName = null;
    target.etPhoneNumber = null;
    target.rgSex = null;
    target.rgMale = null;
    target.rgFemale = null;
    target.etDOB = null;

    view2131755379.setOnClickListener(null);
    view2131755379 = null;
    ((CompoundButton) view2131755386).setOnCheckedChangeListener(null);
    view2131755386 = null;
    ((CompoundButton) view2131755387).setOnCheckedChangeListener(null);
    view2131755387 = null;
    view2131755388.setOnClickListener(null);
    view2131755388 = null;
    view2131755370.setOnClickListener(null);
    view2131755370 = null;
    view2131755380.setOnClickListener(null);
    view2131755380 = null;
  }
}
