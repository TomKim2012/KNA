package com.wira.mms.client.application.newsfeed;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.wira.mms.client.application.ApplicationPresenter;
import com.wira.mms.client.place.NameTokens;
public class NewsFeedPresenter extends Presenter<NewsFeedPresenter.MyView, NewsFeedPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_NewsFeed = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.newsfeed)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<NewsFeedPresenter> {
    }

    @Inject
    NewsFeedPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
        
    }
    
    
}