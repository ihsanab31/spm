package com.sumroch.spotme.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.AdapterArticle;
import com.sumroch.spotme.models.KendaraanModel;

import java.util.ArrayList;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class KendaraanAdapter extends RecyclerView.Adapter<KendaraanAdapter.ViewHolder> {

    private ArrayList<KendaraanModel> article;


    public KendaraanAdapter(ArrayList<KendaraanModel> article) {
        this.article = article;
    }



    @Override
    public KendaraanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, null);
        KendaraanAdapter.ViewHolder vh = new KendaraanAdapter.ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(KendaraanAdapter.ViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(article.get(position).getId()));
        holder.title.setText(article.get(position).getJ_kendaraan());
        holder.description.setText(article.get(position).getPlat());
    }


    @Override
    public int getItemCount() {
        return article.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, title, description;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }
    }
}
