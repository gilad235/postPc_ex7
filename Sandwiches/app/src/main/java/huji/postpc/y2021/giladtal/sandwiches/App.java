package huji.postpc.y2021.giladtal.sandwiches;

import com.google.firebase.FirebaseApp;

public class App extends android.app.Application{


    private Holder db;//todo make db firebase


    private static App instance;
    public Holder getDb() {

        if (db==null){
            db = new Holder(this);
        }
        return db;
    }
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.db = getDb();
        instance = this;
    }

}
