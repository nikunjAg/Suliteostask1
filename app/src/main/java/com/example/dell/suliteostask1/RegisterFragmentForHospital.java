package com.example.dell.suliteostask1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterFragmentForHospital extends Fragment {


    EditText hospitalname, hosphoneno, hosAddress, incharge, bloodRequirement, password;
    Button hosRegister;
    private boolean flag3,flag6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.register_activity_for_hospital,container,false);

        hospitalname = view.findViewById(R.id.Hospitalname);
        hosphoneno = view.findViewById(R.id.HospitalPhone);
        hosAddress = view.findViewById(R.id.HospitalAddress);
        incharge = view.findViewById(R.id.HospitalInCharge);
        bloodRequirement = view.findViewById(R.id.bloodRequirement);
        password = view.findViewById(R.id.HospitalPassword);
        hosRegister = view.findViewById(R.id.Hospitalregister);

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
                    }
                    else {
                        flag6 = true;
                    }
                }

            }
        });

        hosphoneno.addTextChangedListener(new TextWatcher() {
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
                        hosphoneno.setError("Please Enter Valid number!");
                    }
                    else
                    {
                        flag3 = true;
                    }
                }
            }
        });

        hosRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name,add,pho,blood,charge;
                name = hospitalname.getText().toString().trim();
                add = hosAddress.getText().toString().trim();
                pho = hosphoneno.getText().toString().trim();
                blood = bloodRequirement.getText().toString().trim();
                charge = incharge.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(add) || TextUtils.isEmpty(pho) || TextUtils.isEmpty(blood) || TextUtils.isEmpty(charge) || !flag3)
                {
                    Toast.makeText(getActivity(), "Please Fill All The Fields Appropriately", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity(), "Hospital Registration Successful", Toast.LENGTH_LONG).show();
                    getActivity().finish();
                    startActivity(new Intent(getActivity(),Main2Activity.class));
                }


            }
        });


        return view;
    }
    private boolean phoneValidator(CharSequence phone){
        if(phone.length() < 6 || phone.length() > 13)
            return false;
        else
            return true;
    }

    private boolean validatePassword(CharSequence s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
