package com.example.ftcscouting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teams;
    private OnItemClickListener onItemClickListener;

    public TeamAdapter(List<Team> teams, OnItemClickListener onItemClickListener) {
        this.teams = teams;
        this.onItemClickListener = onItemClickListener;
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        public TextView teamNameTextView;
        public TextView notesTextView;
        public Button editButton;
        public Button deleteButton;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            notesTextView = itemView.findViewById(R.id.notesTextView);
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamNameTextView.setText(team.getName());

        // Format the notes for display
        StringBuilder notesBuilder = new StringBuilder();
        notesBuilder.append("Auto: ").append(team.isAuto() ? "Yes" : "No").append("\n");
        notesBuilder.append("Auto Specimens: ").append(team.getAutoSpecimens()).append("\n");
        notesBuilder.append("Auto Samples: ").append(team.getAutoSamples()).append("\n");
        notesBuilder.append("TeleOp: ").append(team.isTeleOp() ? "Yes" : "No").append("\n");
        notesBuilder.append("TeleOp Specimens: ").append(team.getTeleOpSpecimens()).append("\n");
        notesBuilder.append("TeleOp Samples: ").append(team.getTeleOpSamples()).append("\n");

        for (String note : team.getNotes()) {
            notesBuilder.append(" - ").append(note).append("\n");
        }
        holder.notesTextView.setText("Notes:\n" + notesBuilder.toString());

        holder.editButton.setOnClickListener(v -> onItemClickListener.onEditClick(position));
        holder.deleteButton.setOnClickListener(v -> onItemClickListener.onDeleteClick(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }
}
