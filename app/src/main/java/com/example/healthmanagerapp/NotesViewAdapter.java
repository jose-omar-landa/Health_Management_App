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

public class NotesViewAdapter extends RecyclerView.Adapter<NotesViewAdapter.ViewHolder>{

    private ArrayList<NotesModal> notesModalArrayList;
    private Context context;

    public NotesViewAdapter(ArrayList<NotesModal> notesModalArrayList, Context context) {
        this.notesModalArrayList = notesModalArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotesModal modal = notesModalArrayList.get(position);
        holder.noteName.setText(modal.getName());
        holder.noteDate.setText(modal.getDate());
//        holder.noteContent.setText(modal.getContent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SingleViewNotePage.class);

                i.putExtra("name", modal.getName());
                i.putExtra("date", modal.getDate());
                i.putExtra("content", modal.getContent());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notesModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView noteName, noteDate, noteContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            noteName = itemView.findViewById(R.id.idTVnoteName);
            noteDate = itemView.findViewById(R.id.idTVnoteDate);
//            noteContent = itemView.findViewById(R.id.idTVnoteContent);

        }
    }
}




