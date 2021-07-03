package com.upnyk.covid_19.view.rs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.upnyk.covid_19.R;
import com.upnyk.covid_19.view.adapter.Covid19ListAdapter;
import com.upnyk.covid_19.view.adapter.RumahSakitListAdapter;
import com.upnyk.covid_19.view.covid19.Covid19ViewModel;

import java.util.ArrayList;

public class RumahSakitFragment extends Fragment {


    ProgressBar progressBar;
    RecyclerView rvRumahSakit;
    RumahSakitListAdapter rumahSakitListAdapter;
    RumahSakitViewModel rumahSakitViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rumah_sakit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar_rumah_sakit);
        rvRumahSakit = view.findViewById(R.id.rv_rumah_sakit);
        rumahSakitListAdapter = new RumahSakitListAdapter(new ArrayList<>(), getActivity());
        rumahSakitViewModel = new ViewModelProvider(this).get(RumahSakitViewModel.class);

        rvRumahSakit.setAdapter(rumahSakitListAdapter);
        rvRumahSakit.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        rvRumahSakit.setHasFixedSize(true);

        rumahSakitViewModel.getListRumahSakit().observe(requireActivity(), dataItems -> {
            rumahSakitListAdapter.setListRumahSakit(dataItems);
            rumahSakitListAdapter.notifyDataSetChanged();

            if (dataItems.size() > 0){
                progressBar.setVisibility(View.INVISIBLE);
            } else {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        rumahSakitViewModel.obtainRumahSakitList();
    }
}