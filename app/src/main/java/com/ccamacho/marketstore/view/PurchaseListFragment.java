package com.ccamacho.marketstore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccamacho.marketstore.adapters.PurchaseListAdapter;
import com.ccamacho.marketstore.databinding.FragmentProductListBinding;
import com.ccamacho.marketstore.model.Purchase;


/**
 * A simple {@link Fragment} subclass.
 */
public class PurchaseListFragment extends Fragment {

    PurchaseListAdapter adapter;
    FragmentProductListBinding binding;

    public PurchaseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProductListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Purchase purchase = PurchaseListFragmentArgs.fromBundle(getArguments()).getPurchase();

            adapter = new PurchaseListAdapter(purchase.getNameList());
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.recyclerView.setAdapter(adapter);
        }
    }
}
