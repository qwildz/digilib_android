package com.qwildz.digitallibrary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qwildz.digitallibrary.Album;
import com.qwildz.digitallibrary.R;
import com.qwildz.digitallibrary.adapters.ListAlbumsAdapter;
import com.qwildz.digitallibrary.ui.AutofitRecyclerView;
import com.qwildz.digitallibrary.ui.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by resna on 2016-06-12.
 */
public class ListAlbumFragment extends Fragment {

    AutofitRecyclerView recyclerView;

    private ListAlbumsAdapter adapter;
    private List<Album> albumList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListAlbumFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListAlbumFragment newInstance() {
        ListAlbumFragment fragment = new ListAlbumFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumList = new ArrayList<>();
        adapter = new ListAlbumsAdapter(getContext(), albumList);
        prepareAlbums();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

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

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Album a = new Album("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new Album("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new Album("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new Album("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new Album("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new Album("Loud", 11, covers[6]);
        albumList.add(a);

        a = new Album("Legend", 14, covers[7]);
        albumList.add(a);

        a = new Album("Hello", 11, covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
    }
}
