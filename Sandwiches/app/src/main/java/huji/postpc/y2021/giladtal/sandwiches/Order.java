package huji.postpc.y2021.giladtal.sandwiches;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {
    Holder holder=null;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (holder==null){
            holder=App.getInstance().getDb();
        }
        setContentView(R.layout.order);
        EditText comment = findViewById(R.id.comment);
        EditText name = findViewById(R.id.name);
        Button hummus = findViewById(R.id.hummus);
        Button tahini = findViewById(R.id.tahini);
        Button order_button = findViewById(R.id.order_buuton);
        NumberPicker pickels = findViewById(R.id.pickels);
        pickels.setMaxValue(10);
        pickels.setMinValue(0);
        pickels.setValue(holder.data.pickles);

        name.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                // text did change
                String newText = name.getText().toString();
                holder.data.name = newText;
                name.setEnabled(true);
            }
        });
        comment.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                // text did change
                String newText = comment.getText().toString();
                holder.data.comment = newText;
                comment.setEnabled(true);
            }
        });
        hummus.setOnClickListener(v -> {
            if (hummus.getText().equals("no"))
            {
                holder.data.hummus = true;
                hummus.setText("yes");//todo maybe change the way the button has text
            }
            else {
                holder.data.hummus = false;
                hummus.setText("no");
            }
        });
        tahini.setOnClickListener(v -> {
            if (tahini.getText().equals("no"))
            {
                holder.data.tahini = true;
                tahini.setText("yes");
            }
            else {
                holder.data.tahini = false;
                tahini.setText("no");
            }
        });
        order_button.setOnClickListener(v -> {
            holder.data.pickles = pickels.getValue();
            holder.getData().status="waiting";
            holder.add(holder.data.name,holder.data.pickles,holder.data.hummus,holder.data.tahini,holder.data.comment);
            startActivity(new Intent(this, Waiting.class));
            finish();
        });
    }
}
