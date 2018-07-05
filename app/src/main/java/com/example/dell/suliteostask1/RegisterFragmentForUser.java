package com.example.dell.suliteostask1;

import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFragmentForUser extends Fragment{

    public EditText donorname, Email, phoneno, Address, Age, Weight, BloodType, lastDate, password;
    public Button register;
    private boolean flag,flag1,flag2,flag3,flag4,flag5,flag6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_activity_for_user,container,false);

        donorname = view.findViewById(R.id.name);
        Email = view.findViewById(R.id.Email);
        phoneno = view.findViewById(R.id.Phone);
        Address = view.findViewById(R.id.Address);
        Age = view.findViewById(R.id.age);
        Weight = view.findViewById(R.id.weight);
        BloodType = view.findViewById(R.id.BloodType);
        lastDate = view.findViewById(R.id.whenLastDonated);
        password = view.findViewById(R.id.Password);

        register = view.findViewById(R.id.register);

        password.addTextChangedListener(new TextWatcher() {
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
                    if (!validatePassword(s))
                    {
                        flag6 = false;
                         password.setError("Enter According to the given constraints");
                    }
                    else {
                        flag6 = true;
                    }
                }

            }
        });

        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    if(!emailValidator(s)){
                        flag2 = false;
                        Email.setError("Please Enter Valid Email!");
                    }
                    else
                    {
                        flag2 = true;
                    }
                }
            }
        });     // set
        phoneno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() > 0){
                    if(!phoneValidator(s)){
                        flag3 = false;
                        phoneno.setError("Please Enter Valid number!");
                    }
                    else
                    {
                        flag3 = true;
                    }
                }
            }
        });     // set
        BloodType.addTextChangedListener(new TextWatcher() {
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
                    if (!bloodValidator(s))
                    {
                        flag4 = false;
                        BloodType.setError("Please Enter Correct Blood Group");
                    }
                    else
                    {
                        flag4 = true;
                    }
                }
            }
        });     // set
        lastDate.addTextChangedListener(new TextWatcher() {
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
                    if (!dateValidator(s))
                    {
                        flag5 = false;
                        lastDate.setError("Please Enter The Date In Correct Format");
                    }
                    else
                    {
                        flag5 = true;
                    }
                }
            }
        });     // set

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String age = Age.getText().toString().trim();
                String weight = Weight.getText().toString().trim();
                String add = Address.getText().toString().trim();
                if ((age.compareTo("17")>0) && (age.compareTo("66")<0))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                    Toast.makeText(getActivity(), "Your Age Is Not Appropriate To Donate Blood", Toast.LENGTH_LONG).show();
                }
                if (weight.compareTo("50") >= 0)
                {
                    flag1 = true;
                }
                else {
                    flag1 = false;
                    Toast.makeText(getActivity(), "Your Weight Is Not Appropriate Donate Blood", Toast.LENGTH_LONG).show();
                }
                if (add.length()>0) {
                    if (flag && flag1 && flag3 && flag4 && flag5 && flag6) {
                        Toast.makeText(getActivity(), "User Registered Successfully", Toast.LENGTH_LONG).show();
                        getActivity().finish();
                        startActivity(new Intent(getActivity(),Main2Activity.class));
                    }
                    else {
                        Toast.makeText(getActivity(), "Please Fill All The Details Correctly", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Please Add the Address", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }

    private boolean validatePassword(CharSequence s) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    private boolean dateValidator(CharSequence s) {

        Pattern pattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();

    }

    private boolean bloodValidator(CharSequence bloodGroup) {
        Pattern pattern1 = Pattern.compile( "^(A|B|AB|O)[+-]$");
        Matcher matcher1 = pattern1.matcher(bloodGroup);
        return matcher1.matches();
    }

    private boolean emailValidator(CharSequence email){
        Pattern pattern1 = Pattern.compile( "^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+");

        Matcher matcher1 = pattern1.matcher(email);

        return matcher1.matches();
    }

    private boolean phoneValidator(CharSequence phone){
        if(phone.length() < 6 || phone.length() > 13)
            return false;
        else
            return true;
    }

}
