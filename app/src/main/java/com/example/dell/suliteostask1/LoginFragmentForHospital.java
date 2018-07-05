package com.example.dell.suliteostask1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragmentForHospital extends Fragment {

    EditText hosname,hospassword;
    Button Hoslogin;
    boolean flag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.login_activity_for_hospital,container,false);

        hosname = view.findViewById(R.id.HospitalLoginName);
        hospassword = view.findViewById(R.id.HospitalLoginPassword);
        Hoslogin = view.findViewById(R.id.LoginHospital);

        hospassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length()>0)
                {
                    if (!passwordvalidate(s))
                    {
                        flag = false;
                    }
                    else
                        flag = true;
                }

            }
        });

        Hoslogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = hosname.getText().toString().trim();
                if (nam.length()>0 && flag)
                {
                    Toast.makeText(getActivity(), "Login Successfully", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getActivity(), "Login UnSuccessfull", Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

    private boolean passwordvalidate(CharSequence s) {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
