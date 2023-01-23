package com.company.chatterbook.models;

import com.company.chatterbook.models.ChatterPost;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String name;
    List<ChatterPost> chatterPosts;

    // constructor
    public User(String name)
    {
        setName(name);
        chatterPosts = new ArrayList<ChatterPost>();
    }

    // setters and getters
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts)
    {
        for (ChatterPost post : chatterPosts)
        {
            this.chatterPosts.add(post);
        }
    }

    public List<ChatterPost> getChatterPosts()
    {
        return chatterPosts;
    }
}
