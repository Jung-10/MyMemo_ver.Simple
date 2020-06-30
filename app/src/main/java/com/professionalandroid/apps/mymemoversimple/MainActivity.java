package com.professionalandroid.apps.mymemoversimple;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    EditText MemoEdit = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MemoEdit = (EditText) findViewById(R.id.memo_edit);

    }

}