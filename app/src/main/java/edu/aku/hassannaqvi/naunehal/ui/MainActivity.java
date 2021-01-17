package edu.aku.hassannaqvi.naunehal.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section01HHActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section02CBActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section03CSActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section04IMActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section05PDActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section06BFActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section07CVActivity;
import edu.aku.hassannaqvi.naunehal.ui.sections.Section081SEActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);
        if (MainApp.admin)
            bi.admin.setVisibility(View.VISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_database:
                startActivity(new Intent(this, AndroidDatabaseManager.class));
                break;
            case R.id.action_data_sync:
                startActivity(new Intent(this, SyncActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    public void openForm(View view) {
        Intent oF = null;
        switch (view.getId()) {
            case R.id.startInterview:
                oF = new Intent(this, Section01HHActivity.class);
                break;
            case R.id.btn01:
                oF = new Intent(this, Section01HHActivity.class);
                break;
            case R.id.btn02:
                oF = new Intent(this, Section02CBActivity.class);
                break;
            case R.id.btn03:
                oF = new Intent(this, Section03CSActivity.class);
                break;
            case R.id.btn04:
                oF = new Intent(this, Section04IMActivity.class);
                break;
            case R.id.btn05:
                oF = new Intent(this, Section05PDActivity.class);
                break;
            case R.id.btn06:
                oF = new Intent(this, Section06BFActivity.class);
                break;
            case R.id.btn07:
                oF = new Intent(this, Section07CVActivity.class);
                break;
            case R.id.btn08:
                oF = new Intent(this, Section081SEActivity.class);
                break;
         /*   case R.id.formI:
                oF = new Intent(this, SectionI1Activity.class);
                break;
            case R.id.formJ:
                oF = new Intent(this, SectionJ1Activity.class);
                break;*/
        }
        startActivity(oF);
    }
}