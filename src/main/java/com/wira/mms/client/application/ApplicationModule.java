package com.wira.mms.client.application;

import com.wira.mms.client.application.home.HomeModule;
import com.wira.mms.client.application.login.LoginModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.wira.mms.client.application.newsfeed.NewsFeedModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new NewsFeedModule());
		install(new HomeModule());
        install(new LoginModule());
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}