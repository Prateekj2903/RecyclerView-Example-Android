package com.example.windo.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by windo on 4/13/2018.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleAdapterViewHolder> {


    String []mtext;

    ExampleAdapterOnClickListener mOnClickListener;

    ExampleAdapter(ExampleAdapterOnClickListener exampleAdapterOnClickListener){
        mOnClickListener = exampleAdapterOnClickListener;
    }


    interface ExampleAdapterOnClickListener{
        void onClick(String currText);
    }

    @Override
    public ExampleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        int layoutId = R.layout.layout_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutId, parent, shouldAttachToParentImmediately);

        ExampleAdapterViewHolder exampleAdapterViewHolder = new ExampleAdapterViewHolder(view);
        return exampleAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(ExampleAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {

        if(mtext == null){
            return 0;
        }

        return mtext.length;
    }

    public void setText(String[] text){
        mtext = text;
        notifyDataSetChanged();
    }

    class ExampleAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView mExampleTextView;

        public ExampleAdapterViewHolder(View view){
            super(view);
            mExampleTextView = (TextView) view.findViewById(R.id.tv_item);
            view.setOnClickListener(this);
        }

        void bind(int pos){
            mExampleTextView.setText(mtext[pos]);
        }


        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            mOnClickListener.onClick(mtext[adapterPosition]);
        }
    }
}
