package com.sumroch.spotme.activities.parkir;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Mall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

class MallParkirAdapter extends RecyclerView.Adapter<MallParkirAdapter.ViewHolder> {

    Context context;
    List<Mall> mallList;

    public List<Mall> getMallList() {
        if (mallList == null) return new ArrayList<>();
        else return mallList;
    }

    public void setMallList(List<Mall> mallList) {
        this.mallList = mallList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(
                                R.layout.list_item_mall_parkir,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Mall mall = getMallList().get(position);
        holder.ivBanner.setImageURI(BaseImageUrl.getData().getMall() + mall.getPicture());
        holder.tvMallName.setText(mall.getName());
        holder.tvTitle.setText(mall.getName());
        holder.tvMallAddess.setText(mall.getAddress());
        holder.tvShortDescription.setText(mall.getDescription());
        holder.tvSpace.setText(Html.fromHtml(String.format("<b>%1$s</b>/%2$s", mall.getAvailableSpace(), mall.getTotalSpace())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MallParkirActivity.class);
                intent.putExtra(Constant.SELECTED_MALL_INDEX, position);
                intent.putExtra(Constant.ID, mall.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return getMallList().size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView ivBanner;
        TextView tvMallName;
        TextView tvMallAddess;
        TextView tvTitle;
        TextView tvShortDescription;
        TextView tvSpace;

        public ViewHolder(final View itemView) {
            super(itemView);
            ivBanner = (SimpleDraweeView) itemView.findViewById(R.id.iv_banner);
            tvMallName = (TextView) itemView.findViewById(R.id.tv_mall_name);
            tvMallAddess = (TextView) itemView.findViewById(R.id.tv_mall_address);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvShortDescription = (TextView) itemView.findViewById(R.id.tv_short_description);
            tvSpace = (TextView) itemView.findViewById(R.id.tv_space);
        }
    }

}
