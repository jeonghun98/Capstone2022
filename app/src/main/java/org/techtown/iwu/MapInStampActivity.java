package org.techtown.iwu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// Stamp 화면 내의 2D MAP 스탬프 현황 보는 Activity

public class MapInStampActivity extends AppCompatActivity {
    FrameLayout stampinmap;
    int userBuilding;

    //[ay.han] 2/25 : bx_stamp 관련 - 앞서 구현된 부분 & DB가 int 기준으로 작성되어있어서 아래 legacy code(boolean b1_stamp = false~)를 주석처리함. 논의필요
    //[ay.han] 2/25 : stampsele --> stamp0 으로 변경

    /* [ay.han] legacy code 주석처리
    // DB에서 user의 building stamp 데이터 가져올 예정 (초깃값은 false로 스탬프가 비어있도록 해두었음)
    boolean b1_stamp = false, b2_stamp = false, b6_stamp = false,b11_stamp = false,b12_stamp = false,b17_stamp = false;
    boolean b18_stamp = false, b24_stamp = false, b30_stamp = false,b31_stamp = false,b32_stamp = false, b_sele_stamp = false;
    */

    String userID;
    int b1_stamp, b2_stamp, b6_stamp, b11_stamp, b12_stamp,b17_stamp,b18_stamp,b24_stamp,b30_stamp,b31_stamp,b32_stamp,b0_stamp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super .onCreate(savedInstanceState);

        Intent intent = getIntent();
        userBuilding = intent.getIntExtra("u_Building", 15);
        userID = intent.getStringExtra("u_id"); // [ay.han] u_id 받기

        b1_stamp = intent.getIntExtra("b1_stamp", 0); //[ay.han] StampActivity에서 bx_stamp 값 받아옴
        b1_stamp = intent.getIntExtra("b1_stamp", 0);
        b2_stamp = intent.getIntExtra("b2_stamp", 0);
        b6_stamp = intent.getIntExtra("b6_stamp", 0);
        b11_stamp = intent.getIntExtra("b11_stamp", 0);
        b12_stamp = intent.getIntExtra("b12_stamp", 0);
        b17_stamp = intent.getIntExtra("b17_stamp", 0);
        b18_stamp = intent.getIntExtra("b18_stamp", 0);
        b24_stamp = intent.getIntExtra("b24_stamp", 0);
        b30_stamp = intent.getIntExtra("b30_stamp", 0);
        b31_stamp = intent.getIntExtra("b31_stamp", 0);
        b32_stamp = intent.getIntExtra("b32_stamp", 0);
        b0_stamp = intent.getIntExtra("b0_stamp", 0);

