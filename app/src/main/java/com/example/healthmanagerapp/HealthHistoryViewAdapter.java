package com.example.healthmanagerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HealthHistoryViewAdapter extends RecyclerView.Adapter<HealthHistoryViewAdapter.ViewHolder> {

    private ArrayList<HealthHistoryModal> healthHistoryModalArrayList;
    private Context context;

    public HealthHistoryViewAdapter(ArrayList<HealthHistoryModal> healthHistoryModalArrayList, Context context) {
        this.healthHistoryModalArrayList = healthHistoryModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_hist_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HealthHistoryModal modal = healthHistoryModalArrayList.get(position);
        holder.problemName.setText(modal.getHealthProblem());
        holder.diagDate.setText(modal.getDiagnosedDate());
        holder.diagBy.setText(modal.getDiagnosedBy());
        holder.otherInfo.setText(modal.getOtherInfo());
    }

    @Override
    public int getItemCount() {
        return healthHistoryModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView problemName, diagDate, diagBy, otherInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            problemName = itemView.findViewById(R.id.idTVproblemName);
            diagDate = itemView.findViewById(R.id.idTVdiagDate);
            diagBy = itemView.findViewById(R.id.idTVdiagBy);
            otherInfo = itemView.findViewById(R.id.idTVotherInfo);

        }
    }
}
