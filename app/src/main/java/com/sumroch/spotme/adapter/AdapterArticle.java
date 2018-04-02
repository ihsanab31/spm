package com.sumroch.spotme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.helper.RealmHelper;
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
public class AdapterArticle extends RecyclerView.Adapter<AdapterArticle.ViewHolder> {
    private RealmHelper helper;
    Context context;
    ArrayList<KendaraanModel> data;
    private final OnItemClickListener listener;
    private ArrayList <KendaraanModel> article;


    public AdapterArticle(ArrayList<KendaraanModel> article, OnItemClickListener listener) {
        this.article = article;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, null);
        ViewHolder vh = new ViewHolder(view);
        helper = new RealmHelper(context);
        data =  helper.findAllArticle();
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.click(article.get(position), listener);
        final KendaraanModel currentWo = article.get(position);
        holder.tvId.setText(String.valueOf(article.get(position).getId()));
        holder.title.setText(article.get(position).getJ_kendaraan());
        holder.description.setText(article.get(position).getPlat());

    }


    @Override
    public int getItemCount() {
        return article.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, title, description, edit;


        public ViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            description = (TextView) itemView.findViewById(R.id.tvDescription);
        }


        public void click(final KendaraanModel articleModel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(articleModel);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onClick(KendaraanModel item);
    }
} 
