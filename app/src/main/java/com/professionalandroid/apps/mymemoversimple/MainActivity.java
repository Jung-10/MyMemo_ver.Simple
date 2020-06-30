package com.professionalandroid.apps.mymemoversimple;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.text.SimpleDateFormat;

    public class MainActivity extends AppCompatActivity {

        EditText mMemoEdit = null;
        TextFile mTextFileManager = new TextFile(this);
        // 현재시간을 current에 저장
        long current = System.currentTimeMillis();

        // 현재시간을 date 변수에 저장
        Date date = new Date(current);

        // 메모장 앱에 들어간 시간 => 출력방식: yyyy.MM.dd HH:mm:ss
        SimpleDateFormat SimpleDateFormat_current = new SimpleDateFormat("메모장에 들어온 시간 : " + "yyyy.MM.dd HH:mm:ss");

        // 변수에 값을 저장
        String formatDate = SimpleDateFormat_current.format(date);

        TextView date_current;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            date_current = (TextView) findViewById(R.id.date_current);
            date_current.setText(formatDate);

            mMemoEdit = (EditText) findViewById(R.id.memo_edit);
        }

        public void onClick(View v) {
            switch (v.getId()) {
                // 저장한 메모 파일로 불러오기
                case R.id.buttonload: {
                    String memoData = mTextFileManager.load();
                    mMemoEdit.setText(memoData);

                    Toast.makeText(this, "불러오기 실행 완료", Toast.LENGTH_LONG).show();
                    break;
                }

                // 입력한 메모 내용을 파일로 저장하기
                case R.id.buttonsave: {
                    String memoData = mMemoEdit.getText().toString();
                    mTextFileManager.save(memoData);
                    mMemoEdit.setText("");

                    Toast.makeText(this, "저장 실행 완료", Toast.LENGTH_LONG).show();
                    break;
                }

                // 저장된 메모 파일 삭제하기
                case R.id.buttondelete: {
                    mTextFileManager.delete();
                    mMemoEdit.setText("");

                    Toast.makeText(this, "삭제 실행 완료", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}