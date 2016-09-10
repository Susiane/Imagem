package com.gdgdesafia.imagem;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Susiane on 09/09/2016.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private ImageView imageView;
    private String imageUrl;
    private Bitmap downloadedImage;
    private ProgressDialog dialog;
    private Context context;

    public DownloadImageTask(Context context, ImageView imageView) {
        this.imageView = imageView;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        this.dialog = ProgressDialog.show(context,"Aguarde!", "Carregando imagem...",true,true);
    }

    protected Bitmap doInBackground(String... urls) {
        imageUrl = urls[0];
        downloadedImage = null;
        try {
            InputStream in = new java.net.URL(imageUrl).openStream();
            downloadedImage = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return downloadedImage;
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
        dialog.dismiss();
    }
}
