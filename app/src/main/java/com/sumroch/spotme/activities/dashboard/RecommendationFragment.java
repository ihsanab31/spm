package com.sumroch.spotme.activities.dashboard;

import android.support.v4.widget.SwipeRefreshLayout;
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

public class RecommendationFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recommendation_deals_container)
    FrameLayout recommendationListContainer;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_recommendation;
    }

    @Override
    protected void onBindView() {
        //generate deals view for flash sale deals
        refreshLayout.setOnRefreshListener(this);
        DealsView.Builder dealsViewBuilder = new DealsView.Builder(getActivity())
                .setLimitPerPage(8)
                .setType(Deals.Request.RECOMMENDATIONS_TYPE)
                .setEnableLoadMore(false)
                .setContainer(recommendationListContainer)
                .setGridColumn(2);
        dealsViewBuilder.buildToContainer();
    }

    @Override
    public void onRefresh() {
        //TODO : add refresh method
        refreshLayout.setRefreshing(false);
    }
}
