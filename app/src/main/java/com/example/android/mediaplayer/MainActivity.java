package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static MediaPlayer mediaPlayer;
    public static int resID;
    public static String mediaTitle;
    public static int mediaPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton previousButton = findViewById(R.id.previous_button);
        ImageButton pauseButton = findViewById(R.id.pause_button);
        ImageButton stopButton = findViewById(R.id.stop_button);
        ImageButton playButton = findViewById(R.id.play_button);
        ImageButton nextButton = findViewById(R.id.next_button);
        final TextView mediaTitleTextView = findViewById(R.id.media_title_text_view);

        final ArrayList<Media> media = new ArrayList<>();
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

        resID = media.get(0).getMediaId();
        mediaTitle = media.get(0).getMediaTitle();
        mediaPlayer = MediaPlayer.create(MainActivity.this, media.get(0).getMediaId());  //initialize media player with the first song on list
        mediaTitleTextView.setText(media.get(0).getMediaTitle());

        //Setup adapter and bind view to listview activity
        MediaAdapter adapter = new MediaAdapter(this, media);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                mediaPosition = i;
                resID = media.get(mediaPosition).getMediaId();
                mediaTitle = media.get(mediaPosition).getMediaTitle();
                mediaTitleTextView.setText(mediaTitle);
                mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                //Toast.makeText(MainActivity.this, "Selected " + mediaTitle, Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Playing " + mediaTitle, Toast.LENGTH_SHORT).show();
                mediaTitleTextView.setText(mediaTitle);

                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                }
                mediaPlayer.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Stopped " + mediaTitle, Toast.LENGTH_SHORT).show();
                mediaTitleTextView.setText(" ");
                mediaPlayer.stop();
                releaseMediaPlayer();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Paused " + mediaTitle, Toast.LENGTH_SHORT).show();
                mediaTitleTextView.setText(mediaTitle);
                mediaPlayer.pause();
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

                if(mediaPosition < 1){
                    mediaPosition = media.size() - 1;
                }else{
                    mediaPosition--;
                }

                resID = media.get(mediaPosition).getMediaId();
                mediaTitle = media.get(mediaPosition).getMediaTitle();
                mediaTitleTextView.setText(mediaTitle);
                mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                mediaPlayer.start();
                //Toast.makeText(MainActivity.this, "Current Song " + mediaTitle, Toast.LENGTH_SHORT).show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    releaseMediaPlayer();
                    //Toast.makeText(MainActivity.this, "Released " + mediaTitle, Toast.LENGTH_SHORT).show();
                }

                if(mediaPosition >= media.size() - 1){
                    mediaPosition = 0;
                }else{
                    mediaPosition++;
                }

                resID = media.get(mediaPosition).getMediaId();
                mediaTitle = media.get(mediaPosition).getMediaTitle();
                mediaTitleTextView.setText(mediaTitle);
                mediaPlayer = MediaPlayer.create(MainActivity.this, resID);
                mediaPlayer.start();
                //Toast.makeText(MainActivity.this, "Current Song " + mediaTitle, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
