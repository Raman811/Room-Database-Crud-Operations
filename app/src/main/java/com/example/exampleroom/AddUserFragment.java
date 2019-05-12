package com.example.exampleroom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
    public EditText id, name, email;
    public Button save;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        id = view.findViewById(R.id.txt_userid);
        name = view.findViewById(R.id.txt_name);
        email = view.findViewById(R.id.txt_email);
        save = view.findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // int userid = Integer.parseInt(id.getText().toString());
                String username = name.getText().toString();
                String useremail = email.getText().toString();


                if (username.isEmpty()){
                    name.setError("require to fill");
                }
                else if (useremail.isEmpty()){
                    email.setError("require to fill");
                }
                else {

                    User user = new User();
                    // user.setId(userid);
                    user.setName(username);
                    user.setEmail(useremail);

                    MainActivity.myAppDatabase.myDao().addUser(user);
                    Toast.makeText(getActivity(), "user added successfully", Toast.LENGTH_SHORT).show();

                    id.setText("");
                    name.setText("");
                    email.setText("");

                }
            }
        });


        return view;

    }

    }


