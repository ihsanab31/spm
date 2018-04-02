package com.sumroch.spotme.views;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringDef;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.sumroch.spotme.R;
import com.sumroch.spotme.api.command.DealsCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.ApiExecutor;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.Deals;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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

public class DealsView {
    private LayoutInflater inflater;
    private ViewAnimator animator;
    private DealsAdapter dealsAdapter;
    private ViewGroup container;
    private boolean showBeaconIcon;
    private boolean enableLoadMore; // TODO this flag use when implement load more
    private int limitPerPage;
    private int gridColumn;
    private String type;
    private Integer categoryId;
    private Integer spanPosition;
    private Context context;
    private RecyclerView.LayoutManager layoutManager;
    private ApiExecutor apiExecutor;
    private DealsDataListener dealsDataListener;
    private DealsView(Builder builder) {
        this(builder, null);
    }

    private DealsView(Builder builder, DealsDataListener dealsDataListener) {
        this.context = builder.context;
        this.container = builder.container;
        this.spanPosition = builder.spanPosition;
        this.showBeaconIcon = builder.showBeaconIcon;
        this.enableLoadMore = builder.enableLoadMore;
        this.limitPerPage = builder.limitPerPage;
        this.gridColumn = builder.gridColumn;
        this.type = builder.type;
        this.layoutManager = builder.layoutManager;
        this.dealsDataListener = dealsDataListener;
        this.categoryId = builder.categoryId;
        apiExecutor = new ApiExecutorImpl();
    }

