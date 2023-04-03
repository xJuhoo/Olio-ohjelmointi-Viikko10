package com.example.application;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private String currentDegree;

    private Button buttonAddUser;

    private CheckBox cbCandidate;
    private CheckBox cbMasterOfScience;
    private CheckBox cbDoctor;
    private  CheckBox cbSwimmer;

    private int image;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        emailInput = findViewById(R.id.emailInput);
        cbCandidate = findViewById(R.id.cbCandidate);
        cbMasterOfScience = findViewById(R.id.cbMasterOfScience);
        cbDoctor = findViewById(R.id.cbDoctor);
        cbSwimmer = findViewById(R.id.cbSwimmer);
        buttonAddUser = findViewById(R.id.btnAddUser);

        context = this;
    }

    public void addUser(View view) {
        ArrayList<String> completedDegrees = new ArrayList<>();

        // Get the current degree
        RadioGroup rgDegreeType = findViewById(R.id.degreeProgramInput);

        switch (rgDegreeType.getCheckedRadioButtonId()) {
            case R.id.rbTite:
                currentDegree = "Tietotekniikka";
                break;

            case R.id.rbTuta:
                currentDegree = "Tuotantotalous";
                break;

            case R.id.rbLate:
                currentDegree = "Laskennallinen tekniikka";
                break;

            case R.id.rbSate:
                currentDegree = "Sähkötekniikka";
                break;
        }

        // Get the profile picture
        RadioGroup profilePicture = findViewById(R.id.rbProfilePicture);

        switch (profilePicture.getCheckedRadioButtonId()) {
            case R.id.rbDiamond:
                image = R.drawable.diamond;
                break;

            case R.id.rbRuby:
                image = R.drawable.ruby;
                break;

            case R.id.rbEmerald:
                image = R.drawable.emerald;
                break;
        }

        // Get completed degrees
        if (cbCandidate.isChecked()) {
            completedDegrees.add("Kandidaatin tutkinto");
        }
        if (cbMasterOfScience.isChecked()) {
            completedDegrees.add("Diplomi-insinöörin tutkinto");
        }
        if (cbDoctor.isChecked()) {
            completedDegrees.add("Tekniikan tohtorin tutkinto");
        }
        if (cbSwimmer.isChecked()) {
            completedDegrees.add("Uimamaisteri");
        }

        // Create new user
        User user = new User(firstNameInput.getText().toString(), lastNameInput.getText().toString(), emailInput.getText().toString(), currentDegree, image, completedDegrees);

        UserStorage.getInstance().addUser(user);
        // Everytime user is added we save the list
        UserStorage.getInstance().saveUsers(context);
    }
}