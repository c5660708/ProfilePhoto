package com.example.materialdesign;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class WallpaperActivity extends AppCompatActivity {

    public static final String WALLPAPER_NAME = "wallpaper_name";
    public static final String WALLPAPER_IMAGE_ID = "wallpaper_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        Intent intent = getIntent();
        String wallpaperName = intent.getStringExtra(WALLPAPER_NAME);
        int wallpaperId = intent.getIntExtra(WALLPAPER_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.wallpaper_image_view);
        TextView textView = (TextView) findViewById(R.id.wallpaper_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(wallpaperName);
        imageView.setImageResource(wallpaperId);
        String wallpaperContent = generateWallpaperContent(wallpaperName);
        textView.setText(wallpaperContent);
    }

    private String generateWallpaperContent(String wallpaperName) {
        StringBuilder wallpaperContent = new StringBuilder();
        for (int i = 0;i < 500;i++){
            wallpaperContent.append(wallpaperName);
        }
        return wallpaperContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
