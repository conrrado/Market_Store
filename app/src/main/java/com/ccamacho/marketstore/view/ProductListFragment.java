package com.ccamacho.marketstore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ccamacho.marketstore.adapters.ProductListAdapter;
import com.ccamacho.marketstore.R;
import com.ccamacho.marketstore.databinding.FragmentProductListBinding;
import com.ccamacho.marketstore.model.Product;
import com.ccamacho.marketstore.model.Purchase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    private ProductListAdapter adapter;

    private FragmentProductListBinding binding;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProductListBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ProductListAdapter(populate());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(adapter);
    }

    private List<Product> populate() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Teste1", "Valor R$ 5,00", "bla bla bla"));
        productList.add(new Product("Teste2", "Valor R$ 3,00", "bla bla bla"));
        productList.add(new Product("Teste3", "Valor R$ 5,50", "bla bla bla"));
        productList.add(new Product("Teste4", "Valor R$ 6,90", "bla bla bla"));
        productList.add(new Product("Teste5", "Valor R$ 7,85", "bla bla bla"));
        return productList;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_purchase) {
            openPurchaseList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPurchaseList() {
        Purchase purchase = new Purchase(filterCheckedList());

        NavDirections action = ProductListFragmentDirections.actionToPurchaseListFragment(purchase);
        Navigation.findNavController(getView()).navigate(action);
    }

    private List<String> filterCheckedList() {
        List<String> nameList = new ArrayList<>();
        for (Product product : adapter.getProductList()) {
            if (product.isChecked()) {
                nameList.add(product.getName());
            }
        }
        return nameList;
    }
}
