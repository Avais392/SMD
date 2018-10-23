package com.example.apple.ass6;
import android.Manifest;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    private TextView textViewQueryResult;
    private Button buttonLoadData;
    ContentResolver contentResolver;
    Cursor cursor;
    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewQueryResult = (TextView) findViewById(R.id.textViewQueryResult);
        buttonLoadData = (Button) findViewById(R.id.buttonLoadData);
        buttonLoadData.setOnClickListener(this);
        contentResolver=getContentResolver();
      }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonLoadData:
                cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                        mColumnProjection,
                        null,
                        null,
                        null);if(cursor!=null && cursor.getCount()>0){
                StringBuilder stringBuilderQueryResult = new StringBuilder("");

                stringBuilderQueryResult.append("Contacts Count: "+cursor.getCount()+"\n");
                while (cursor.moveToNext()){
                    //stringBuilderQueryResult.append(cursor.getString(0)+" , "+cursor.getString(1)+" , "+cursor.getString(2)+"\n");
                }
                textViewQueryResult.setText(stringBuilderQueryResult.toString());
            }else{
                textViewQueryResult.setText("No Contacts in device");
            }
                break;
            default:
                break;
        }
    }

}
