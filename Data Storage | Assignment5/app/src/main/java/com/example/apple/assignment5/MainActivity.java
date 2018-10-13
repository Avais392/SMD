package com.example.apple.assignment5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final  MyDatabase myDb = MyDatabase.getAppDatabase(this);
        try {
            TestDatabaseAsyncTask runner = new TestDatabaseAsyncTask(this);
            runner.execute();

        }
        catch (Exception e){}
        finally {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    List<User> users = myDb.userDao().getAll();

                    for (int i =0; i <users.size();i++)
                    {
                        TextView CView=(TextView)findViewById(R.id.c_view);
                        CView.append(String.valueOf(users.get(i).getUid())+"    "+users.get(i).getFirstName()+"\n");
                        Log.d("userName:",users.get(i).getFirstName());
                        Log.d("userID:",String.valueOf(users.get(i).getUid()));
                    }
                }
            }) .start();
        }



    }


}
