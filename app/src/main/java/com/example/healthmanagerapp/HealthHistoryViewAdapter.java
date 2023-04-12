package com.example.healthmanagerapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SingleViewHealthHistory.class);

                i.putExtra("probName", modal.getHealthProblem());
                i.putExtra("diagDate", modal.getDiagnosedDate());
                i.putExtra("diagnosedBy", modal.getDiagnosedBy());
                i.putExtra("otherInfo", modal.getOtherInfo());

                context.startActivity(i);
            }
        });


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
