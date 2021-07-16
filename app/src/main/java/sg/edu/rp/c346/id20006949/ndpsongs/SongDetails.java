package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SongDetails extends AppCompatActivity {
    Button update, delete,cancel;
    TextView title,singers,year,stars;
    EditText editsong, editsingers,edityear,editid;
    RadioGroup radiogroup;
    Song data;
    RadioButton radio1, radio2, radio3, radio4, radio5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        cancel = findViewById(R.id.cancel);
        title = findViewById(R.id.title);
        singers = findViewById(R.id.singers);
        year = findViewById(R.id.year);
        stars = findViewById(R.id.stars);
        editid= findViewById(R.id.editid);
        editsong= findViewById(R.id.editsong);
        editsingers = findViewById(R.id.editsingers);
        edityear = findViewById(R.id.edityear);
        radiogroup = findViewById(R.id.radiogroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3= findViewById(R.id.radio3);
        radio4= findViewById(R.id.radio4);
        radio5= findViewById(R.id.radio5);
        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");
        editid.setText(data.getId()+"");
        editsong.setText(data.getTitle());
        editsingers.setText(data.getSingers());
        edityear.setText(data.getYear())+"");

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(SongDetails.this);

                if (TextUtils.isEmpty(editsong.getText().toString()) || (TextUtils.isEmpty(editsingers.getText().toString()) || (TextUtils.isEmpty(edityear.getText().toString()) || (radiogroup.getCheckedRadioButtonId()==-1)))){
                    Toast.makeText(SongDetails.this, "Empty field not allowed !",
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
                    Toast.makeText(SongDetails.this,
                            "Update successful",
                            Toast.LENGTH_SHORT).show();
                    db.insertSong(songname, singersname, yearsint, numberstars);
                }

            }
        });
        delete.setOnClickListener(new View.OnClickListener){
            @Override
                    public void onClick(View v){
                DBHelper
            }
        }
    }
}