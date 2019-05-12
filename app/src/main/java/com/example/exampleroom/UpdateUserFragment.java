package com.example.exampleroom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {
    private EditText id,name,email;
    private Button update;


    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update_user, container, false);

        id = view.findViewById(R.id.txt_userid);
        name = view.findViewById(R.id.txt_name);
        email = view.findViewById(R.id.txt_email);
        update = view.findViewById(R.id.bn_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userid = Integer.parseInt(id.getText().toString());
                String username = name.getText().toString();
                String useremail = email.getText().toString();

                    if (username.isEmpty()) {
                        name.setError("required");
                    } else if (useremail.isEmpty()) {
                        email.setError("required");
                    } else {
                        User user = new User();
                        user.setId(userid);
                        user.setName(username);
                        user.setEmail(useremail);

                        MainActivity.myAppDatabase.myDao().updateUser(user);
                        Toast.makeText(getActivity(), "user updated successfully", Toast.LENGTH_SHORT).show();
                        id.setText("");
                        name.setText("");
                        email.setText("");

                    }

                }

        });

        return view;
    }

}
