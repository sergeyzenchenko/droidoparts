package com.zen.droidparts.ui.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zen.droidparts.module.Injector;

import butterknife.Views;

/**
 * Created by zen on 11/18/13.
 */
public class FragmentHelper {

    public static View onCreateView(LayoutInflater inflater, ViewGroup container, ConfigurableFragment configurableFragment) {
        View rootView = inflater.inflate(configurableFragment.getFragmentLayoutResource(), container, false);

        Views.inject(configurableFragment, rootView);

        configurableFragment.afterCreateView(rootView);

        return rootView;
    }

    public static void inject(Activity activity, Object injectingFragment) {
        if (!(activity instanceof Injector)) {
            throw new IllegalArgumentException("InjectingFragment have to be attached to instance of Injector");
        }

        ((Injector)activity).inject(injectingFragment);
    }
}
