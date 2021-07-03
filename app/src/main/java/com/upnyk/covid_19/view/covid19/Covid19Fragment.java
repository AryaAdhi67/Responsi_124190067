package com.upnyk.covid_19.view.covid19;

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

import java.util.ArrayList;

public class Covid19Fragment extends Fragment {

    ProgressBar progressBar;
    RecyclerView rvCovid19;
    Covid19ListAdapter covid19ListAdapter;
    Covid19ViewModel covid19ViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_covid19, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar_covid19);
        rvCovid19 = view.findViewById(R.id.rv_covid19);
        covid19ListAdapter = new Covid19ListAdapter(new ArrayList<>(), getActivity());
        covid19ViewModel = new ViewModelProvider(this).get(Covid19ViewModel.class);

        rvCovid19.setAdapter(covid19ListAdapter);
        rvCovid19.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, true));
        rvCovid19.setHasFixedSize(true);

        covid19ViewModel.getListCovid19().observe(requireActivity(), contentItems -> {
            covid19ListAdapter.setCovid19List(contentItems);
            covid19ListAdapter.notifyDataSetChanged();
            rvCovid19.scrollToPosition(covid19ListAdapter.getItemCount()-1);

            if (contentItems.size() > 0){
                progressBar.setVisibility(View.INVISIBLE);
            } else {
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        covid19ViewModel.obtainCovid19List();
    }
}