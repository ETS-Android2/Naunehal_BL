package edu.aku.hassannaqvi.naunehal.ui.sections;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.naunehal.R;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.databinding.ActivityIdentificationSectionBindingImpl;

/*** IDENTIFICATION SECTION  --No DataBinding in this section.
 *
 *  only identification fields will be displayed on this sections
 *  Such as; Province, District, UC, Cluster & Household Number.
 *
 *  On btnContinue database will be queried for matching result in database. (Logically, only one result should be found, complete or not)
 *
 *   NO saveDraft() and updateDB() functions will be executed in identification section.
 *   IMPORTANT!: Only formValidation() will be executed
 *
 */

public class IdentificationSectionActivity extends AppCompatActivity {

    ActivityIdentificationSectionBindingImpl bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_identification_section);

        /** Line below is the first change you see due to DataBinding **/
        bi.setForm(MainApp.form);  // Identification section it will be used only for view binding

        setSupportActionBar(bi.toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            MainApp.hideSystemUI(getWindow().getDecorView());
        }
    }


}