package com.wira.mms.client.application.newsfeed;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class NewsFeedModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(NewsFeedPresenter.class, NewsFeedPresenter.MyView.class, NewsFeedView.class, NewsFeedPresenter.MyProxy.class);
    }
}