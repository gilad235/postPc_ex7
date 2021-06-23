package huji.postpc.y2021.giladtal.sandwiches;
import java.util.UUID;

public class Order_data {
    String id;
    String name;
    int pickles;
    boolean hummus;
    boolean tahini;
    String comment;
    String status;

    Order_data(Order_data other)
    {
        this.id = other.id;
        this.name = other.name;
        this.pickles = other.pickles;
        this.hummus = other.hummus;
        this.tahini = other.tahini;
        this.comment = other.comment;
        this.status = other.status;
    }
    Order_data(String name,int pickles,boolean hummus,
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
    Order_data()
    {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.pickles = 0;
        this.hummus = false;
        this.tahini = false;
        this.comment = "";
        this.status = "Order";
    }


    //todo fix functions
    String dataToString(){
        return id+"#"+name+"#"+pickles+"#"+hummus+"#"+tahini+"#"+comment+"#"+status;
    }
    Order_data(String str){

    }


}
