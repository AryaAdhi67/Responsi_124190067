package com.upnyk.covid_19.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upnyk.covid_19.R;
import com.upnyk.covid_19.view.rs.pojo.DataItem;

import java.util.List;

public class RumahSakitListAdapter extends RecyclerView.Adapter<RumahSakitListAdapter.ViewHolder> {

    List<DataItem> listRumahSakit;
    Context context;

    public RumahSakitListAdapter(List<DataItem> listRumahSakit, Context context) {
        this.listRumahSakit = listRumahSakit;
        this.context = context;
    }

    public void setListRumahSakit(List<DataItem> listRumahSakit) {
        this.listRumahSakit = listRumahSakit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rumah_sakit_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RumahSakitListAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listRumahSakit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

        public void bind(int position) {
            tvNama.setText(listRumahSakit.get(position).getNama());
            tvAlamat.setText(listRumahSakit.get(position).getAlamat());
            btnMaps.setOnClickListener(v -> {
                String address = String.format("geo: 0, 0?q= %s", listRumahSakit.get(position).getNama());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
                intent.setPackage("com.google.android.apps.maps");
                context.startActivity(intent);
            });
        }
    }
}
