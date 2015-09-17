package com.wira.mms.client.application.login;

import javax.inject.Inject;

import com.wira.mms.client.application.ApplicationPresenter;
import com.wira.mms.client.place.NameTokens;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {
    interface MyView extends View {
    	boolean isValid();
    	HasClickHandlers getLoginButton();
    }

    @ProxyStandard
    @NameToken(NameTokens.login)
    interface MyProxy extends ProxyPlace<LoginPresenter> {
    }
    
    @Inject PlaceManager placeManager;

    @Inject
    LoginPresenter(EventBus eventBus,
                      MyView view,
                      MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
    }
    
    @Override
    protected void onBind() {
    	super.onBind();
    	getView().getLoginButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(getView().isValid()){
					placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.getHome()).build());
				}
			}
		});
    }
}