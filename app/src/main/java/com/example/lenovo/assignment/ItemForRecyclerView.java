package com.example.lenovo.assignment;

/**
 * Created by LENOVO on 07-05-2016.
 */
public class ItemForRecyclerView
{

    private String mtext;
    private String mtext1;
    private int Image;


    public  ItemForRecyclerView(String text,String text1, int image)
    {

        this.mtext = text;
        this.mtext1 = text1;
        this.Image = image;
    }
    public void setImage(int image )
    {
        this.Image = image;

    }
    public int getImage()
    {
        return Image;

    }

    public void setText2(String text)
    {
        this.mtext = text;
    }
    public String getText2()
    {
        return mtext;
    }
    public void setText1(String text1)
    {
        this.mtext1 = text1;
    }
    public String getText1()
    {
        return mtext1;
    }
}
