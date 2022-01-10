package com.example.poneproject;

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

public class Frag_numberlist extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_numberlist, container, false);
        setHasOptionsMenu(true);// 옵션메뉴를 가지고 있겟다(즉 아래거를 가지고 있겠다)
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.myAppName);
        MainActivity activity = (MainActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) { //옵션메뉴형식
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.appbar_menu, menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(requireContext(), "검색1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_create:
                //메뉴내용
                Toast.makeText(requireContext(), "생성", Toast.LENGTH_SHORT).show(); //requirecontext()//현재 context값을 가져온다.?or
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}