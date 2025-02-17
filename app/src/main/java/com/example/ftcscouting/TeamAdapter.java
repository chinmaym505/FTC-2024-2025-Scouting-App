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
        public LinearLayout autoContainer;
        public LinearLayout teleOpContainer;
        public EditText autoSpecimensInput;
        public EditText autoSamplesInput;
        public EditText teleOpSpecimensInput;
        public EditText teleOpSamplesInput;
        public Button autoToggleButton;
        public Button teleOpToggleButton;
        public Button editAutoButton;
        public Button editTeleOpButton;
        public Button deleteTeamButton;
        public TextView autoDisabledLabel;
        public TextView teleOpDisabledLabel;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            autoContainer = itemView.findViewById(R.id.autoContainer);
            teleOpContainer = itemView.findViewById(R.id.teleOpContainer);
            autoSpecimensInput = itemView.findViewById(R.id.autoSpecimensInput);
            autoSamplesInput = itemView.findViewById(R.id.autoSamplesInput);
            teleOpSpecimensInput = itemView.findViewById(R.id.teleOpSpecimensInput);
            teleOpSamplesInput = itemView.findViewById(R.id.teleOpSamplesInput);
            autoToggleButton = itemView.findViewById(R.id.autoToggleButton);
            teleOpToggleButton = itemView.findViewById(R.id.teleOpToggleButton);
            editAutoButton = itemView.findViewById(R.id.editAutoButton);
            editTeleOpButton = itemView.findViewById(R.id.editTeleOpButton);
            deleteTeamButton = itemView.findViewById(R.id.deleteTeamButton);
            autoDisabledLabel = itemView.findViewById(R.id.autoDisabledLabel);
            teleOpDisabledLabel = itemView.findViewById(R.id.teleOpDisabledLabel);
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
            holder.autoDisabledLabel.setVisibility(View.GONE);
            holder.autoSpecimensInput.setVisibility(View.VISIBLE);
            holder.autoSamplesInput.setVisibility(View.VISIBLE);
            holder.autoSpecimensInput.setText(String.valueOf(team.getAutoSpecimens()));
            holder.autoSamplesInput.setText(String.valueOf(team.getAutoSamples()));
        } else {
            holder.autoDisabledLabel.setVisibility(View.VISIBLE);
            holder.autoSpecimensInput.setVisibility(View.GONE);
            holder.autoSamplesInput.setVisibility(View.GONE);
        }

        if (team.isTeleOp()) {
            holder.teleOpDisabledLabel.setVisibility(View.GONE);
            holder.teleOpSpecimensInput.setVisibility(View.VISIBLE);
            holder.teleOpSamplesInput.setVisibility(View.VISIBLE);
            holder.teleOpSpecimensInput.setText(String.valueOf(team.getTeleOpSpecimens()));
            holder.teleOpSamplesInput.setText(String.valueOf(team.getTeleOpSamples()));
        } else {
            holder.teleOpDisabledLabel.setVisibility(View.VISIBLE);
            holder.teleOpSpecimensInput.setVisibility(View.GONE);
            holder.teleOpSamplesInput.setVisibility(View.GONE);
        }

        holder.autoToggleButton.setOnClickListener(v -> {
            if (holder.autoContainer.getVisibility() == View.GONE) {
                holder.autoContainer.setVisibility(View.VISIBLE);
                holder.autoToggleButton.setText("Auto ▲");
            } else {
                holder.autoContainer.setVisibility(View.GONE);
                holder.autoToggleButton.setText("Auto ▼");
            }
        });

        holder.teleOpToggleButton.setOnClickListener(v -> {
            if (holder.teleOpContainer.getVisibility() == View.GONE) {
                holder.teleOpContainer.setVisibility(View.VISIBLE);
                holder.teleOpToggleButton.setText("TeleOP ▲");
            } else {
                holder.teleOpContainer.setVisibility(View.GONE);
                holder.teleOpToggleButton.setText("TeleOP ▼");
            }
        });

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
