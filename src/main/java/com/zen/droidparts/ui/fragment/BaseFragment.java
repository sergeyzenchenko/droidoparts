package com.zen.droidparts.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Views;
import de.greenrobot.event.EventBus;

/**
 *
 * Created by zen on 10/21/13.
 */
public abstract class BaseFragment extends Fragment {
    private EventBus eventBus;
    private Navigator navigator;

    public BaseFragment() {
        setEventBus(new EventBus());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(getFragmentLayoutResourse(), container, false);

        Views.inject(this, rootView);

        extractParams();

        afterCreateView(rootView);

        return rootView;
    }

    protected void extractParams() {

    }

    protected void afterCreateView(View rootView) {

    }

    protected abstract int getFragmentLayoutResourse();

    @Override
    public void onResume() {
        super.onResume();
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        eventBus.unregister(this);
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
