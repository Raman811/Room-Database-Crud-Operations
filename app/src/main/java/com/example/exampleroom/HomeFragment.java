package com.example.exampleroom;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button BtnAddUser,BtnReadUser,BtnDeleteUser,BtnUpdateUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BtnAddUser = view.findViewById(R.id.bn_add_user);
        BtnAddUser.setOnClickListener(this);

        BtnReadUser = view.findViewById(R.id.bn_view_users);
        BtnReadUser.setOnClickListener(this);

        BtnDeleteUser = view.findViewById(R.id.bn_delete_user);
        BtnDeleteUser.setOnClickListener(this);

        BtnUpdateUser = view.findViewById(R.id.bn_update_user);
        BtnUpdateUser.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()
                ).addToBackStack(null).commit();
                break;

            case R.id.bn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment()
                ).addToBackStack(null).commit();
                break;


            case R.id.bn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment()
                ).addToBackStack(null).commit();
                break;

            case R.id.bn_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateUserFragment()
                ).addToBackStack(null).commit();
                break;
        }
    }

//
//

    }

