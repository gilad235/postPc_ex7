package huji.postpc.y2021.giladtal.sandwiches;
import java.util.UUID;

public class Order_data {
    public String id;
    public String name;
    public int pickles;
    public boolean hummus;
    public boolean tahini;
    public String comment;
    public String status;

    public Order_data(Order_data other)
    {
        this.id = other.id;
        this.name = other.name;
        this.pickles = other.pickles;
        this.hummus = other.hummus;
        this.tahini = other.tahini;
        this.comment = other.comment;
        this.status = other.status;
    }
    public Order_data(String str){
        String[] lst = str.split("#");
        this.id = lst[0];
        this.name = lst[1];
        this.pickles = Integer.parseInt(lst[2]);
        this.hummus = Boolean.parseBoolean(lst[3]);
        this.tahini = Boolean.parseBoolean(lst[4]);
        this.comment = lst[5];
        this.status = lst[6];
    }
    public Order_data(String name,int pickles,boolean hummus,
                   boolean tahini,String comment)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.pickles = pickles;
        this.hummus = hummus;
        this.tahini = tahini;
        this.comment = comment;
        this.status = "Order";
    }
    public Order_data()
    {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.pickles = 0;
        this.hummus = false;
        this.tahini = false;
        this.comment = "";
        this.status = "Order";
    }


    public String dataToString(){
        return id+"#"+name+"#"+String.valueOf(pickles)+"#"+String.valueOf(hummus)+"#"+String.valueOf(tahini)+"#"+comment+"#"+status;
    }



}
