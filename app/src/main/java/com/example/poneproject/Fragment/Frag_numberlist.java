package com.example.poneproject.Fragment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poneproject.DataModel.Numberlist_Adapter;
import com.example.poneproject.DataModel.Numberlist_Data;
import com.example.poneproject.MainActivity;
import com.example.poneproject.R;

import java.util.ArrayList;

public class Frag_numberlist extends Fragment {

    private View view;
//    private static final int REQUEST_CODE 777;
    private ArrayList<Numberlist_Data> arrayList;
    private Numberlist_Adapter numberlist_adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag_creat frag_creat;
    private String name;
    private String ponumber;
    private TextView numberlist_name;
    private TextView numberlist_ponumber;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_numberlist, container, false);
        setHasOptionsMenu(true);// 옵션메뉴를 가지고 있겟다(즉 아래거를 가지고 있겠다)
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.myAppName);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);



//        name= getArguments().getString("name");
//        ponumber= getArguments().getString("ponumber");
//
//        Numberlist_Data numberlist_data = new Numberlist_Data(R.drawable.ic_baseline_person_24,name,ponumber);
//        arrayList.add(numberlist_data);
//        numberlist_adapter.notifyDataSetChanged();








        recyclerView= (RecyclerView)view.findViewById(R.id.rv);
        linearLayoutManager=new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();
        numberlist_adapter = new Numberlist_Adapter(arrayList);
        recyclerView.setAdapter(numberlist_adapter);




        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) { //옵션메뉴형식
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.appbar_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        frag_creat = new Frag_creat();
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(requireContext(), "검색1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_create:
                //메뉴내용 생성
                fm = getActivity().getSupportFragmentManager();                                                    //fm은 플래그를 관리하기 위한 플래그 메너저 생성
                ft = fm.beginTransaction();                                                         // beginTransction() 변경을 시작하는 메소드
                        ft.replace(R.id.numberlist_frag, frag_creat);
                        ft.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
                }


//                Intent intent = new Intent(this.getContext(), Frag_recent.class);
//                startActivityForResult(intent, REQUEST_CODE);
//                 //requirecontext()//현재 context값을 가져온다.?or

    }


}
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode == RESULT_OK){
////            Toast.makeText(this.getContext(), "수신 성공", Toast.LENGTH_SHORT).show();
//
//        }else{
//            Toast.makeText(this.getContext(), "수신 실패", Toast.LENGTH_SHORT).show();
//        }
//
////        if(requestCode == REQUEST_CODE){
////            String resultTxt =data.getStringExtra("comeback");
////            tv_comback.setText(resultTxt);
////        }
//    }
