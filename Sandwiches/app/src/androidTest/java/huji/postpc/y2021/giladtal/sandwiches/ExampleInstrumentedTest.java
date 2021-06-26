package huji.postpc.y2021.giladtal.sandwiches;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.mockito.Mockito;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.android.controller.ActivityController;
//import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
//    private ActivityController<MainActivity> activityController;
//    private Order mockHolder;
//
//    @Before
//    public void setup(){
//        mockHolder = Mockito.mock(Order.class);
//        // when asking the `mockHolder` to get the current items, return an empty list
//        Mockito.when(mockHolder.getCurrentItems())
//                .thenReturn(new ArrayList<>());
//
//        activityController = Robolectric.buildActivity(MainActivity.class);
//
//        // let the activity use our `mockHolder` as the TodoItemsHolder
//        MainActivity activityUnderTest = activityController.get();
//        activityUnderTest.holder = mockHolder;
//    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("huji.postpc.y2021.giladtal.sandwiches", appContext.getPackageName());
    }

//    @Test
//    public void setPickels() {
//        // Context of the app under test.
//        Order order = new Order();
//
////        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals(order.holder.data.status, "Order");
//    }

    @Test
    public void setName() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("huji.postpc.y2021.giladtal.sandwiches", appContext.getPackageName());
    }

    @Test
    public void setTahini() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("huji.postpc.y2021.giladtal.sandwiches", appContext.getPackageName());
    }
}