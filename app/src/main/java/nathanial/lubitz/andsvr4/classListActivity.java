package nathanial.lubitz.andsvr4;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Nate on 4/24/2017.
 */

public class classListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        ListView myList = (ListView) findViewById(R.id.classList);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Bundle bund = getIntent().getExtras();
        final Cursor res = db.getQuickSearch(bund.getString("Value"));
        ArrayList<String> ClassList = new ArrayList<>();
        if (res.getCount() > 0){
        while(res.moveToNext()) {
            ClassList.add(new Class(res.getString(0), res.getString(1), res.getString(2), res.getString(3), (res.getString(4) + " " + res.getString(5))).toString());
        }}
        else
            ClassList.add("No Data Found! :(");
        ArrayAdapter<String> arrayAdapt= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ClassList);
        myList.setAdapter(arrayAdapt);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                res.moveToPosition(position);
                Intent myTent = new Intent(classListActivity.this, singleClassViewActivity.class);
                myTent.putExtra("Val", res.getString(0));
                startActivity(myTent);
            }
        });
    }
}
