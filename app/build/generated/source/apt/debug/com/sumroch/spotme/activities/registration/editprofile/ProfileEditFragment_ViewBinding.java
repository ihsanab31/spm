// Generated code from Butter Knife. Do not modify!
package com.sumroch.spotme.activities.registration.editprofile;

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

public class ProfileEditFragment_ViewBinding implements Unbinder {
  private ProfileEditFragment target;

  private View view2131755287;

  private View view2131755395;

  private View view2131755396;

  private View view2131755397;

  private View view2131755372;

  private View view2131755389;

  @UiThread
  public ProfileEditFragment_ViewBinding(final ProfileEditFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_picture_editf, "field 'civPicture' and method 'onClickPicture'");
    target.civPicture = Utils.castView(view, R.id.iv_picture_editf, "field 'civPicture'", SimpleDraweeView.class);
    view2131755287 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickPicture();
      }
    });
    target.etName = Utils.findRequiredViewAsType(source, R.id.et_name_profile_edit, "field 'etName'", EditText.class);
    target.etPhoneNumber = Utils.findRequiredViewAsType(source, R.id.et_phone_number_edit, "field 'etPhoneNumber'", EditText.class);
    target.rgSex = Utils.findRequiredViewAsType(source, R.id.rg_sex_edit, "field 'rgSex'", RadioGroup.class);
    view = Utils.findRequiredView(source, R.id.rb_man_edit, "field 'rgMale' and method 'onCheckedChange'");
    target.rgMale = Utils.castView(view, R.id.rb_man_edit, "field 'rgMale'", RadioButton.class);
    view2131755395 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onCheckedChange(Utils.castParam(p0, "onCheckedChanged", 0, "onCheckedChange", 0, RadioButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.rb_woman_edit, "field 'rgFemale' and method 'onCheckedChange'");
    target.rgFemale = Utils.castView(view, R.id.rb_woman_edit, "field 'rgFemale'", RadioButton.class);
    view2131755396 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.onCheckedChange(Utils.castParam(p0, "onCheckedChanged", 0, "onCheckedChange", 0, RadioButton.class));
      }
    });
    view = Utils.findRequiredView(source, R.id.et_dob_edit, "field 'etDOB' and method 'onClickDOB'");
    target.etDOB = Utils.castView(view, R.id.et_dob_edit, "field 'etDOB'", EditText.class);
    view2131755397 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickDOB();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_continue_edit, "method 'onClickedContinue'");
    view2131755372 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickedContinue();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_picture_editku, "method 'onClickPicture'");
    view2131755389 = view;
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
    ProfileEditFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.civPicture = null;
    target.etName = null;
    target.etPhoneNumber = null;
    target.rgSex = null;
    target.rgMale = null;
    target.rgFemale = null;
    target.etDOB = null;

    view2131755287.setOnClickListener(null);
    view2131755287 = null;
    ((CompoundButton) view2131755395).setOnCheckedChangeListener(null);
    view2131755395 = null;
    ((CompoundButton) view2131755396).setOnCheckedChangeListener(null);
    view2131755396 = null;
    view2131755397.setOnClickListener(null);
    view2131755397 = null;
    view2131755372.setOnClickListener(null);
    view2131755372 = null;
    view2131755389.setOnClickListener(null);
    view2131755389 = null;
  }
}
