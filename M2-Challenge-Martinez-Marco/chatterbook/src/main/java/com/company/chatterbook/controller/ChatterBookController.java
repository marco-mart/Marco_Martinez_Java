package com.company.chatterbook.controller;

import com.company.chatterbook.models.ChatterPost;
import com.company.chatterbook.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ChatterBookController
{
    private List<User> userList;


    public ChatterBookController()
    {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);

        // now we have a list of our users and their ChatterPosts

    }

    /**
     * GET route that returns a list of all users
     * @return a list of all users on ChatterBook
     */
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public List<String> getAllUsers()
    {
        ArrayList<String> users = new ArrayList<>();
        for (User user : userList)
        {
            users.add(user.getName());
        }

        return users;
    }

    /**
     * GET route that returns a single user by username
     * @return user specified in the uri
     */
    @RequestMapping(value="/users/{username}", method=RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public User getUser(@PathVariable String username)
    {
        // go through list of users
        for (User user : userList)
        {
            if (user.getName().equals(username))
            { // user found
                return user;
            }
        }

        // user does not exist
        throw new IllegalArgumentException("User does not exist.");
    }

    /**
     * GET route that returns a list of chatterPosts for a user by username.
     * @return ChatterPosts of the user specified in the uri
     */
    @RequestMapping(method=RequestMethod.GET, value="/users/{username}/chatterposts")
    @ResponseStatus(value=HttpStatus.OK)
    public List<ChatterPost> getChatterPosts(@PathVariable String username)
    {
        // go through list of users
        for (User user : userList)
        {
            if (user.getName().equals(username))
            { // user found
                return user.getChatterPosts();
            }
        }

        // user does not exist
        throw new IllegalArgumentException("User does not exist.");
    }

}
