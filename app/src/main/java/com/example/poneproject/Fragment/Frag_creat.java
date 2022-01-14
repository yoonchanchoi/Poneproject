package com.example.poneproject.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.poneproject.R;


public class Frag_creat extends Fragment {

    private EditText et_ponumber;
    private EditText et_name;
    private View view;
    private Button btn_complete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.frag_creat, container, false);
        //return inflater.inflate(R.layout.frag_creat, container, false);

        et_name=view.findViewById(R.id.et_name);
        et_ponumber=view.findViewById(R.id.et_ponumber);
        btn_complete =view.findViewById(R.id.btn_complete);

        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", et_name.getText().toString());
                bundle.putString("ponumber", et_ponumber.getText().toString());
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                Frag_numberlist frag_numberlist = new Frag_numberlist();
                frag_numberlist.setArguments(bundle);
                transaction.replace(R.id.creat_frag, frag_numberlist);
                transaction.commit();
            }
        });


        return view;
    }


}