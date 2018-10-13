package com.example.apple.assignment5;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.List;


public class TestDatabaseAsyncTask extends AsyncTask {
    Context c;

  //  public  TestDatabaseAsyncTask(){};
    TestDatabaseAsyncTask(Context con)
    {
        c = con;
    }
    @Override
    protected Object doInBackground(Object[] objects) {


        MyDatabase myDb = MyDatabase.getAppDatabase(c);
        int a = myDb.userDao().countUsers();
        Log.d("-----",String.valueOf(a));
        User user = new User();
        user.setAge(22);
        user.setFirstName("Avais");
        user.setLastName("Muhib Rasool");
        User user1 = new User();
        user1.setAge(20);
        user1.setFirstName("Hafsah");
        user1.setLastName("Shehzad");
        User user2 = new User();
        user2.setAge(20);
        user2.setFirstName("Khadija");
        user2.setLastName("Asim Uppal");
        myDb.userDao().insertAll(user,user1,user2);


        return null;
    }
}
