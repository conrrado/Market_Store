package com.ccamacho.marketstore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccamacho.marketstore.databinding.FragmentProductDetailBinding;
import com.ccamacho.marketstore.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding binding;

    public ProductDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            Product product = ProductDetailFragmentArgs.fromBundle(getArguments()).getProduct();
            binding.textViewName.setText(product.getName());
            binding.textViewShortDescription.setText(product.getShortDescription());
            binding.textViewLongDescription.setText(product.getLongDescription());
        }
    }
}
