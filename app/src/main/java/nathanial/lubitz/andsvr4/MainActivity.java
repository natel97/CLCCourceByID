package nathanial.lubitz.andsvr4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.search);
        final EditText courseNum = (EditText)findViewById(R.id.searchByID);
        btn.setOnClickListener(
                new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                Intent myTent = new Intent(MainActivity.this, classListActivity.class);
                myTent.putExtra("Value", courseNum.getText().toString());
                startActivity(myTent);
            }
        });
    }
}
