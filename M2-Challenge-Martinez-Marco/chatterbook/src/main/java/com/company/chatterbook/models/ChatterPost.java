package com.company.chatterbook.models;

public class ChatterPost
{
    private String text;

    public ChatterPost(String text)
    {
        this.text = text;

    }

    // setters and getters
    public void setChatterPost(String post)
    {
        this.text = post;
    }

    public String getChatterPost()
    {
        return text;
    }
}