    private void build() {
        if (context == null)
            throw new IllegalArgumentException("Non Null Context - Required context");
        inflater = LayoutInflater.from(context);
        View generatedView = inflater.inflate(R.layout.view_deals, container, false);
        animator = (ViewAnimator) generatedView.findViewById(R.id.animator);
        dealsAdapter = new DealsAdapter(new ArrayList<Deals>());
        if (layoutManager == null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, gridColumn);
            if (spanPosition != null) {
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return position == spanPosition ? gridColumn : 1;
                    }
                });
            }
            layoutManager = gridLayoutManager;
        }
        RecyclerView recyclerView = (RecyclerView) generatedView.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dealsAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        getDealsData();
        container.addView(generatedView);
    }

    private void getDealsData() {
        Deals.Request request = new Deals.Request();
        request.setLimit(limitPerPage);
        if (type.equalsIgnoreCase(Deals.Request.FLASH_SALE_TYPE) || type.equalsIgnoreCase(Deals.Request.EXCLUSIVE)) {
            request.setType(Deals.Request.DEALS_TYPE);
            request.setSubFilter(type);
        } else {
            request.setType(type);
        }
        request.setCategoryId(categoryId);
        apiExecutor.execute(DealsCommand.class, request, new Callback<List<Deals>>() {
            @Override
            public void onSuccess(List<Deals> data) {
                dealsAdapter.getData().addAll(data);
                animator.setDisplayedChild(1);
                if (dealsDataListener != null)
                    dealsDataListener.onLoadDataFinished();
            }

            @Override
            public void onFailure(String message) {
                animator.setDisplayedChild(2);
            }
        });
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            Deals.Request.DEFAULT_TYPE,
            Deals.Request.DEALS_TYPE,
            Deals.Request.RECOMMENDATIONS_TYPE,
            Deals.Request.POPULAR_TYPE,
            Deals.Request.EXCLUSIVE,
            Deals.Request.FLASH_SALE_TYPE
    })
    @interface DealsFilterType {
    }

    public interface DealsDataListener {
        void onLoadDataFinished();
    }

    public static class Builder {
        private ViewGroup container;
        private boolean showBeaconIcon;
        private boolean enableLoadMore;
        private int limitPerPage;
        private int gridColumn;
        private String type;
        private Integer categoryId;
        private Integer spanPosition;
        private Context context;
        private RecyclerView.LayoutManager layoutManager;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setLimitPerPage(int limitPerPage) {
            this.limitPerPage = limitPerPage;
            return this;
        }

        public Builder setEnableLoadMore(boolean loadMore) {
            this.enableLoadMore = loadMore;
            return this;
        }

        public Builder setGridColumn(int gridColumn) {
            this.gridColumn = gridColumn;
            return this;
        }

        public Builder setLayoutManager(RecyclerView.LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        public Builder setShowBeaconIcon(boolean showBeaconIcon) {
            this.showBeaconIcon = showBeaconIcon;
            return this;
        }

        public Builder setSpanPosition(Integer spanPosition) {
            this.spanPosition = spanPosition;
            return this;
        }

        public Builder setContainer(ViewGroup container) {
            this.container = container;
            return this;
        }

        public Builder setType(@DealsFilterType String type) {
            this.type = type;
            return this;
        }

        public Builder setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public void buildToContainer() {
            DealsView dealsView = new DealsView(this);
            dealsView.build();
        }

        public void buildToContainer(DealsDataListener dealsDataListener) {
            DealsView dealsView = new DealsView(this, dealsDataListener);
            dealsView.build();
        }
    }

    private class DealsAdapter extends RecyclerView.Adapter<DealsViewHolder> {
        private List<Deals> data = new ArrayList<>();

        DealsAdapter(List<Deals> data) {
            this.data = data;
        }

        @Override
        public DealsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item_deals, parent, false);
            return new DealsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DealsViewHolder holder, int position) {
            Deals deals = getData().get(position);
            holder.tvDealsTitle.setText(deals.getName());
            if (deals.getDiscount() > 0) {
                holder.tvDealsPrice.setPaintFlags(holder.tvDealsPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.tvDealsPrice.setText(deals.getFormattedPrice());
                double discount = deals.getPrice() * (deals.getDiscount() / 100);
                double discountPrice = deals.getPrice() - discount;
                holder.tvDealsDiscPrice.setText(deals.formatPrice(discountPrice));
            } else {
                holder.tvDealsDiscPrice.setVisibility(View.GONE);
                holder.tvDealsPrice.setText(deals.getFormattedPrice());
                holder.tvDealsPrice.setPaintFlags(0);
            }
            holder.tvDealsDisc.setText(String.format("%s %%", deals.getDiscount()));
            String imageUrl = "http://spotapi.lebakhosting.com/pic/product/" + deals.getPicture();
            ImageLoader.getInstance().displayImage(imageUrl, holder.ivDealsImage);
            if (deals.getMerchant() != null) {
                String likerCount = deals.getLikersCount() > 0 ? ("+" + deals.getLikersCount()) : "";
                String dealsProvider = deals.getMerchant().getBrand().getName() + " " + likerCount;
                holder.tvDealsProvider.setText(dealsProvider);
            } else {
                holder.tvDealsProvider.setText("-");
            }
            if (showBeaconIcon)
                holder.ivBeaconIcon.setVisibility(View.VISIBLE);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public List<Deals> getData() {
            return data;
        }
    }

    private class DealsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivDealsImage, ivBeaconIcon;
        TextView tvDealsTitle, tvDealsProvider, tvDealsDisc;
        TextView tvDealsPrice, tvDealsDiscPrice;

        DealsViewHolder(View itemView) {
            super(itemView);
            ivDealsImage = (ImageView) itemView.findViewById(R.id.iv_deals_image);
            ivBeaconIcon = (ImageView) itemView.findViewById(R.id.iv_beacon_icon);
            tvDealsTitle = (TextView) itemView.findViewById(R.id.tv_deals_title);
            tvDealsDisc = (TextView) itemView.findViewById(R.id.tv_deals_discount);
            tvDealsPrice = (TextView) itemView.findViewById(R.id.tv_deals_price);
            tvDealsDiscPrice = (TextView) itemView.findViewById(R.id.tv_deals_disc_price);
            tvDealsProvider = (TextView) itemView.findViewById(R.id.tv_deals_provider);
        }
    }

    private class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }
}
