package sg.edu.rp.c346.id20006949.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class SongList extends AppCompatActivity {
    Spinner spinner2;
    ArrayList<Song> al;
    ListView lv;
    ArrayAdapter<Song> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        DBHelper db = new DBHelper(SongList.this);
        lv = findViewById(R.id.lv);
        al = new ArrayList<Song>();
        al = db.getAllSong();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SongList.this,
                        SongDetails.class);
                i.putExtra("data", data);
                startActivity(i);
            }
        });
        }
    }