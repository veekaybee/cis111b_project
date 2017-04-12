package com.devsnearme.app;

import org.apache.http.client.fluent.Request;
import org.json.*;

import java.io.IOException;

/**
 * Created by vboykis on 4/9/17.
 */
public class GetGitHubProfiles {

    public static void main(String[] args) throws IOException {

        GetGitHubProfiles profiles = new GetGitHubProfiles();

        profiles.getProfiles();
    }


    public String getProfiles() throws IOException {
        String response =Request.Get("https://api.github.com/search/users?q=location:Philadelphia")
                .execute().returnContent().asString();
        System.out.println(response);
        return response;
    }

    public String parseJSON(){

        JSONObject obj = new JSONObject(" .... ");
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++)
        {
            String post_id = arr.getJSONObject(i).getString("post_id");

        }

        return "";

    }

}
