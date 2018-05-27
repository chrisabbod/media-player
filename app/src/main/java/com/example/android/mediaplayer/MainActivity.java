package com.example.android.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Media> media = new ArrayList<Media>();

        media.add(new Media("A Journey Through Grand Oceans", R.raw.a_journey_through_grand_oceans));
        media.add(new Media("All Gone, No Escape", R.raw.all_gone_no_escape));
        media.add(new Media("Anxious Heart", R.raw.anxious_heart));
        media.add(new Media("Because I Love You", R.raw.because_i_love_you));
        media.add(new Media("Burning the Clocktower", R.raw.burning_the_clocktower));
        media.add(new Media("Interrupted By Fireworks", R.raw.interrupted_by_fireworks));
        media.add(new Media("Jade Catacombs", R.raw.dragonfood));
        media.add(new Media("Liberi Fatali", R.raw.dragonfood));
        media.add(new Media("Ma Cherie Nicolette", R.raw.dragonfood));
        media.add(new Media("Mark of the Beatsmith", R.raw.dragonfood));
        media.add(new Media("One Small Step", R.raw.dragonfood));
        media.add(new Media("Painful Memories", R.raw.dragonfood));
        media.add(new Media("Parasite Eve", R.raw.dragonfood));
        media.add(new Media("Primal Perspective", R.raw.dragonfood));
        media.add(new Media("Red Blue Sanctuary", R.raw.dragonfood));
        media.add(new Media("The Beginning of the Fantasy", R.raw.dragonfood));
        media.add(new Media("The Omen of Jenova", R.raw.dragonfood));
        media.add(new Media("The Poem for Everyone's Soul", R.raw.dragonfood));
        media.add(new Media("Twoson Hits the Road", R.raw.dragonfood));

        MediaAdapter adapter = new MediaAdapter(this, media);
        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}
