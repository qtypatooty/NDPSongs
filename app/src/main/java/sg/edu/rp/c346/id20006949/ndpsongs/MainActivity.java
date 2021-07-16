package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button insert, show;
    TextView title,singers,year,stars;
    EditText editsong, editsingers,edityear;
    RadioGroup radiogroup;
    RadioButton radio1, radio2, radio3, radio4, radio5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.update);
        show = findViewById(R.id.show);
        title = findViewById(R.id.title);
        singers = findViewById(R.id.singers);
        year = findViewById(R.id.year);
        stars = findViewById(R.id.stars);
        editsong= findViewById(R.id.editsong);
        editsingers = findViewById(R.id.editsingers);
        edityear = findViewById(R.id.edityear);
        radiogroup = findViewById(R.id.radiogroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3= findViewById(R.id.radio3);
        radio4= findViewById(R.id.radio4);
        radio5= findViewById(R.id.radio5);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                if (TextUtils.isEmpty(editsong.getText().toString()) || (TextUtils.isEmpty(editsingers.getText().toString()) || (TextUtils.isEmpty(edityear.getText().toString()) || (radiogroup.getCheckedRadioButtonId()==-1)))){
                    Toast.makeText(MainActivity.this, "Empty field not allowed !",
                            Toast.LENGTH_SHORT).show();
                }else{
                    String songname = editsong.getText().toString();
                    String singersname = editsingers.getText().toString();
                    String yearsint = edityear.getText().toString();
                    String numberstars = "";
                    if (radio1.isChecked()){
                        numberstars= "1";
                    }else if(radio2.isChecked()){
                        numberstars = "2";
                    }else if(radio3.isChecked()){
                        numberstars="3";
                    }else if(radio4.isChecked()){
                        numberstars="4";
                    }else if(radio5.isChecked()){
                        numberstars="5";
                    }

                    editsong.setText("");
                    editsingers.setText("");
                    edityear.setText("");
                    radiogroup.clearCheck();
                    Toast.makeText(MainActivity.this,
                            "Insert successful",
                            Toast.LENGTH_SHORT).show();
                   long result = db.insertSong(songname, singersname, yearsint, numberstars);
                }

            }
        });
        show.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SongList.class);
                startActivity(intent);
            }
        });


    }

}