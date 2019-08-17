package com.example.android.master_detailnavigationjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MessagesListAdapter extends RecyclerView.Adapter<MessagesListAdapter.MessagesViewHolder> {

    private final LinkedList<String> mMessagesList;
    private LayoutInflater mInflater;

    public MessagesListAdapter(Context context, LinkedList<String> messagesList) {
        mInflater = LayoutInflater.from(context);
        this.mMessagesList = messagesList;
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
    }

    @Override
    public int getItemCount() {
        return mMessagesList.size();
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView messageItemView;
        final MessagesListAdapter mAdapter;

        /**
         * Creates a new custom view holder to hold the view to display in
         * the RecyclerView.
         *
         * @param itemView The view in which to display the data.
         * @param adapter The adapter that manages the the data and views
         *                for the RecyclerView.
         */
        public MessagesViewHolder(@NonNull View itemView, MessagesListAdapter adapter) {
            super(itemView);
            messageItemView = itemView.findViewById(R.id.message);
            this.mAdapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // Use that to access the affected item in mMessagesList.
            String element = mMessagesList.get(mPosition);

            // Change the word in the mMessagesList.
            mMessagesList.set(mPosition, "Clicked! " + element);

            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}
