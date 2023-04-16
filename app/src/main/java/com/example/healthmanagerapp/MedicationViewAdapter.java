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

public class MedicationViewAdapter extends RecyclerView.Adapter<MedicationViewAdapter.ViewHolder> {

    private ArrayList<MedicationsModal> medicationsModalArrayList;
    private Context context;

    public MedicationViewAdapter(ArrayList<MedicationsModal> medicationsModalArrayList, Context context) {
        this.medicationsModalArrayList = medicationsModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medications_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicationsModal modal = medicationsModalArrayList.get(position);
        holder.medName.setText(modal.getName());
        holder.medDose.setText(modal.getDose());
        holder.timeTaken.setText(modal.getTimeTaken());
        holder.prescribedBy.setText(modal.getPrescribedBy());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SingleViewMedicationPage.class);

                i.putExtra("name", modal.getName());
                i.putExtra("dosage", modal.getDose());
                i.putExtra("time", modal.getTimeTaken());
                i.putExtra("prescribedBy", modal.getPrescribedBy());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicationsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView medName, medDose, timeTaken, prescribedBy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            medName = itemView.findViewById(R.id.idTVMedName);
            medDose = itemView.findViewById(R.id.idTVMedDose);
            timeTaken = itemView.findViewById(R.id.idTVTimeTaken);
            prescribedBy = itemView.findViewById(R.id.idTVPrescribedBy);

        }
    }
}
