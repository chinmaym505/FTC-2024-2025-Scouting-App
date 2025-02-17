package com.example.ftcscouting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
        public EditText autoSpecimensInput;
        public EditText autoSamplesInput;
        public EditText teleOpSpecimensInput;
        public EditText teleOpSamplesInput;
        public Button editAutoButton;
        public Button editTeleOpButton;
        public Button deleteTeamButton;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            autoSpecimensInput = itemView.findViewById(R.id.autoSpecimensInput);
            autoSamplesInput = itemView.findViewById(R.id.autoSamplesInput);
            teleOpSpecimensInput = itemView.findViewById(R.id.teleOpSpecimensInput);
            teleOpSamplesInput = itemView.findViewById(R.id.teleOpSamplesInput);
            editAutoButton = itemView.findViewById(R.id.editAutoButton);
            editTeleOpButton = itemView.findViewById(R.id.editTeleOpButton);
            deleteTeamButton = itemView.findViewById(R.id.deleteTeamButton);
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

        if (team.isAuto()) {
            holder.autoSpecimensInput.setVisibility(View.VISIBLE);
            holder.autoSamplesInput.setVisibility(View.VISIBLE);
            holder.autoSpecimensInput.setText(String.valueOf(team.getAutoSpecimens()));
            holder.autoSamplesInput.setText(String.valueOf(team.getAutoSamples()));
        } else {
            holder.autoSpecimensInput.setVisibility(View.GONE);
            holder.autoSamplesInput.setVisibility(View.GONE);
            holder.autoSpecimensInput.setText("0");
            holder.autoSamplesInput.setText("0");
        }

        if (team.isTeleOp()) {
            holder.teleOpSpecimensInput.setVisibility(View.VISIBLE);
            holder.teleOpSamplesInput.setVisibility(View.VISIBLE);
            holder.teleOpSpecimensInput.setText(String.valueOf(team.getTeleOpSpecimens()));
            holder.teleOpSamplesInput.setText(String.valueOf(team.getTeleOpSamples()));
        } else {
            holder.teleOpSpecimensInput.setVisibility(View.GONE);
            holder.teleOpSamplesInput.setVisibility(View.GONE);
            holder.teleOpSpecimensInput.setText("0");
            holder.teleOpSamplesInput.setText("0");
        }

        holder.editAutoButton.setOnClickListener(v -> onItemClickListener.onEditAutoClick(position));
        holder.editTeleOpButton.setOnClickListener(v -> onItemClickListener.onEditTeleOpClick(position));
        holder.deleteTeamButton.setOnClickListener(v -> onItemClickListener.onDeleteTeamClick(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public interface OnItemClickListener {
        void onEditAutoClick(int teamPosition);
        void onEditTeleOpClick(int teamPosition);
        void onDeleteTeamClick(int teamPosition);
    }
}
