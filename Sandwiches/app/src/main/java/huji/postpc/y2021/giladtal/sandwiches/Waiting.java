package huji.postpc.y2021.giladtal.sandwiches;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class Waiting extends AppCompatActivity {
    Holder holder=null;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (holder==null){
            holder=App.getInstance().getDb();
        }
        setContentView(R.layout.waiting);
        EditText comment = findViewById(R.id.comment);
        EditText name = findViewById(R.id.name);
        Button hummus = findViewById(R.id.hummus);
        Button tahini = findViewById(R.id.tahini);
        Button order_button = findViewById(R.id.order_buuton);
        Button delete_button = findViewById(R.id.delete);
        //todo add pickels

        name.setText(holder.getData().name);
        comment.setText(holder.getData().comment);
        if (holder.getData().hummus){
            hummus.setText("yes");
        }
        else {
            hummus.setText("no");
        }
        if (holder.getData().tahini){
            tahini.setText("yes");
        }
        else {
            tahini.setText("no");
        }

        name.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                // text did change
                String newText = name.getText().toString();
                name.setEnabled(true);
            }
        });
        comment.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                // text did change
                String newText = comment.getText().toString();
                comment.setEnabled(true);
            }
        });
        hummus.setOnClickListener(v -> {
            if (hummus.getText().equals("no"))
            {
                hummus.setText("yes");//todo maybe change the way the button has text
            }
            else {
                hummus.setText("no");
            }
        });
        tahini.setOnClickListener(v -> {
            if (tahini.getText().equals("no"))
            {
                tahini.setText("yes");
            }
            else {
                tahini.setText("no");
            }
        });
        order_button.setOnClickListener(v -> {
            holder.edit("waiting");
            startActivity(new Intent(this, Waiting.class));
            finish();
        });
        delete_button.setOnClickListener(v -> {
            holder.delete();
            finish();
        });
        holder.storage.collection("orders").document(holder.data.id).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable @org.jetbrains.annotations.Nullable DocumentSnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                if (error!=null){
                    //todo error
                }
                else if(value!=null){
                    holder.delete();
                    finish();
                }
                else {
                    Intent prog = new Intent(Waiting.this,Progress.class);
                    holder.edit("progress");
                    startActivity(prog);
                    finish();
                }
            }
        });
        //todo add firebase listener to change mode to progress
    }
}
