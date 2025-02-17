package com.example.ftcscouting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
        CheckBox autoSamplesCheckbox = findViewById(R.id.autoSamplesCheckbox);
        RadioGroup autoSamplesRadioGroup = findViewById(R.id.autoSamplesRadioGroup);
        EditText autoSamplesInput = findViewById(R.id.autoSamplesInput);
        CheckBox autoSpecimensCheckbox = findViewById(R.id.autoSpecimensCheckbox);
        RadioGroup autoSpecimensRadioGroup = findViewById(R.id.autoSpecimensRadioGroup);
        EditText autoSpecimensInput = findViewById(R.id.autoSpecimensInput);
        RadioGroup autoParkingRadioGroup = findViewById(R.id.autoParkingRadioGroup);
        RadioGroup autoAscentLevelRadioGroup = findViewById(R.id.autoAscentLevelRadioGroup);
        RadioGroup teleOpRadioGroup = findViewById(R.id.teleOpRadioGroup);
        CheckBox teleOpSamplesCheckbox = findViewById(R.id.teleOpSamplesCheckbox);
        RadioGroup teleOpSamplesRadioGroup = findViewById(R.id.teleOpSamplesRadioGroup);
        EditText teleOpSamplesInput = findViewById(R.id.teleOpSamplesInput);
        CheckBox teleOpSpecimensCheckbox = findViewById(R.id.teleOpSpecimensCheckbox);
        RadioGroup teleOpSpecimensRadioGroup = findViewById(R.id.teleOpSpecimensRadioGroup);
        EditText teleOpSpecimensInput = findViewById(R.id.teleOpSpecimensInput);
        RadioGroup endGameAscentRadioGroup = findViewById(R.id.endGameAscentRadioGroup);
        RadioGroup endGameAscentLevelRadioGroup = findViewById(R.id.endGameAscentLevelRadioGroup);
        Button saveButton = findViewById(R.id.saveButton);
        teamRecyclerView = findViewById(R.id.teamRecyclerView);

        teamAdapter = new TeamAdapter(teams, this);
        teamRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamRecyclerView.setAdapter(teamAdapter);

        autoRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.autoYes) {
                autoSamplesCheckbox.setVisibility(View.VISIBLE);
                autoSpecimensCheckbox.setVisibility(View.VISIBLE);
                autoParkingRadioGroup.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.autoNo) {
                autoSamplesCheckbox.setVisibility(View.GONE);
                autoSpecimensCheckbox.setVisibility(View.GONE);
                autoSamplesRadioGroup.setVisibility(View.GONE);
                autoSamplesInput.setVisibility(View.GONE);
                autoSpecimensRadioGroup.setVisibility(View.GONE);
                autoSpecimensInput.setVisibility(View.GONE);
                autoParkingRadioGroup.setVisibility(View.GONE);
                autoAscentLevelRadioGroup.setVisibility(View.GONE);
                autoSamplesCheckbox.setChecked(false);
                autoSpecimensCheckbox.setChecked(false);
                autoSamplesRadioGroup.clearCheck();
                autoSamplesInput.setText("");
                autoSpecimensRadioGroup.clearCheck();
                autoSpecimensInput.setText("");
                autoParkingRadioGroup.clearCheck();
            }
        });

        autoSamplesCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                autoSamplesRadioGroup.setVisibility(View.VISIBLE);
                autoSamplesInput.setVisibility(View.VISIBLE);
            } else {
                autoSamplesRadioGroup.setVisibility(View.GONE);
                autoSamplesInput.setVisibility(View.GONE);
                autoSamplesRadioGroup.clearCheck();
                autoSamplesInput.setText("");
            }
        });

        autoSpecimensCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                autoSpecimensRadioGroup.setVisibility(View.VISIBLE);
                autoSpecimensInput.setVisibility(View.VISIBLE);
            } else {
                autoSpecimensRadioGroup.setVisibility(View.GONE);
                autoSpecimensInput.setVisibility(View.GONE);
                autoSpecimensRadioGroup.clearCheck();
                autoSpecimensInput.setText("");
            }
        });

        autoParkingRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.autoAscentRadio) {
                autoAscentLevelRadioGroup.setVisibility(View.VISIBLE);
            } else {
                autoAscentLevelRadioGroup.setVisibility(View.GONE);
                autoAscentLevelRadioGroup.clearCheck();
            }
        });

        teleOpRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.teleOpYes) {
                teleOpSamplesCheckbox.setVisibility(View.VISIBLE);
                teleOpSpecimensCheckbox.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.teleOpNo) {
                teleOpSamplesCheckbox.setVisibility(View.GONE);
                teleOpSpecimensCheckbox.setVisibility(View.GONE);
                teleOpSamplesRadioGroup.setVisibility(View.GONE);
                teleOpSamplesInput.setVisibility(View.GONE);
                teleOpSpecimensRadioGroup.setVisibility(View.GONE);
                teleOpSpecimensInput.setVisibility(View.GONE);
                teleOpSamplesCheckbox.setChecked(false);
                teleOpSpecimensCheckbox.setChecked(false);
                teleOpSamplesRadioGroup.clearCheck();
                teleOpSamplesInput.setText("");
                teleOpSpecimensRadioGroup.clearCheck();
                teleOpSpecimensInput.setText("");
            }
        });

        teleOpSamplesCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                teleOpSamplesRadioGroup.setVisibility(View.VISIBLE);
                teleOpSamplesInput.setVisibility(View.VISIBLE);
            } else {
                teleOpSamplesRadioGroup.setVisibility(View.GONE);
                teleOpSamplesInput.setVisibility(View.GONE);
                teleOpSamplesRadioGroup.clearCheck();
                teleOpSamplesInput.setText("");
            }
        });

        teleOpSpecimensCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                teleOpSpecimensRadioGroup.setVisibility(View.VISIBLE);
                teleOpSpecimensInput.setVisibility(View.VISIBLE);
            } else {
                teleOpSpecimensRadioGroup.setVisibility(View.GONE);
                teleOpSpecimensInput.setVisibility(View.GONE);
                teleOpSpecimensRadioGroup.clearCheck();
                teleOpSpecimensInput.setText("");
            }
        });

        endGameAscentRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.endGameAscentYesRadio) {
                endGameAscentLevelRadioGroup.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.endGameAscentNo) {
                endGameAscentLevelRadioGroup.setVisibility(View.GONE);
                endGameAscentLevelRadioGroup.clearCheck();
            }
        });

        saveButton.setOnClickListener(v -> {
            String teamName = teamNameInput.getText().toString();
            boolean auto = ((RadioButton) findViewById(autoRadioGroup.getCheckedRadioButtonId())).getText().toString().equals("Yes");
            boolean autoSamples = autoSamplesCheckbox.isChecked();
            int autoSamplesCount = autoSamples ? Integer.parseInt(autoSamplesInput.getText().toString()) : 0;
            boolean autoSpecimens = autoSpecimensCheckbox.isChecked();
            int autoSpecimensCount = autoSpecimens ? Integer.parseInt(autoSpecimensInput.getText().toString()) : 0;
            String autoSamplesType = autoSamples ? ((RadioButton) findViewById(autoSamplesRadioGroup.getCheckedRadioButtonId())).getText().toString() : "";
            String autoSpecimensType = autoSpecimens ? ((RadioButton) findViewById(autoSpecimensRadioGroup.getCheckedRadioButtonId())).getText().toString() : "";
            String autoParkingType;
            try{
                autoParkingType = ((RadioButton) findViewById(autoParkingRadioGroup.getCheckedRadioButtonId())).getText().toString();
            } catch (Exception e) {
                autoParkingType = "none";
            }
            int autoAscentLevel = 0;
            if (autoParkingType.equals("Ascent")) {
                String autoAscentLevelText = ((RadioButton) findViewById(autoAscentLevelRadioGroup.getCheckedRadioButtonId())).getText().toString();
                if (autoAscentLevelText.equals("Level 1")) {
                    autoAscentLevel = 1;
                } else if (autoAscentLevelText.equals("Level 2")) {
                    autoAscentLevel = 2;
                } else if (autoAscentLevelText.equals("Level 3")) {
                    autoAscentLevel = 3;
                }
                else {
                    autoAscentLevel = 0;
                }
            }

            boolean teleOp = ((RadioButton) findViewById(teleOpRadioGroup.getCheckedRadioButtonId())).getText().toString().equals("Yes");
            boolean teleOpSamples = teleOpSamplesCheckbox.isChecked();
            int teleOpSamplesCount = teleOpSamples ? Integer.parseInt(teleOpSamplesInput.getText().toString()) : 0;
            boolean teleOpSpecimens = teleOpSpecimensCheckbox.isChecked();
            int teleOpSpecimensCount = teleOpSpecimens ? Integer.parseInt(teleOpSpecimensInput.getText().toString()) : 0;
            String teleOpSamplesType;
            try {
                teleOpSamplesType = teleOpSamples ? ((RadioButton) findViewById(teleOpSamplesRadioGroup.getCheckedRadioButtonId())).getText().toString() : "";
            } catch (Exception e) {
                teleOpSamplesType = "none";
            }
                String teleOpSpecimensType = teleOpSpecimens ? ((RadioButton) findViewById(teleOpSpecimensRadioGroup.getCheckedRadioButtonId())).getText().toString() : "";

            boolean endGameAscent = ((RadioButton) findViewById(endGameAscentRadioGroup.getCheckedRadioButtonId())).getText().toString().equals("Yes");
            int endGameAscentLevel = 0;
            if (endGameAscent) {
                String endGameAscentLevelText = ((RadioButton) findViewById(endGameAscentLevelRadioGroup.getCheckedRadioButtonId())).getText().toString();
                if (endGameAscentLevelText.equals("Level 1")) {
                    endGameAscentLevel = 1;
                } else if (endGameAscentLevelText.equals("Level 2")) {
                    endGameAscentLevel = 2;
                } else if (endGameAscentLevelText.equals("Level 3")) {
                    endGameAscentLevel = 3;
                }
                else {
                    endGameAscentLevel = 0;
                }
            }

            Team team = new Team(teamName, auto, autoSamples, autoSamplesCount, autoSamplesType, autoSpecimens, autoSpecimensCount, autoSpecimensType, autoParkingType, autoAscentLevel, teleOp, teleOpSamples, teleOpSamplesCount, teleOpSamplesType, teleOpSpecimens, teleOpSpecimensCount, teleOpSpecimensType, endGameAscent, endGameAscentLevel, new ArrayList<>());
            teams.add(team);
            teamAdapter.notifyDataSetChanged();

            teamNameInput.setText("");
            autoRadioGroup.clearCheck();
            autoSamplesCheckbox.setChecked(false);
            autoSpecimensCheckbox.setChecked(false);
            autoSamplesRadioGroup.clearCheck();
            autoSamplesInput.setText("");
            autoSpecimensRadioGroup.clearCheck();
            autoSpecimensInput.setText("");
            autoParkingRadioGroup.clearCheck();
            autoAscentLevelRadioGroup.clearCheck();

            teleOpRadioGroup.clearCheck();
            teleOpSamplesCheckbox.setChecked(false);
            teleOpSpecimensCheckbox.setChecked(false);
            teleOpSamplesRadioGroup.clearCheck();
            teleOpSamplesInput.setText("");
            teleOpSpecimensRadioGroup.clearCheck();
            teleOpSpecimensInput.setText("");

            endGameAscentRadioGroup.clearCheck();
            endGameAscentLevelRadioGroup.clearCheck();
        });


        // Set the radio buttons to "No" by default on startup
        autoRadioGroup.check(R.id.autoNo);
        teleOpRadioGroup.check(R.id.teleOpNo);
        endGameAscentRadioGroup.check(R.id.endGameAscentNo);
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
                team.setAutoSamples(false);
                team.setAutoSamplesCount(0);
                team.setAutoSamplesType("");
                team.setAutoSpecimens(false);
                team.setAutoSpecimensCount(0);
                team.setAutoSpecimensType("");
                team.setAutoParkingType("");
                team.setAutoAscentLevel(0);
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
                team.setTeleOpSamples(false);
                team.setTeleOpSamplesCount(0);
                team.setTeleOpSamplesType("");
                team.setTeleOpSpecimens(false);
                team.setTeleOpSpecimensCount(0);
                team.setTeleOpSpecimensType("");
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
