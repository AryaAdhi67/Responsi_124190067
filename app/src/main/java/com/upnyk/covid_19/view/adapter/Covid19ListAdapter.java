package com.upnyk.covid_19.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid_19.R;
import com.upnyk.covid_19.view.covid19.pojo.ContentItem;

import java.util.List;

public class Covid19ListAdapter extends RecyclerView.Adapter<Covid19ListAdapter.ViewHolder> {

    List<ContentItem> listCovid19;
    Context context;

    public Covid19ListAdapter(List<ContentItem> listCovid19, Context context) {
        this.listCovid19 = listCovid19;
        this.context = context;
    }

    public void setCovid19List(List<ContentItem> listCovid19) {
        this.listCovid19 = listCovid19;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.covid19_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Covid19ListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listCovid19.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTanggal, tvTerkonfirmasi, tvSembuh, tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvTerkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
        }

        public void bind(int position) {
            tvTanggal.setText(listCovid19.get(position).getTanggal());
            tvTerkonfirmasi.setText(String.valueOf(listCovid19.get(position).getConfirmationDiisolasi()));
            tvSembuh.setText(String.valueOf(listCovid19.get(position).getConfirmationSelesai()));
            tvMeninggal.setText(String.valueOf(listCovid19.get(position).getConfirmationMeninggal()));
        }
    }
}
