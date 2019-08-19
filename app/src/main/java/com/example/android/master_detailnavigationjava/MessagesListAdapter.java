package com.example.android.master_detailnavigationjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesListAdapter.MessagesViewHolder> {

    private final LinkedList<String> mMessagesList;
    private LayoutInflater mInflater;
    private Context context;

    public MessagesListAdapter(Context context, LinkedList<String> messagesList) {
        mInflater = LayoutInflater.from(context);
        this.mMessagesList = messagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.messageslist_item, parent, false);
        return new MessagesViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {
        String mCurrentMessage = mMessagesList.get(position);
        holder.messageItemView.setText(mCurrentMessage);

        boolean isTablet = context.getResources().getBoolean(R.bool.isTablet);

        if (!isTablet) {
            holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_messages_fragment_to_fragment_details));
        } else {
            //TODO: This is what i want - to implement navigation for tablets
            holder.itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Navigation.findNavController(v).navigate(R.id.fragment_details);
                        }
                    });
        }

    }

    @Override
    public int getItemCount() {
        return mMessagesList.size();
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder {
        public final TextView messageItemView;
        final MessagesListAdapter mAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter  The adapter that manages the the data and views
         *                 for the RecyclerView.
         */
        public MessagesViewHolder(@NonNull View itemView, MessagesListAdapter adapter) {
            super(itemView);
            messageItemView = itemView.findViewById(R.id.message);
            this.mAdapter = adapter;
        }

    }
}
