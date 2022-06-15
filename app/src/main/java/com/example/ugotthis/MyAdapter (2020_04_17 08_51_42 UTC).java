package com.example.ugotthis;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> values;
    private int index = -1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public CheckBox checkBox;
        public View layout;
        public Button editBtn;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            checkBox = (CheckBox) v.findViewById(R.id.check_task);
            editBtn = (Button) v.findViewById(R.id.edit_btn);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }




    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.task_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {


        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position);
        holder.txtHeader.setText(name);
        holder.checkBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //record the position of itme in recycler view
                index = position;
                notifyDataSetChanged();
            }
        });

        holder.editBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //create toast when user click edit button in task list
                Toast.makeText(v.getContext(), "You edited a new task", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }


        });


        if(index==position){
            //change the background and word to indicate that task is completed
            holder.layout.setBackgroundResource(R.color.colorPrimaryLight);
            holder.txtHeader.setText("uGotThis");
            holder.txtFooter.setText("");
            holder.checkBox.setChecked(true);

        }else{
            holder.layout.setBackgroundColor(Color.WHITE);
            holder.checkBox.setChecked(false);
            holder.txtFooter.setText("6/12/2019");
        }

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}