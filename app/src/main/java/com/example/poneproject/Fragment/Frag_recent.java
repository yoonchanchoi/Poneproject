package com.example.poneproject.Fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.poneproject.MainActivity;
import com.example.poneproject.R;

public class Frag_recent extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_recent, container, false);
        setHasOptionsMenu(true);// 옵션메뉴를 가지고 있겟다(즉 아래거를 가지고 있겠다)
        Toolbar toolbar2 = view.findViewById(R.id.toolbar2);            //activity는 화면의 한종류!! 4대컴퍼넌트 액티비티, 브로드개시리시버, 서비스, 컨텐트리시버
        toolbar2.setTitle(R.string.myAppName2);
        MainActivity activity2 = (MainActivity) getActivity();
        activity2.setSupportActionBar(toolbar2);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {//옵션메뉴형식
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.appbar_menu2, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search2:
                Toast.makeText(requireContext(), "검색2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
