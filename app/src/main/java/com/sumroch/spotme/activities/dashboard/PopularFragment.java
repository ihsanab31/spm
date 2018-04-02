package com.sumroch.spotme.activities.dashboard;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.FrameLayout;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;
import com.sumroch.spotme.models.Deals;
import com.sumroch.spotme.views.DealsView;

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

public class PopularFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.popular_deals_container)
    FrameLayout popularDealsContainer;
    @BindView(R.id.deals_container)
    FrameLayout pagerDealsContainer;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_popular;
    }

    @Override
    protected void onBindView() {
        refreshLayout.setOnRefreshListener(this);
        //generate deals view for fashion popular deals
        DealsView.Builder dealsViewBuilder = new DealsView.Builder(getActivity())
                .setLimitPerPage(5)
                .setEnableLoadMore(false)
                .setGridColumn(2)
                .setContainer(popularDealsContainer)
                .setType(Deals.Request.DEFAULT_TYPE)
                .setSpanPosition(0);
        dealsViewBuilder.buildToContainer();

        //generate deals view for film theater
        DealsView.Builder dealsViewBuilder2 = new DealsView.Builder(getActivity())
                .setLimitPerPage(5)
                .setEnableLoadMore(false)
                .setType(Deals.Request.DEFAULT_TYPE)
                .setContainer(pagerDealsContainer)
                .setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        dealsViewBuilder2.buildToContainer();
    }

    @Override
    public void onRefresh() {
        //TODO: add refresh method
        refreshLayout.setRefreshing(false);

    }
}
