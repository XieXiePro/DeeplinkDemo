package com.xp.pro.deeplinkdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);

        Intent intent = getIntent();
        if (intent != null && intent.getData() != null) {
            Uri uri = Uri.parse(intent.getData().toString());
            Toast.makeText(DeepLinkActivity.this, uri.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
