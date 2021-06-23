package huji.postpc.y2021.giladtal.sandwiches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Holder holder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (holder==null){
            holder = App.getInstance().getDb();
        }
        String status;
        if (holder.getData()!=null){
            status = holder.getData().status;
        }

        else {
            status = "Order";
            //todo create order instance
        }
        if (status.equals("Order")){
            Intent orderIntent = new Intent(MainActivity.this,Order.class);
            finish();
            startActivity(orderIntent);
        }
        else if (status.equals("Waiting")){
            Intent waitingIntent = new Intent(MainActivity.this,Waiting.class);
            finish();
            startActivity(waitingIntent);
        }
        else if (status.equals("Progress")){
            Intent progressIntent = new Intent(MainActivity.this,Progress.class);
            finish();
            startActivity(progressIntent);        }
        if (status.equals("Done")){
            Intent doneIntent = new Intent(MainActivity.this,Done.class);
            finish();
            startActivity(doneIntent);        }
    }
}