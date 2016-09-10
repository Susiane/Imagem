package com.gdgdesafia.imagem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private final String IMAGE_URL = "http://vignette3.wikia.nocookie.net/marvel/images/3/30/Universo_Marvel.png/revision/latest?cb=20150115205852&path-prefix=pt-br";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView1);

        new DownloadImageTask(this,imageView).execute(IMAGE_URL);
    }


}
