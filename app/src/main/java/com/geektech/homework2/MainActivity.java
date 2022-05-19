package com.geektech.homework2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit_pochta, edit_parol;
    private Button btn_voyti1, btn_password_zabyl;
    private TextView dobro_pojal, registr, vhod;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_pochta = (EditText) findViewById(R.id.mail);
        edit_parol = (EditText) findViewById(R.id.edit_parol);
        btn_voyti1 = (Button) findViewById(R.id.voyti);
        btn_password_zabyl = (Button) findViewById(R.id.password_zabyl);
        dobro_pojal = (TextView) findViewById(R.id.dobropojal);
        registr = (TextView) findViewById(R.id.registr);
        vhod = (TextView) findViewById(R.id.vhod);
        onclickListener();
        edit_pochta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edit_pochta.getText().toString().isEmpty()) {
                    btn_voyti1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    btn_voyti1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }

            }
        });
        edit_parol.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edit_parol.getText().toString().isEmpty()) {
                    btn_voyti1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    btn_voyti1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
    }

    private void onclickListener() {
        btn_voyti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_pochta.getText().toString().equals("admin@gmail.com") && edit_parol.getText().toString().equals("admin")) {
                    btn_voyti1.setVisibility(View.GONE);
                    btn_password_zabyl.setVisibility(View.GONE);
                    edit_pochta.setVisibility(View.GONE);
                    edit_parol.setVisibility(View.GONE);
                    registr.setVisibility(View.GONE);
                    vhod.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вход успешно завершён", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Неверная почта или пароль.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}