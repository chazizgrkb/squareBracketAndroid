package com.gamerappa.squarebracket.ui.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.gamerappa.squarebracket.databinding.FragmentCommunityBinding;
import com.gamerappa.squarebracket.databinding.FragmentNotificationsBinding;
import com.gamerappa.squarebracket.ui.notifications.NotificationsViewModel;

public class CommunityFragment extends Fragment {

    private CommunityViewModel communityViewModel;
    private FragmentCommunityBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communityViewModel =
                new ViewModelProvider(this).get(CommunityViewModel.class);

        binding = FragmentCommunityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCommunity;
        communityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}