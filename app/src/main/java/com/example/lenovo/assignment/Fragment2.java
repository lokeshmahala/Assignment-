package com.example.lenovo.assignment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Fragment2 extends Fragment implements View.OnClickListener{


    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6;

    Button image1Bt,image2Bt,image3Bt,image4Bt,image5Bt,image6Bt;

    ProgressDialog pDialog;

    private static final int Result1 = 1;
    private static final int Result2 = 2;


    Uri image1Uri,image2Uri;
    Bitmap bitmap;

    String butonText;









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);


        imageView1 = (ImageView) view.findViewById(R.id.imageView1);
        imageView2 = (ImageView) view.findViewById(R.id.imageView2);
        imageView3 = (ImageView) view.findViewById(R.id.imageView3);
        imageView4 = (ImageView) view.findViewById(R.id.imageView4);
        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        imageView6 = (ImageView) view.findViewById(R.id.imageView6);

        image1Bt = (Button) view.findViewById(R.id.buttonForImage1);
        image2Bt = (Button) view.findViewById(R.id.buttonForImage2);
        image3Bt = (Button) view.findViewById(R.id.buttonForImage3);
        image4Bt = (Button) view.findViewById(R.id.buttonForImage4);
        image5Bt = (Button) view.findViewById(R.id.buttonForImage5);
        image6Bt = (Button) view.findViewById(R.id.buttonForImage6);

        image1Bt.setOnClickListener(this);
        image2Bt.setOnClickListener(this);
        image3Bt.setOnClickListener(this);
        image4Bt.setOnClickListener(this);
        image5Bt.setOnClickListener(this);
        image6Bt.setOnClickListener(this);











        return view;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Result1 && resultCode == Activity.RESULT_OK && data != null) {
            image1Uri = data.getData();


            imageView5.setImageURI(image1Uri);

        } else if (requestCode == Result2 && resultCode == Activity.RESULT_OK && data != null) {
            image2Uri = data.getData();
            imageView6.setImageURI(image2Uri);
        }

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.buttonForImage1:

                butonText = (String) image1Bt.getText();



               new LoadImageFromURL().execute("https://4.bp.blogspot.com/-Nyfdpymc_Lo/VkQw-nJ79mI/AAAAAAAARYg/6o9VeoTvu-I/s1600-r/logo_chrome.png");
                break;
            case R.id.buttonForImage2:
                butonText = (String) image2Bt.getText();

                new LoadImageFromURL().execute("https://secure.regis.edu/Pariksha/Content/images/pariksha_logo.png");
                break;
            case R.id.buttonForImage3:
                butonText = (String) image3Bt.getText();

                new LoadImageFromURL().execute("https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
                break;
            case R.id.buttonForImage4:
                butonText = (String) image4Bt.getText();

                new LoadImageFromURL().execute("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTXiICGQzUxLvx4_czgDnYI4iVxglsO7YMrLs9Y1oFkd7sOKKa6");
                break;
            case R.id.buttonForImage5:

                Intent intent = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,Result1);


                break;
            case R.id.buttonForImage6:
                Intent intent1 = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1,Result2);
                break;


        }

    }

    private class LoadImageFromURL extends AsyncTask<String,String,Bitmap>
    {




        @Override
        protected Bitmap doInBackground(String... params)
        {

            try {
                bitmap  = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            } catch (IOException e) {
                e.printStackTrace();

            }

            return bitmap;



        }



        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = ProgressDialog.show(getActivity().getApplicationContext(),"","Loading Image");
            pDialog.show();




        }

        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            if (bitmap!= null)
            {
                pDialog.dismiss();

              switch (butonText)
              {
                  case "Image 1":
                      imageView1.setImageBitmap(bitmap);
                      break;
                  case "Image 2":
                      imageView2.setImageBitmap(bitmap);
                      break;
                  case "Image 3":
                      imageView3.setImageBitmap(bitmap);
                      break;

                  case "Image 4":
                      imageView4.setImageBitmap(bitmap);
                      break;


              }


            }
            else
            {
                pDialog.dismiss();
                Toast.makeText(getActivity().getApplicationContext(),"Something Went Wrong please Check Connection",Toast.LENGTH_LONG).show();
            }
        }


    }




}

