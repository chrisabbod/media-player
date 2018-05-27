package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Media> media = new ArrayList<Media>();

        media.add(new Media("A Journey Through Grand Oceans", R.raw.a_journey_through_grand_oceans));
        media.add(new Media("All Gone, No Escape", R.raw.all_gone_no_escape));
        media.add(new Media("Anxious Heart", R.raw.anxious_heart));
        media.add(new Media("Because I Love You", R.raw.because_i_love_you));
        media.add(new Media("Burning the Clocktower", R.raw.burning_the_clocktower));
        media.add(new Media("Interrupted By Fireworks", R.raw.interrupted_by_fireworks));
        media.add(new Media("Jade Catacombs", R.raw.jade_catacombs));
        media.add(new Media("Liberi Fatali", R.raw.liberi_fatali));
        media.add(new Media("Ma Cherie Nicolette", R.raw.ma_cherie_nicolette));
        media.add(new Media("Mark of the Beatsmith", R.raw.mark_of_the_beatsmith));
        media.add(new Media("One Small Step", R.raw.one_small_step));
        media.add(new Media("Painful Memories", R.raw.painful_memories));
        media.add(new Media("Parasite Eve", R.raw.parasite_eve));
        media.add(new Media("Primal Perspective", R.raw.primal_perspective));
        media.add(new Media("Red Blue Sanctuary", R.raw.red_blue_sanctuary));
        media.add(new Media("The Beginning of the Fantasy", R.raw.the_beginning_of_the_fantasy));
        media.add(new Media("The Omen of Jenova", R.raw.the_omen_of_jenova));
        media.add(new Media("The Poem for Everyone's Soul", R.raw.the_poem_for_everyones_soul));
        media.add(new Media("Twoson Hits the Road", R.raw.twoson_hits_the_road));

        MediaAdapter adapter = new MediaAdapter(this, media);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int resID = media.get(i).getMediaId();
                mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                if(!mediaPlayer.isPlaying()){
                    Toast.makeText(MainActivity.this, "Stop Playing " + media.get(i).getMediaTitle(), Toast.LENGTH_LONG).show();
                    mediaPlayer.stop();
                }
                mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                Toast.makeText(MainActivity.this, "Is Playing: " + mediaPlayer.isPlaying(), Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });
        */
    }
}
