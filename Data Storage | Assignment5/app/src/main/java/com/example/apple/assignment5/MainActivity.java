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
                    Log.d("Previous",String.valueOf(myDb.userDao().countUsers()));
                    for (int i =0; i <users.size();i++)
                    {
                       Log.d("userID:",String.valueOf(users.get(i).getUid()));
                        Log.d("userFirstName:",users.get(i).getFirstName());
                        Log.d("userLastName:",users.get(i).getLastName());
                    }
                    TextView CView=(TextView)findViewById(R.id.c_view);
                    for (int i =0; i <users.size();i++)
                    {
                       myDb.userDao().update(users.get(i).getUid(),users.get(i).getFirstName(),"Updated");
                    }

                    List<User> users1 = myDb.userDao().getAll();
                    Log.d("Updated",String.valueOf(myDb.userDao().countUsers()));
                    for (int i =0; i <users1.size();i++)
                    {


                        Log.d("userID:",String.valueOf(users1.get(i).getUid()));
                        Log.d("userFirstName:",users1.get(i).getFirstName());
                        Log.d("userLastName:",users1.get(i).getLastName());
                    }


                }
            }) .start();
        }



    }


}
