package com.zen.droidparts.loader;

import android.content.Context;
import android.support.v4.app.LoaderManager;

import java.util.List;

public class CollectionController<T> extends ContentLoaderController<List<T>> {
    public CollectionController(Context context, LoaderManager loaderManager, LoaderCreator factory) {
        super(context, loaderManager, factory);
    }
}
