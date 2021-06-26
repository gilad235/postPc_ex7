package huji.postpc.y2021.giladtal.sandwiches;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class Progress extends AppCompatActivity {
    Holder holder=null;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (holder==null){
            holder=App.getInstance().getDb();
        }
        setContentView(R.layout.progress);

        holder.storage.collection("orders").document(holder.data.id).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable @org.jetbrains.annotations.Nullable DocumentSnapshot value, @Nullable @org.jetbrains.annotations.Nullable FirebaseFirestoreException error) {
                if (error!=null){
                    //todo error
                }
                else if(value==null){
                    holder.delete();
                    finish();
                }
                else if (value.getData().get("status").equals("done")){
                    Intent prog = new Intent(Progress.this,Done.class);
//                    holder.edit("done");
                    startActivity(prog);
                    finish();
                }
            }
        });
    }
}
