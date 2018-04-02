package com.sumroch.spotme.activities.parkir.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.HistoryParkirAdapter;
import com.sumroch.spotme.models.db.HistoryParkir;
import com.sumroch.spotme.models.db.Profile;
import com.sumroch.spotme.activities.parkir.history.DetailParkirActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class BelumTanggapiFragment extends Fragment {
    public static final String TAG = "BelumTanggapiFragment";
    View rootView;
    @BindView(R.id.list_parkir_progress)
    ListView lvData;
    private int id;
     List<HistoryParkir> historyParkirList;
    public BelumTanggapiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_belum_tanggapi, container, false);
        ButterKnife.bind(this, rootView);
        historyParkirList = HistoryParkir.getData(Profile.findFirst().getName(),"Diparkir");
        if (historyParkirList != null && historyParkirList.size() > 0) {
            final HistoryParkirAdapter adapter = new HistoryParkirAdapter();
            adapter.setData(historyParkirList);
            lvData.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(View view, int i, int i1, int i2, int bottom, int i4, int i5, int i6, int old_bottom) {
                    ViewGroup.LayoutParams params = lvData.getLayoutParams();
                    params.height += bottom - old_bottom;
                    lvData.setLayoutParams(params);
                    lvData.requestLayout();
                }
            });

            lvData.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final String idx = historyParkirList.get(position).getIdParkir();
                    final String tanggal = historyParkirList.get(position).getWaktuMasuk();
                    final String plat = historyParkirList.get(position).getPlatNomor();
                    final String mobil = historyParkirList.get(position).getJenisKendaraan();
                    final String mall = historyParkirList.get(position).getNamaMall();
                    final String status = historyParkirList.get(position).getStatus();
                    Intent intent = new Intent(getActivity(), DetailParkirActivity.class);
                    intent.putExtra("id_parkir", idx);
                    intent.putExtra("tanggal", tanggal);
                    intent.putExtra("plat", plat);
                    intent.putExtra("mobil", mobil);
                    intent.putExtra("mall", mall);
                    intent.putExtra("status", status);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
            lvData.setAdapter(adapter);
        }
        return rootView;
    }
}
