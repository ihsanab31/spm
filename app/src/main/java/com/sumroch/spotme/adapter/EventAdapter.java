package com.sumroch.spotme.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.event.DetailEventActivity;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.EventItem;

import org.parceler.Parcels;

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

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    Context context;
    String baseImageUri;
    List<EventItem> eventItemList;

    public List<EventItem> getEventItemList() {
        if (eventItemList == null) return new ArrayList<>();
        else return eventItemList;
    }

    public void setEventItemList(List<EventItem> eventItemList) {
        this.eventItemList = eventItemList;
    }

    public String getBaseImageUri() {
        if (baseImageUri == null) return "";
        return baseImageUri;
    }

    public void setBaseImageUri(String baseImageUri) {
        this.baseImageUri = baseImageUri;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.list_item_event, parent, false));
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        final EventItem eventItem = eventItemList.get(position);
        if (eventItem.getPicture() != null && !eventItem.getPicture().isEmpty() && !eventItem.getPicture().equalsIgnoreCase("placeholder.jpg")) {
            holder.layoutImage.setVisibility(View.VISIBLE);
            holder.layoutData.setVisibility(View.GONE);
            String removeCurrency= eventItem.getPicture();
            String  urlphoto = removeCurrency.substring(1);
            String imageUrl = "http://api.sumroch.com/photos/event/%20"+urlphoto;
            holder.ivEvent.setImageURI(imageUrl);
        } else {
            holder.layoutImage.setVisibility(View.GONE);
            holder.layoutData.setVisibility(View.VISIBLE);
            holder.tvTitle.setText(eventItem.getNamaEvent());
            holder.tvExpired.setText(eventItem.getWaktuEvent());
            holder.tvShortDescription.setText(Html.fromHtml(eventItem.getShortDescription()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailEventActivity.class);
                intent.putExtra(DetailEventActivity.EVENT_ITEM, Parcels.wrap(eventItem));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getEventItemList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layoutImage;
        ConstraintLayout layoutData;
        SimpleDraweeView ivEvent;
        TextView tvTitle;
        TextView tvExpired;
        TextView tvShortDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            layoutImage = (ConstraintLayout) itemView.findViewById(R.id.layout_image);
            layoutData = (ConstraintLayout) itemView.findViewById(R.id.layout_data);
            ivEvent = (SimpleDraweeView) itemView.findViewById(R.id.iv_event);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvExpired = (TextView) itemView.findViewById(R.id.tv_expired);
            tvShortDescription = (TextView) itemView.findViewById(R.id.tv_short_description);

        }
    }
}
