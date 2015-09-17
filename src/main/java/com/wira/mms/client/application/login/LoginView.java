package com.wira.mms.client.application.login;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class LoginView extends ViewImpl implements LoginPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoginView> {
    }

    @UiField MaterialButton btnLogin;
    @UiField MaterialTextBox txtEmail;
    
    @Inject
    LoginView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public boolean isValid() {
		boolean isValid = true;
		if(!txtEmail.getValue().matches("[\\w-]+@([\\w-]+\\.)+[\\w-]+")){
			isValid = false;
		}
		
		return isValid;
	}

	@Override
	public HasClickHandlers getLoginButton() {
		return btnLogin;
	}
    
}