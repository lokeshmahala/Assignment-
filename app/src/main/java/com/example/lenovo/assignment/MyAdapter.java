package com.example.lenovo.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LENOVO on 07-05-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.DataObjectHolder>
{
    private ArrayList<ItemForRecyclerView> mDataset;



    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemforrecyclerview,parent,false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);

        return dataObjectHolder;
    }








    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position)
    {
        holder.textView1.setText(mDataset.get(position).getText2());
        holder.textView2.setText(mDataset.get(position).getText1());
        holder.imageView.setImageResource(mDataset.get(position).getImage());



    }
    public void addItem(ItemForRecyclerView dataObject ,int index)
    {
        mDataset.add(dataObject);
        notifyItemInserted(index);
    }
    public  void DeleteItem(int index)
    {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }











    @Override
    public int getItemCount() {
        return mDataset.size();
    }









    public static class DataObjectHolder extends RecyclerView.ViewHolder
            // implements View.OnClickListener
    {
        TextView textView1;
        TextView textView2;
        ImageView imageView;


        public DataObjectHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.messageFrorRecyclerView);
            textView2 = (TextView) itemView.findViewById(R.id.timeForRecyclerView);
            imageView = (ImageView) itemView.findViewById(R.id.ImageViewForRecycler);




            //  itemView.setOnClickListener(this);

        }

        //  @Override
        // public void onClick(View v) {
        //     myClickListener.OnItemClick(getPosition(), v);
        // }
    }

    // public void setOnItemClickListener(MyClickListener myClickListener)
    //  {
    //     this.myClickListener = myClickListener;
    // }
    public MyAdapter(ArrayList<ItemForRecyclerView> myDataset)
    {
        this.mDataset = myDataset;
    }













    // public interface MyClickListener
    //{
    //   public void OnItemClick(int position,View v);
    // }


}

