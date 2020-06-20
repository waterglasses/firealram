package com.example.firealramex;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton caller = (ImageButton)findViewById(R.id.caller_button);
        //caller.setOnClickListener((View.OnClickListener) this);

        caller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //인텐트 아직 배우지 않았다. 하지만 꼭 필요한 부분이다. 메인 페이지에서 다른 페이지생성 및 전환이 필요할때 사용하는 객체이다.
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:119"));        //Uri 를 이용하여 전화를 거는기능
                startActivity((mIntent));
            }
        });

        //FCM
        FirebaseMessaging.getInstance().subscribeToTopic("Test");

        Intent intent = getIntent();
        if(intent != null) {
            //푸시알림을 선택해서 실행한것이 아닌경우 예외처리
            String notificationData = intent.getStringExtra("test");
            if(notificationData != null)
                Log.d("Firebase", notificationData);
        }
    }
}