/*
 *
 *  * Copyright (C) 2018 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.example.apple.tabssample;

public class SignupPresenter implements SignupInteractor.OnSignupFinishedListener {

    private SignupView signupView;
    private SignupInteractor signupInteractor;

    SignupPresenter(SignupView signupView, SignupInteractor signupInteractor) {
        this.signupView = signupView;
        this.signupInteractor = signupInteractor;
    }

    public void validateCredentials(String fullname,String email,String username, String password) {
        if (signupView != null) {
            signupView.showProgress();
        }

        signupInteractor.signup(fullname,email,username, password, this);
    }

    public void onDestroy() {
        signupView = null;
    }

    @Override
    public void onUsernameError() {
        if (signupView != null) {
            signupView.setUsernameError();
            signupView.hideProgress();
        }
    }
    @Override
    public void onFullnameError() {
        if (signupView != null) {
            signupView.setFullnameError();
            signupView.hideProgress();
        }
    }
    @Override
    public void onEmailError() {
        if (signupView != null) {
            signupView.setEmailError();
            signupView.hideProgress();
        }
    }
    @Override
    public void onPasswordError() {
        if (signupView != null) {
            signupView.setPasswordError();
            signupView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (signupView != null) {
            signupView.navigateToHome();
        }
    }
}