        setContentView(R.layout.activity_mapinstamp); // stamp내의 map 실행
        stampinmap = (FrameLayout) findViewById(R.id.mapframe); // mapframe 받아오기 (이 위에 좌표 표시)
        stampinmap.addView(new PointView(this));

    }

    private class PointView extends View { // 좌표 찍는(그리는) class
        Paint paint = new Paint();

        public PointView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap img1 = BitmapFactory.decodeResource(getResources(), R.drawable.flag); // flag 그림으로 찍기 위한 설정
            Bitmap img0 = BitmapFactory.decodeResource(getResources(), R.drawable.flag0);
            Bitmap bigimg1 = Bitmap.createScaledBitmap(img1, img1.getWidth()/16, img1.getHeight()/16, false); // 그림 설정
            Bitmap bigimg0 = Bitmap.createScaledBitmap(img0, img0.getWidth()/16, img0.getHeight()/16, false);
            //bigima1 체크 스탬프, bigima0 비어있는 스탬프

            Bitmap stamp1, stamp2, stamp6, stamp11, stamp12, stamp17, stamp18, stamp24, stamp30, stamp31, stamp32, stamp0;

            /* legacy code 주석처리
            //체크 되어있는 스탬프            //비어있는 스탬프
            if(b1_stamp) stamp1 = bigimg1; else stamp1 = bigimg0;
            if(b2_stamp) stamp2 = bigimg1; else stamp2 = bigimg0;
            if(b6_stamp) stamp6 = bigimg1; else stamp6 = bigimg0;
            if(b11_stamp) stamp11 = bigimg1; else stamp11 = bigimg0;
            if(b12_stamp) stamp12 = bigimg1; else stamp12 = bigimg0;
            if(b17_stamp) stamp17 = bigimg1; else stamp17 = bigimg0;
            if(b18_stamp) stamp18 = bigimg1; else stamp18 = bigimg0;
            if(b24_stamp) stamp24 = bigimg1; else stamp24 = bigimg0;
            if(b30_stamp) stamp30 = bigimg1; else stamp30 = bigimg0;
            if(b31_stamp) stamp31 = bigimg1; else stamp31 = bigimg0;
            if(b32_stamp) stamp32 = bigimg1; else stamp32 = bigimg0;
            if(b_sele_stamp) stampsele = bigimg1; else stampsele = bigimg0;
             */

            //체크 되어있는 스탬프            //비어있는 스탬프
            if(b1_stamp ==1) stamp1 = bigimg1; else stamp1 = bigimg0;
            if(b2_stamp ==1) stamp2 = bigimg1; else stamp2 = bigimg0;
            if(b6_stamp ==1) stamp6 = bigimg1; else stamp6 = bigimg0;
            if(b11_stamp ==1) stamp11 = bigimg1; else stamp11 = bigimg0;
            if(b12_stamp ==1) stamp12 = bigimg1; else stamp12 = bigimg0;
            if(b17_stamp ==1) stamp17 = bigimg1; else stamp17 = bigimg0;
            if(b18_stamp ==1) stamp18 = bigimg1; else stamp18 = bigimg0;
            if(b24_stamp ==1) stamp24 = bigimg1; else stamp24 = bigimg0;
            if(b30_stamp ==1) stamp30 = bigimg1; else stamp30 = bigimg0;
            if(b31_stamp ==1) stamp31 = bigimg1; else stamp31 = bigimg0;
            if(b32_stamp ==1) stamp32 = bigimg1; else stamp32 = bigimg0;
            if(b0_stamp ==1) stamp0 = bigimg1; else stamp0 = bigimg0;

            canvas.drawBitmap(stamp1, 727, 820, paint); // 1호관 위치에 스탬프 찍기
            canvas.drawBitmap(stamp2, 790, 700, paint); // 2호관
            canvas.drawBitmap(stamp6, 449, 853, paint); // 6호관 + 위치 조정함
            canvas.drawBitmap(stamp11, 365, 530, paint); // 11호관
            canvas.drawBitmap(stamp12, 485, 610, paint); // 12호관
            canvas.drawBitmap(stamp17, 386, 357, paint); // 17호관 + 위치 조정함
            canvas.drawBitmap(stamp18, 326,203, paint); // 18호관 + 위치 조정함
            canvas.drawBitmap(stamp24, 617, 1180, paint); // 24호관 + 위치 조정함
            canvas.drawBitmap(stamp30, 255, 1020, paint); // 30호관
            canvas.drawBitmap(stamp31, 105, 555, paint); // 미유(31)
            canvas.drawBitmap(stamp32, 123, 135, paint); // 솔찬공원(32)

            if (userBuilding == 5) canvas.drawBitmap(stamp0, 545, 980, paint); // 5호관
            else if (userBuilding == 7) canvas.drawBitmap(stamp0, 335, 795, paint); // 7호관
            else if (userBuilding == 8) canvas.drawBitmap(stamp0, 235, 695, paint); // 8호관
            else if (userBuilding == 13) canvas.drawBitmap(stamp0, 644, 702, paint); // 13 호관
            else if (userBuilding == 14) canvas.drawBitmap(stamp0, 680, 600, paint); // 14 호관
            else if (userBuilding == 15) canvas.drawBitmap(stamp0, 540, 478, paint); // 15 호관
            else if (userBuilding == 16) canvas.drawBitmap(stamp0, 430, 400, paint); // 16 호관
            else if (userBuilding == 20) canvas.drawBitmap(stamp0, 480, 150, paint); // 20 호관
                //else if (userBuilding == 23) canvas.drawBitmap(stamp0, 606, 1220, paint); // 23호관 강당(userBuilding 없어서 일단 제외함)
            else if (userBuilding == 28) canvas.drawBitmap(stamp0, 0, 670, paint); // 28호관
            else if (userBuilding == 29) canvas.drawBitmap(stamp0, 105, 555, paint); // 29호관
        }
    }
}