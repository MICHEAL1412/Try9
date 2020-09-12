package com.example.atry;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback  extends AppCompatActivity {
    private EditText txtName,txtPhone,txtComment;
    private Button button;
    DatabaseReference reff;
    Comment comment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Intent intent = getIntent();

        txtName=findViewById(R.id.txtName);
        txtPhone=findViewById(R.id.txtPhone);
        txtComment=findViewById(R.id.txtComment);

        button=findViewById(R.id.button);
        comment= new Comment();
        reff= FirebaseDatabase.getInstance().getReference().child.("Comment");
        txtName.addTextChangedListener(loginTextWatcher);
        txtPhone.addTextChangedListener(loginTextWatcher);
        txtComment.addTextChangedListener(loginTextWatcher);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int Phone=Integer.parseInt(txtPhone.getText().toString().trim());
                comment.setName(txtName.getText().toString().trim());
                comment.setComment(txtComment.getText().toString().trim());
                reff.child("CustComment").setValue(comment);

            }
        });

    }
    private TextWatcher loginTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String feedbackInput=txtName.getText().toString().trim();


            button.setEnabled(!feedbackInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    public void back1(View view){
        // This is go new page
        /*Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);*/
        ///////////////////////////////////////////
        // This is close page
        finish();
    }
    public void displayToast(View view) {
        Toast toast=Toast.makeText(this,R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
        EditText name;
        name=findViewById(R.id.txtName);
        name.setText("");
        name=findViewById(R.id.txtPhone);
        name.setText("");
        name=findViewById(R.id.txtComment);
        name.setText("");
    }

}
