package com.example.ftcscouting;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
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
        public LinearLayout endGameContainer;
        public CheckBox autoSamplesCheckbox;
        public RadioGroup autoSamplesRadioGroup;
        public EditText autoSamplesInput;
        public CheckBox autoSpecimensCheckbox;
        public RadioGroup autoSpecimensRadioGroup;
        public EditText autoSpecimensInput;
        public RadioGroup autoParkingRadioGroup;
        public RadioGroup autoAscentLevelRadioGroup;
        public CheckBox teleOpSamplesCheckbox;
        public RadioGroup teleOpSamplesRadioGroup;
        public EditText teleOpSamplesInput;
        public CheckBox teleOpSpecimensCheckbox;
        public RadioGroup teleOpSpecimensRadioGroup;
        public EditText teleOpSpecimensInput;
        public RadioGroup endGameAscentRadioGroup;
        public RadioGroup endGameAscentLevelRadioGroup;
        public Button autoToggleButton;
        public Button teleOpToggleButton;
        public Button endGameToggleButton;
        public Button editAutoButton;
        public Button editTeleOpButton;
        public Button deleteTeamButton;
        public TextView autoDisabledLabel;
        public TextView teleOpDisabledLabel;
        public ImageView teamDrawingImageView;

        public TeamViewHolder(View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            autoContainer = itemView.findViewById(R.id.autoContainer);
            teleOpContainer = itemView.findViewById(R.id.teleOpContainer);
            endGameContainer = itemView.findViewById(R.id.endGameContainer);
            autoSamplesCheckbox = itemView.findViewById(R.id.autoSamplesCheckbox);
            autoSamplesRadioGroup = itemView.findViewById(R.id.autoSamplesRadioGroup);
            autoSamplesInput = itemView.findViewById(R.id.autoSamplesInput);
            autoSpecimensCheckbox = itemView.findViewById(R.id.autoSpecimensCheckbox);
            autoSpecimensRadioGroup = itemView.findViewById(R.id.autoSpecimensRadioGroup);
            autoSpecimensInput = itemView.findViewById(R.id.autoSpecimensInput);
            autoParkingRadioGroup = itemView.findViewById(R.id.autoParkingRadioGroup);

            teleOpSamplesCheckbox = itemView.findViewById(R.id.teleOpSamplesCheckbox);
            teleOpSamplesRadioGroup = itemView.findViewById(R.id.teleOpSamplesRadioGroup);
            teleOpSamplesInput = itemView.findViewById(R.id.teleOpSamplesInput);
            teleOpSpecimensCheckbox = itemView.findViewById(R.id.teleOpSpecimensCheckbox);
            teleOpSpecimensRadioGroup = itemView.findViewById(R.id.teleOpSpecimensRadioGroup);
            teleOpSpecimensInput = itemView.findViewById(R.id.teleOpSpecimensInput);
            endGameAscentRadioGroup = itemView.findViewById(R.id.endGameAscentRadioGroup);
            endGameAscentLevelRadioGroup = itemView.findViewById(R.id.endGameAscentLevelRadioGroup);
            autoToggleButton = itemView.findViewById(R.id.autoToggleButton);
            teleOpToggleButton = itemView.findViewById(R.id.teleOpToggleButton);
            endGameToggleButton = itemView.findViewById(R.id.endGameToggleButton);
            editAutoButton = itemView.findViewById(R.id.editAutoButton);
            editTeleOpButton = itemView.findViewById(R.id.editTeleOpButton);
            deleteTeamButton = itemView.findViewById(R.id.deleteTeamButton);
            autoDisabledLabel = itemView.findViewById(R.id.autoDisabledLabel);
            teleOpDisabledLabel = itemView.findViewById(R.id.teleOpDisabledLabel);
            teamDrawingImageView = itemView.findViewById(R.id.teamDrawingImageView);
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
        Bitmap drawing = team.getDrawing();
        if (drawing != null) {
            Log.d("TeamAdapter", "Drawing found for team: " + team.getName());
            holder.teamDrawingImageView.setImageBitmap(drawing);
        } else {
            Log.d("TeamAdapter", "No drawing found for team: " + team.getName());
            holder.teamDrawingImageView.setImageResource(R.drawable.field);
        }

        // Auto Section
        if (team.isAuto()) {
            holder.autoDisabledLabel.setVisibility(View.GONE);
            holder.autoSamplesCheckbox.setVisibility(View.VISIBLE);
            holder.autoSpecimensCheckbox.setVisibility(View.VISIBLE);
            holder.autoParkingRadioGroup.setVisibility(View.VISIBLE);
            holder.itemView.setVisibility(View.VISIBLE);

            holder.autoSamplesCheckbox.setChecked(team.isAutoSamples());
            holder.autoSamplesRadioGroup.setVisibility(team.isAutoSamples() ? View.VISIBLE : View.GONE);
            holder.autoSamplesInput.setVisibility(team.isAutoSamples() ? View.VISIBLE : View.GONE);
            holder.autoSamplesInput.setText(String.valueOf(team.getAutoSamplesCount()));

            holder.autoSpecimensCheckbox.setChecked(team.isAutoSpecimens());
            holder.autoSpecimensRadioGroup.setVisibility(team.isAutoSpecimens() ? View.VISIBLE : View.GONE);
            holder.autoSpecimensInput.setVisibility(team.isAutoSpecimens() ? View.VISIBLE : View.GONE);
            holder.autoSpecimensInput.setText(String.valueOf(team.getAutoSpecimensCount()));

            if (team.getAutoParkingType().equals("Ascent")) {
                holder.autoParkingRadioGroup.check(R.id.autoAscentRadio);
            } else if (team.getAutoParkingType().equals("Parking")) {
                holder.autoParkingRadioGroup.check(R.id.autoParkingRadio);
            } else {
                holder.autoParkingRadioGroup.check(R.id.autoNoneRadio);
            }
        } else {
            holder.autoDisabledLabel.setVisibility(View.VISIBLE);
            holder.itemView.setVisibility(View.GONE);
            holder.autoSamplesCheckbox.setVisibility(View.GONE);
            holder.autoSpecimensCheckbox.setVisibility(View.GONE);
            holder.autoSamplesRadioGroup.setVisibility(View.GONE);
            holder.autoSamplesInput.setVisibility(View.GONE);
            holder.autoSpecimensRadioGroup.setVisibility(View.GONE);
            holder.autoSpecimensInput.setVisibility(View.GONE);
            holder.autoParkingRadioGroup.setVisibility(View.GONE);

        }

        // TeleOP Section
        if (team.isTeleOp()) {
            holder.teleOpDisabledLabel.setVisibility(View.GONE);
            holder.teleOpSamplesCheckbox.setVisibility(View.VISIBLE);
            holder.teleOpSpecimensCheckbox.setVisibility(View.VISIBLE);

            holder.teleOpSamplesCheckbox.setChecked(team.isTeleOpSamples());
            holder.teleOpSamplesRadioGroup.setVisibility(team.isTeleOpSamples() ? View.VISIBLE : View.GONE);
            holder.teleOpSamplesInput.setVisibility(team.isTeleOpSamples() ? View.VISIBLE : View.GONE);
            holder.teleOpSamplesInput.setText(String.valueOf(team.getTeleOpSamplesCount()));

            holder.teleOpSpecimensCheckbox.setChecked(team.isTeleOpSpecimens());
            holder.teleOpSpecimensRadioGroup.setVisibility(team.isTeleOpSpecimens() ? View.VISIBLE : View.GONE);
            holder.teleOpSpecimensInput.setVisibility(team.isTeleOpSpecimens() ? View.VISIBLE : View.GONE);
            holder.teleOpSpecimensInput.setText(String.valueOf(team.getTeleOpSpecimensCount()));
        } else {
            holder.teleOpDisabledLabel.setVisibility(View.VISIBLE);
            holder.teleOpSamplesCheckbox.setVisibility(View.GONE);
            holder.teleOpSpecimensCheckbox.setVisibility(View.GONE);
            holder.teleOpSamplesRadioGroup.setVisibility(View.GONE);
            holder.teleOpSamplesInput.setVisibility(View.GONE);
            holder.teleOpSpecimensRadioGroup.setVisibility(View.GONE);
            holder.teleOpSpecimensInput.setVisibility(View.GONE);
        }

        // End Game Section
        if (team.isEndGameAscent()) {
            holder.endGameAscentRadioGroup.check(R.id.endGameAscentYesRadio);
            holder.endGameAscentLevelRadioGroup.setVisibility(View.VISIBLE);
            int endGameAscentLevelRadioId;
            switch (team.getEndGameAscentLevel()) {
                case 1: endGameAscentLevelRadioId = R.id.endGameAscentLevel1Radio; break;
                case 2: endGameAscentLevelRadioId = R.id.endGameAscentLevel2Radio; break;
                case 3: endGameAscentLevelRadioId = R.id.endGameAscentLevel3Radio; break;
                default: endGameAscentLevelRadioId = -1;
            }
            holder.endGameAscentLevelRadioGroup.check(endGameAscentLevelRadioId);
        } else {
            holder.endGameAscentRadioGroup.check(R.id.endGameAscentNo);
            holder.endGameAscentLevelRadioGroup.setVisibility(View.GONE);
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

        holder.endGameToggleButton.setOnClickListener(v -> {
            if (holder.endGameContainer.getVisibility() == View.GONE) {
                holder.endGameContainer.setVisibility(View.VISIBLE);
                holder.endGameToggleButton.setText("End Game ▲");
            } else {
                holder.endGameContainer.setVisibility(View.GONE);
                holder.endGameToggleButton.setText("End Game ▼");
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
