package com.example.apple.tabssample;

import android.os.Handler;
import android.text.TextUtils;

public class SignupInteractor {

    interface OnSignupFinishedListener {
        void onUsernameError();
        void onFullnameError();
        void onEmailError();
        void onPasswordError();

        void onSuccess();
    }

    public void signup(final String fullname,final String email,final String username, final String password, final OnSignupFinishedListener listener) {
        // Mock signup. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(fullname)) {
                    listener.onFullnameError();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    listener.onEmailError();
                    return;
                }
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    return;
                }

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("Users");
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        int flag=0;
//                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                            Log.e(TAG, "=======" + postSnapshot.child("email").getValue());
//                            if (postSnapshot.getValue() == username) {
//                                if(postSnapshot.child(username).getValue()==password)
//                                {flag=1;
//                                    break;}
//                            }
//                        }
//                        if(flag==0)
//                            return;
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                        Log.e(TAG, "Failed to read app title value.", error.toException());
//                    }
//
//                });
                listener.onSuccess();
            }
        } , 2000);
    }
}
