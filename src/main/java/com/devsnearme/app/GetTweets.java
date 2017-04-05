package com.devsnearme.app;

import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Queries Twitter for tweets with specific keyword within 100 miles of Philly
 * Prints out tweets that are geotagged
 */
public class GetTweets {


    public static void main(String[] args) throws TwitterException, IOException {

        Properties prop = new Properties();
        prop.load(GetTweets.class.getClassLoader().getResourceAsStream("twitter4j.properties"));


        //Twitter login keys

        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.setOAuthConsumerKey(prop.getProperty("oauth.consumerKey"));
        builder.setOAuthConsumerSecret(prop.getProperty("oauth.consumerSecret"));
        builder.setOAuthAccessToken(prop.getProperty("oauth.accessToken"));
        builder.setOAuthAccessTokenSecret(prop.getProperty("oauth.accessTokenSecret"));
        Configuration configuration = builder.build();



        TwitterFactory factory = new TwitterFactory(configuration);
        Twitter twitter = factory.getInstance();


        //Philly
        Query query = new Query("Spark").geoCode(new GeoLocation(39.9526, 75.1652), 100, Query.Unit.mi.name());
        query.count(100);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }



    }





}
