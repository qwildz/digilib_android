package com.qwildz.digitallibrary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qwildz.digitallibrary.MyApplication;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.recyclerview.ListNewsAdapter;
import com.qwildz.digitallibrary.adapters.recyclerview.ListVideoAdapter;
import com.qwildz.digitallibrary.injector.components.DaggerInjectorComponent;
import com.qwildz.digitallibrary.injector.components.InjectorComponent;
import com.qwildz.digitallibrary.models.News_;
import com.qwildz.digitallibrary.models.Repository;
import com.qwildz.digitallibrary.models.Video;
import com.qwildz.digitallibrary.ui.AutofitRecyclerView;
import com.qwildz.digitallibrary.ui.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by resna on 2016-06-12.
 */
public class ListNewsFragment extends Fragment {

    AutofitRecyclerView recyclerView;

    private ListNewsAdapter adapter;
    private List<News_> dataList;

    @Inject
    Repository repository;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListNewsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListNewsFragment newInstance() {
        ListNewsFragment fragment = new ListNewsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication application = (MyApplication) getActivity().getApplication();
        InjectorComponent injectorComponent = DaggerInjectorComponent.builder()
                .baseComponent(application.getBaseComponent())
                .build();

        injectorComponent.inject(this);

        repository.getNews().subscribe(news -> {
            dataList.addAll(news.getNews());
            adapter.notifyDataSetChanged();
        });

        dataList = new ArrayList<>();
        adapter = new ListNewsAdapter(getContext(), dataList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_news, container, false);

        // Set the adapter
        if (view instanceof AutofitRecyclerView) {
            Context context = view.getContext();
            recyclerView = (AutofitRecyclerView) view;
            recyclerView.addItemDecoration(new MarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin)));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState (Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }
}
