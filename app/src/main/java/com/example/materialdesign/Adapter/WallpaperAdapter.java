package com.example.materialdesign.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.example.materialdesign.R;
import com.example.materialdesign.Wallpaper;
import com.example.materialdesign.WallpaperActivity;

import java.util.List;

/**
 * Created by Skyia_ccf on 2017/12/5.
 */

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.ViewHolder> {

    private Context mContext;
    private List<Wallpaper> mWallpaperList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView wallpaperImage;
        TextView wallpaperName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            wallpaperImage = (ImageView) view.findViewById(R.id.wallpaper_image);
            wallpaperName = (TextView) view.findViewById(R.id.wallpaper_name);
        }
    }

    public WallpaperAdapter(List<Wallpaper> wallpaperList){
        mWallpaperList = wallpaperList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.picture_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Wallpaper wallpaper = mWallpaperList.get(position);
                Intent intent = new Intent(mContext, WallpaperActivity.class);
                intent.putExtra(WallpaperActivity.WALLPAPER_NAME,wallpaper.getName());
                intent.putExtra(WallpaperActivity.WALLPAPER_IMAGE_ID,wallpaper.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wallpaper wallpaper = mWallpaperList.get(position);
        holder.wallpaperName.setText(wallpaper.getName());
        holder.wallpaperImage.setImageResource(wallpaper.getImageId());
//        Glide.with(mContext).load(wallpaper.getImageId()).into(holder.wallpaperImage);
    }

    @Override
    public int getItemCount() {
        return mWallpaperList.size();
    }
}
