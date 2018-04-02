package com.sumroch.spotme.activities.dashboard;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewAnimator;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;
import com.sumroch.spotme.models.Deals;
import com.sumroch.spotme.views.DealsView;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class DealsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.pager_promo)
    ViewPager pagerPromo;
    @BindView(R.id.indicator)
    CirclePageIndicator pageIndicator;
    @BindView(R.id.animator_promo)
    ViewAnimator animatorPromo;
    @BindView(R.id.beacon_deals_container)
    FrameLayout beaconDealsContainer;
    @BindView(R.id.exclusive_deals_container)
    FrameLayout exclusiveDealsContainer;
    @BindView(R.id.btn_exclusive_deals_view_more)
    Button btnExclusiveDealsLoadMore;
    @BindView(R.id.btn_beacon_deals_view_more)
    Button btnBeaconDealsLoadMore;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_deals;
    }

    @Override
    protected void onBindView() {
        refreshLayout.setOnRefreshListener(this);
        initViewPagerPromo();

        //generate deals view for beacon deals
        DealsView.Builder beaconDealsView = new DealsView.Builder(getActivity())
                .setLimitPerPage(4)
                .setEnableLoadMore(false)
                .setGridColumn(2)
                .setShowBeaconIcon(true)
                .setType(Deals.Request.FLASH_SALE_TYPE)
                .setContainer(beaconDealsContainer);
        beaconDealsView.buildToContainer(new DealsView.DealsDataListener() {
            @Override
            public void onLoadDataFinished() {
                //btnBeaconDealsLoadMore.setVisibility(View.VISIBLE);
            }
        });

        //generate deals view for exclusive deals
        DealsView.Builder exclusiveDealsView = new DealsView.Builder(getActivity())
                .setLimitPerPage(4)
                .setEnableLoadMore(false)
                .setGridColumn(2)
                .setType(Deals.Request.EXCLUSIVE)
                .setContainer(exclusiveDealsContainer);
        beaconDealsView.buildToContainer();
        exclusiveDealsView.buildToContainer(new DealsView.DealsDataListener() {
            @Override
            public void onLoadDataFinished() {
                //btnExclusiveDealsLoadMore.setVisibility(View.VISIBLE);
            }
        });
    }

    /**
     * for initialize promo view pager
     */
    private void initViewPagerPromo() {
        //TODO : get promo data from api
        new Handler(getActivity().getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                pagerPromo.setAdapter(new PromoPagerAdapter(getActivity()));
                pageIndicator.setViewPager(pagerPromo);
                animatorPromo.setDisplayedChild(1);
            }
        }, 500);
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);
    }

    /**
     * adapter class for promo view pager adapter
     */
    private class PromoPagerAdapter extends PagerAdapter {
        private int mCount = 3;
        private LayoutInflater inflater;

        PromoPagerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.view_promo_item, container, false);
            ImageView ivPromoBanner = (ImageView) view.findViewById(R.id.iv_promo_image);
            ivPromoBanner.setImageResource(R.drawable.dummy_banner);
            container.addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(((View) object));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Promo " + position;
        }
    }
}
