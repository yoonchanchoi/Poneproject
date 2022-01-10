package com.example.poneproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag_number frag_number;
    private Frag_numberlist frag_numberlist;
    private Frag_recent frag_recent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//        Toolbar toolbar2 = (Toolbar)findViewById(R.id.toolbar2);
//
//        toolbar.setTitle(R.string.myAppName);
//        toolbar2.setTitle(R.string.myAppName2);
//        setSupportActionBar(toolbar);
//        setSupportActionBar(toolbar2);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            //해당 밀출코드가 deprecated된다는 내용이 안드로이드 developer에 없는 어케된건지..? 궁금
            //구글에 찾아보니깐 developer에는 나와있지 않은데 블로그글을 찾아보니 gihub에서 deprecated 되었다고 한다.
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {            //각각의 바텀 뷰의 메뉴 종류에 해당하는 frag를 연결
                switch (item.getItemId()){
                    case R.id.action_call:
                        setFrag(0);
                        break;
                    case R.id.action_list:
                        setFrag(1);
                        break;
                    case R.id.action_recent:
                        setFrag(2);
                        break;
                }

            }

        });


        frag_number = new Frag_number();
        frag_numberlist = new Frag_numberlist();
        frag_recent = new Frag_recent();
        setFrag(0);



    }

    private void setFrag(int n){
        fm =getSupportFragmentManager();                                                    //fm은 플래그를 관리하기 위한 플래그 메너저 생성
        ft = fm.beginTransaction();                                                         // beginTransction() 변경을 시작하는 메소드
        switch(n){
            case 0:
                ft.replace(R.id.main_frag,frag_number);                                          //기존 플래그먼트(화면)을 다른 플래그먼트로 바꾸는 첫번재 인자는 기존 플래그먼트 두번째 인자는 바뀔 플래그먼트
                ft.commit();                                                                //commit을 해줘야 갱신이 됩니다.
                break;
            case 1:
                ft.replace(R.id.main_frag,frag_numberlist);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frag,frag_recent);
                ft.commit();
                break;
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.appbar_menu,menu);
//        getMenuInflater().inflate(R.menu.appbar_menu2,menu);
////        return super.onCreateOptionsMenu(menu);
//        return true;
//    }



}