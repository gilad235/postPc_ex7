package huji.postpc.y2021.giladtal.sandwiches;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;

import java.io.Serializable;

public class Holder implements Serializable {


    Order_data data=null;
    static SharedPreferences sharedPreferences=null;
    static Context context;
    public FirebaseFirestore storage;

    public Holder(Context context){
        Holder.context=context;
        sharedPreferences = context.getSharedPreferences("local_data",Context.MODE_PRIVATE);
        this.storage = FirebaseFirestore.getInstance();
        initialize();

    }

    private void initialize() {
        //todo
    }

    public Order_data getData() {
        if (data==null)
        {
            data = new Order_data();
        }
        return data;
    }
    public void add(String name, int pickles, boolean hummus,
            boolean tahini, String comment){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (data!=null){
            editor.remove(data.id);
        }
        data = new Order_data(name,  pickles,  hummus,
         tahini,  comment);
        editor.putString(data.id, data.dataToString());
        editor.apply();
        storage.collection("orders").document(data.id).set(data);
        storage.collection("orders").add(data);//todo which one?

    }

    public void delete(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(data.id);
        editor.apply();
        storage.collection("orders").document(data.id).delete();

        //todo storage.collections.remove

    }
    public void edit(String status){
        data.status = status;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(data.id, data.dataToString());
        editor.apply();
        storage.collection("orders").document(data.id).set(data);

    }
}
