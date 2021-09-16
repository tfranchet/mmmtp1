package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first,  container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
 public void onCreateOptionsMenu(@NonNull Menu menu , MenuInflater inflater) {
         // Inflate the menu; this adds items to the action bar
        // if it is present.
        inflater.inflate(R.menu.menu_test , menu);
        super.onCreateOptionsMenu(menu , inflater );
        }
        
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = view.getRootView().findViewById(R.id.editTextTextPersonName);
                EditText city = view.getRootView().findViewById(R.id.editTextTextPersonName2);
                EditText calendar = view.getRootView().findViewById(R.id.calendarView2);
                Toast.makeText(getActivity().getApplicationContext(),
                        name.getText().toString(), Toast.LENGTH_SHORT ).show();
                Toast.makeText(getActivity().getApplicationContext(),
                        city.getText().toString(), Toast.LENGTH_SHORT ).show();
                Toast.makeText(getActivity().getApplicationContext(),
                        calendar.getText().toString(), Toast.LENGTH_SHORT ).show();
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.resetInformations) {
            EditText name = this.getView().findViewById(R.id.editTextTextPersonName);
            EditText city = this.getView().findViewById(R.id.editTextTextPersonName2);
            EditText calendar = this.getView().findViewById(R.id.calendarView2);
            name.getText().clear();
            city.getText().clear();
            calendar.getText().clear();
            return true;
        }

        if (id == R.id.telephone) {
            EditText a = this.getView().findViewById(R.id.editTextPhone);
            a.setVisibility(this.getView().VISIBLE);
            return true;
        }

        if (id == R.id.web) {
            EditText a = this.getView().findViewById(R.id.spinner);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org" + a.getText().toString()));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}