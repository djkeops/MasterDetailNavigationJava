package com.example.android.master_detailnavigationjava;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;

        boolean isTablet = Objects.requireNonNull(getContext()).getResources().getBoolean(R.bool.isTablet);

        if (isTablet) {
            view = inflater.inflate(R.layout.fragment_profile_land, container, false);
            displayMasterDetailLayout(view);
        } else {
            view = inflater.inflate(R.layout.fragment_profile, container, false);
            displaySingleLayout(view);
        }



        // Inflate the layout for this fragment
        return view;
    }

    private void displaySingleLayout (View view) {
        View accountTextView = view.findViewById(R.id.account_textview);
        accountTextView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_account));

        View notificationsTextView = view.findViewById(R.id.notifications_textview);
        notificationsTextView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_notifications));

        View settingsTextView = view.findViewById(R.id.settings_textview);
        settingsTextView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_profile_fragment_to_fragment_settings));
    }

    private void displayMasterDetailLayout (View view) {
        final NavHostFragment navHostFragment = (NavHostFragment)getChildFragmentManager().findFragmentById(R.id.profile_nav_container);

        View accountTextView = view.findViewById(R.id.account_textview);
        accountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (navHostFragment != null) {
                    navHostFragment.getNavController().navigate(R.id.fragment_account);
                }
            }
        });

        View notificationsTextView = view.findViewById(R.id.notifications_textview);
        notificationsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (navHostFragment != null) {
                    navHostFragment.getNavController().navigate(R.id.fragment_notifications);
                }
            }
        });

        View settingsTextView = view.findViewById(R.id.settings_textview);
        settingsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (navHostFragment != null) {
                    navHostFragment.getNavController().navigate(R.id.fragment_settings);
                }
            }
        });
    }

}
