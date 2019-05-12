package com.example.exampleroom;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {
    private TextView textView;
    private Button button;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_delete_user, container, false);
       // textView = view.findViewById(R.id.et_delete);
        button = view.findViewById(R.id.delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int id = Integer.parseInt(textView.getText().toString());

               // String email = textView.getText().toString();

//
//                if (email.isEmpty()) {
//                    textView.setError("require to fill");
//                } else {
//
                  User user = new User();
//                    user.setEmail(email);
                    MainActivity.myAppDatabase.myDao().deleteUser();
                    Toast.makeText(getActivity(), "User deleted successfully", Toast.LENGTH_SHORT).show();
                   // textView.setText("");
                }

        });
        return view;
    }

}
