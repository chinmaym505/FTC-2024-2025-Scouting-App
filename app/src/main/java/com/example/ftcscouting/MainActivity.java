package com.example.ftcscouting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamAdapter.OnItemClickListener {

    private List<Team> teams;
    private RecyclerView teamRecyclerView;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teams = new ArrayList<>();
        EditText teamNameInput = findViewById(R.id.teamNameInput);
        RadioGroup autoRadioGroup = findViewById(R.id.autoRadioGroup);
        EditText autoSpecimensInput = findViewById(R.id.autoSpecimensInput);
        EditText autoSamplesInput = findViewById(R.id.autoSamplesInput);
        RadioGroup teleOpRadioGroup = findViewById(R.id.teleOpRadioGroup);
        EditText teleOpSpecimensInput = findViewById(R.id.teleOpSpecimensInput);
        EditText teleOpSamplesInput = findViewById(R.id.teleOpSamplesInput);
        Button saveButton = findViewById(R.id.saveButton);
        teamRecyclerView = findViewById(R.id.teamRecyclerView);

        teamAdapter = new TeamAdapter(teams, this);
        teamRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamRecyclerView.setAdapter(teamAdapter);

        autoRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.autoYes) {
                autoSpecimensInput.setVisibility(View.VISIBLE);
                autoSamplesInput.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.autoNo) {
                autoSpecimensInput.setVisibility(View.GONE);
                autoSamplesInput.setVisibility(View.GONE);
                autoSpecimensInput.setText("");
                autoSamplesInput.setText("");
            }
        });

        teleOpRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.teleOpYes) {
                teleOpSpecimensInput.setVisibility(View.VISIBLE);
                teleOpSamplesInput.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.teleOpNo) {
                teleOpSpecimensInput.setVisibility(View.GONE);
                teleOpSamplesInput.setVisibility(View.GONE);
                teleOpSpecimensInput.setText("");
                teleOpSamplesInput.setText("");
            }
        });

        saveButton.setOnClickListener(v -> {
            String teamName = teamNameInput.getText().toString();
            boolean auto = ((RadioButton) findViewById(autoRadioGroup.getCheckedRadioButtonId())).getText().toString().equals("Yes");
            int autoSpecimens = auto ? Integer.parseInt(autoSpecimensInput.getText().toString()) : 0;
            int autoSamples = auto ? Integer.parseInt(autoSamplesInput.getText().toString()) : 0;
            boolean teleOp = ((RadioButton) findViewById(teleOpRadioGroup.getCheckedRadioButtonId())).getText().toString().equals("Yes");
            int teleOpSpecimens = teleOp ? Integer.parseInt(teleOpSpecimensInput.getText().toString()) : 0;
            int teleOpSamples = teleOp ? Integer.parseInt(teleOpSamplesInput.getText().toString()) : 0;

            Team team = new Team(teamName, auto, autoSpecimens, autoSamples, teleOp, teleOpSpecimens, teleOpSamples, new ArrayList<>());
            teams.add(team);
            teamAdapter.notifyDataSetChanged();

            teamNameInput.setText("");
            autoRadioGroup.clearCheck();
            autoSpecimensInput.setText("");
            autoSamplesInput.setText("");
            autoRadioGroup.check(R.id.autoNo); // Set to No by default
            teleOpRadioGroup.clearCheck();
            teleOpSpecimensInput.setText("");
            teleOpSamplesInput.setText("");
            teleOpRadioGroup.check(R.id.teleOpNo); // Set to No by default
        });

        // Set the radio buttons to "No" by default on startup
        autoRadioGroup.check(R.id.autoNo);
        teleOpRadioGroup.check(R.id.teleOpNo);
    }

    @Override
    public void onEditAutoClick(int teamPosition) {
        Team team = teams.get(teamPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.edit_auto_dialog, null);
        builder.setView(dialogView);

        RadioGroup editAutoRadioGroup = dialogView.findViewById(R.id.editAutoRadioGroup);
        editAutoRadioGroup.check(team.isAuto() ? R.id.editAutoYes : R.id.editAutoNo);

        builder.setPositiveButton("Save", (dialog, which) -> {
            boolean autoEnabled = editAutoRadioGroup.getCheckedRadioButtonId() == R.id.editAutoYes;
            team.setAuto(autoEnabled);
            if (!autoEnabled) {
                team.setAutoSpecimens(0);
                team.setAutoSamples(0);
            }
            teamAdapter.notifyItemChanged(teamPosition);
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    @Override
    public void onEditTeleOpClick(int teamPosition) {
        Team team = teams.get(teamPosition);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.edit_teleop_dialog, null);
        builder.setView(dialogView);

        RadioGroup editTeleOpRadioGroup = dialogView.findViewById(R.id.editTeleOpRadioGroup);
        editTeleOpRadioGroup.check(team.isTeleOp() ? R.id.editTeleOpYes : R.id.editTeleOpNo);

        builder.setPositiveButton("Save", (dialog, which) -> {
            boolean teleOpEnabled = editTeleOpRadioGroup.getCheckedRadioButtonId() == R.id.editTeleOpYes;
            team.setTeleOp(teleOpEnabled);
            if (!teleOpEnabled) {
                team.setTeleOpSpecimens(0);
                team.setTeleOpSamples(0);
            }
            teamAdapter.notifyItemChanged(teamPosition);
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }

    @Override
    public void onDeleteTeamClick(int teamPosition) {
        teams.remove(teamPosition);
        teamAdapter.notifyItemRemoved(teamPosition);
        teamAdapter.notifyItemRangeChanged(teamPosition, teams.size());
    }
}
