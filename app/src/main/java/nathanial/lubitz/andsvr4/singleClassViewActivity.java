package nathanial.lubitz.andsvr4;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nate on 5/1/2017.
 */

public class singleClassViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        ListView myList = (ListView) findViewById(R.id.classList);
        String id = getIntent().getExtras().getString("Val");
        DatabaseHelper db = new DatabaseHelper(this);

        final Cursor res = db.searchFromDatabase(id);
        ArrayList<String> Info = new ArrayList<>();
        res.moveToFirst();

        Info.add("Class ID: " + res.getString(0));
        Info.add("Subject: " + res.getString(1));
        Info.add("Class Title: " + res.getString(2));
        Info.add("Class Number: " + res.getString(3));
        Info.add("Section: " + res.getString(4));
        Info.add("Dates: " + res.getString(5));
        Info.add("Days: " + res.getString(6));
        Info.add("Time: " + res.getString(7));
        Info.add("Credits: " + res.getString(8));
        Info.add("Status: " + res.getString(9));
        Info.add("Tuition cost(Approx): " + res.getString(10));
        Info.add("Campus: " + res.getString(11));
        Info.add("Semester: " + res.getString(12));
        Info.add("Instructor: " + res.getString(13) + " " + res.getString(14));

        ArrayAdapter<String> arrayAdapt= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Info);
        myList.setAdapter(arrayAdapt);
    }
}
