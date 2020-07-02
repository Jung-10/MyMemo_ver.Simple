package com.professionalandroid.apps.mymemoversimple;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFile {
    // 메모 내용을 저장할 파일 이름
    private static final String FILE_NAME = "memo.txt";

    Context Context = null;

    public TextFile(Context context) {
        Context = context;
    }

    // 파일에 메모를 저장
    public void save(String stringData) {
        if( stringData == null || stringData.equals("") ) {
            return;
        }

        FileOutputStream fileoutputMemo = null;

        try {
            // 파일에 데이터를 작성할 수 있게 하는 것 생성
            fileoutputMemo = Context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);

            // 파일에 메모 작성
            fileoutputMemo.write( stringData.getBytes() );
            fileoutputMemo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 저장된 메모를 불러오기
    public String load() {
        try {
            // 파일에서 데이터를 읽을 수 있게 하는 것 생성
            FileInputStream fileinputMemo = Context.openFileInput(FILE_NAME);

            // 데이터를 읽고 반환
            byte[] memoData = new byte[fileinputMemo.available()];
            while (fileinputMemo.read(memoData) != -1) { }

            return new String(memoData);
        } catch (IOException e) {  }

        return "";
    }

    // 저장된 메모를 삭제하는 함수
    public void delete() {
        Context.deleteFile(FILE_NAME);
    }
}
