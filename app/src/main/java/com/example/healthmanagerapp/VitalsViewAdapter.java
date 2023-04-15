package com.example.healthmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VitalsViewAdapter extends RecyclerView.Adapter<VitalsViewAdapter.ViewHolder> {

    private ArrayList<VitalsModal> vitalsModalArrayList;
    private Context context;

    public VitalsViewAdapter(ArrayList<VitalsModal> vitalsModalArrayList, Context context) {
        this.vitalsModalArrayList = vitalsModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vitals_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VitalsModal modal = vitalsModalArrayList.get(position);
        holder.vitalsDate.setText(modal.getDate());
        holder.bloodPressure.setText(modal.getBloodPressure());
        holder.heartRate.setText(modal.getHeartRate());
        holder.otherSymptoms.setText(modal.getOtherSymptoms());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SingleViewVitalsPage.class);

                i.putExtra("date", modal.getDate());
                i.putExtra("bloodPressure", modal.getBloodPressure());
                i.putExtra("heartRate", modal.getHeartRate());
                i.putExtra("otherSymptoms", modal.getOtherSymptoms());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vitalsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView vitalsDate, bloodPressure, heartRate, otherSymptoms;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            vitalsDate = itemView.findViewById(R.id.idTVvitalsDate);
            bloodPressure = itemView.findViewById(R.id.idTVBloodPressure);
            heartRate = itemView.findViewById(R.id.idTVHeartRate);
            otherSymptoms = itemView.findViewById(R.id.idTVOtherSymptoms);

        }
    }




}
