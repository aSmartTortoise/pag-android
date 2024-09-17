package com.tencent.libpag.sample.libpag_sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.libpag.PAGFile;
import org.libpag.PAGView;


public class StudyPAGActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "StudyPAGActivity";

    private PAGView pagView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_pag);
        pagView = findViewById(R.id.pag);
        Button btnListening = findViewById(R.id.btn_listening);
        Button btnSpeaking = findViewById(R.id.btn_speaking);
        btnListening.setOnClickListener(this);
        btnSpeaking.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        PAGFile pagFile = null;
        switch (v.getId()) {
            case R.id.btn_listening:
                pagFile = PAGFile.Load(getAssets(), "vpa_voice_listening_online.pag");
                break;
            case R.id.btn_speaking:
                pagFile = PAGFile.Load(getAssets(), "vpa_voice_speaking_online.pag");
                break;
        }
        if (pagFile != null) {
            pagView.setComposition(pagFile);
            pagView.setRepeatCount(0);
            pagView.play();
            int width = pagFile.width();
            int height = pagFile.height();
            Log.d(TAG, "onClick pag File, width:" + width + " height:" + height);
        }
    }
}