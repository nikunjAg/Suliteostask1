package com.example.dell.suliteostask1;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class LoginFragmentForUser extends Fragment{

    EditText EmailId,loginpassword;
    Button login;
    boolean flag,flag2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.login_activity_for_user,container,false);

        EmailId = view.findViewById(R.id.LoginEmailId);
        loginpassword = view.findViewById(R.id.LoginPassword);

        login = view.findViewById(R.id.LoginUser);

        EmailId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0)
                {
                    if(!emailValidation(s))
                    {
                        flag = false;
                        EmailId.setError("wrong EmailId");
                    }
                    else
                        flag = true;
                }

            }
        });

        loginpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.length()>0)
                {
                    if (!passwordvalidate(s))
                    {
                        flag2 = false;
                        loginpassword.setError("Enter According to the given constraints");

                    }
                    else
                    {
                        flag2 = true;
                    }
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag && flag2)
                {
                    Toast.makeText(getActivity(), "Login Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private boolean emailValidation(CharSequence s)
    {
        Pattern pattern1 = Pattern.compile( "^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+");

        Matcher matcher1 = pattern1.matcher(s);

        return matcher1.matches();

    }

    private boolean passwordvalidate(CharSequence s) {

        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }




}
