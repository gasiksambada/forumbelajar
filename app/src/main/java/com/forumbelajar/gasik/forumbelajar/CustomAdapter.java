package com.forumbelajar.gasik.forumbelajar;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter{
    String [] result;
    Context context;
    Bitmap [] imageId,imageId2;
    ImageView expandedImageView;

    private static LayoutInflater inflater = null;
    public CustomAdapter(DetailQuestionActivity mainActivity, String[] prgmNameList, Bitmap[] prgmImages, Bitmap[] prgmImages2) {
        result = prgmNameList;
        context = mainActivity;
        imageId = prgmImages;
        imageId2 = prgmImages2;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img,img2,expandedImageView,expandedImageView2;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.answer_list, null);
        holder.tv = (TextView) rowView.findViewById(R.id.answer);
        holder.img = (ImageView) rowView.findViewById(R.id.showanswerphoto1);
        holder.img2 = (ImageView) rowView.findViewById(R.id.showanswerphoto2);
        holder.expandedImageView = (ImageView) rowView.findViewById(R.id.expanded_image_answer);
        holder.expandedImageView2 = (ImageView) rowView.findViewById(R.id.expanded_image_answer2);
        holder.tv.setText(result[position]);

        if(imageId[position] != null){
            holder.img.setImageBitmap(imageId[position]);
            holder.img.setVisibility(View.VISIBLE);
            holder.expandedImageView.setImageBitmap(imageId[position]);

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.expandedImageView.setVisibility(View.VISIBLE);
                    holder.img.setVisibility(View.GONE);
                }
            });
        }
        if(imageId2[position] != null) {
            holder.img2.setImageBitmap(imageId2[position]);
            holder.img2.setVisibility(View.VISIBLE);
            holder.expandedImageView2.setImageBitmap(imageId2[position]);

            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.expandedImageView2.setVisibility(View.VISIBLE);
                    holder.img2.setVisibility(View.GONE);
                }
            });
        }

        holder.expandedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.expandedImageView.setVisibility(View.GONE);
                holder.img.setVisibility(View.VISIBLE);
            }
        });

        holder.expandedImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.expandedImageView2.setVisibility(View.GONE);
                holder.img2.setVisibility(View.VISIBLE);
            }
        });

        return rowView;
    }
}