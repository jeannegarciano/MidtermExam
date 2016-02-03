package sidespell.tech.midtermexam.fragments;

/**
 * Created by admin on 2/2/2016.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sidespell.tech.midtermexam.R;

public class RecyclerViewListFragment extends Fragment {



    public static RecyclerViewListFragment newInstance() {
        return new RecyclerViewListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerListView);
        TextView tvEmpty = (TextView) view.findViewById(android.R.id.empty);


        recyclerView.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),
                R.layout.recycler_list_item, mController.getMovies());


        recyclerView.setAdapter(adapter);

        if (adapter.getItemCount() == 0) {
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            tvEmpty.setVisibility(View.GONE);
        }
    }
}
