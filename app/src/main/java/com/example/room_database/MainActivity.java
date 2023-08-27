package com.example.room_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edtName,edtAmount;
Button btnEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAmount=findViewById(R.id.edtAmount);
        btnEnter = findViewById(R.id.btnEnter);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtName.getText().toString();
                String amount = edtAmount.getText().toString();
                databaseHelper.expense_dao().addTx(
                        new Expense(title,amount)
                );
                ArrayList<Expense> arrExpense = (ArrayList<Expense>) databaseHelper.expense_dao().getAllExpense();
                for(int i=0;i<arrExpense.size();i++){
                    Log.d("Data","Title: "+arrExpense.get(i).getTitle()+" Amount: "+arrExpense.get(i).getAmount());
                }
            }
        });


    }
}