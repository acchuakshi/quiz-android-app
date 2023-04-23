package com.example.intenship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    VideoView v1;
    Button b1;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.b2);
        v1=(VideoView)findViewById(R.id.v1);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(v1);
        v1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.cinderella);
        String setVideoPath = ("android.resource://" + getPackageName() + "/" + R.raw.cinderella);
        Uri uri=Uri.parse(setVideoPath);
        v1.setMediaController(mediaController);
        v1.setVideoURI(uri);
        v1.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"let us start the QUIZ",Toast.LENGTH_LONG).show();
                Intent ii=new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(ii);
            }
        });

    }
}