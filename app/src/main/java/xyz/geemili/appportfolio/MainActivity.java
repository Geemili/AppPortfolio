package xyz.geemili.appportfolio;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the layout so that we can stick the project buttons in it
        LinearLayout projectBox = (LinearLayout) findViewById(R.id.projectBox);

        // Get the list of projects
        String[] projects = getResources().getStringArray(R.array.projects);
        for (final String project: projects) {
            // Make a new button
            Button projectButton = new Button(this);
            projectButton.setText(project);
            // Make a message pop up
            projectButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "This will open \"" + project + "\"", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            // Add the button to the box
            projectBox.addView(projectButton);
        }
    }
}
