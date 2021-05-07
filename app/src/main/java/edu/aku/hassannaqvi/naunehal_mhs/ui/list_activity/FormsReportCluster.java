package edu.aku.hassannaqvi.naunehal_mhs.ui.list_activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.naunehal_mhs.R;
import edu.aku.hassannaqvi.naunehal_mhs.adapters.FormsAdapter;
import edu.aku.hassannaqvi.naunehal_mhs.database.DatabaseHelper;
import edu.aku.hassannaqvi.naunehal_mhs.models.MobileHealth;


public class FormsReportCluster extends AppCompatActivity {
    DatabaseHelper db;
    Collection<MobileHealth> fc;
    String sysdateToday = new SimpleDateFormat("dd-MM-yy").format(new Date());
    TextView dtFilter;
    TextView noresult;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter formsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms_report_cluster);
        recyclerView = findViewById(R.id.fc_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        dtFilter = findViewById(R.id.dtFilter);
        noresult = findViewById(R.id.noresult);
        db = new DatabaseHelper(this);
        fc = db.getFormsByCluster("0000000");

        // specify an adapter (see also next example)
        formsAdapter = new FormsAdapter((List<MobileHealth>) fc, this);
        recyclerView.setAdapter(formsAdapter);
    }

    public void filterForms(View view) {
        Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
        fc = db.getFormsByCluster(dtFilter.getText().toString());
        if (fc.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            noresult.setVisibility(View.GONE);
            formsAdapter = new FormsAdapter((List<MobileHealth>) fc, this);
            formsAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(formsAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            noresult.setVisibility(View.VISIBLE);
        }

    }
}