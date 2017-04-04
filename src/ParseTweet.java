import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


/**
 * Class to parse needed data from the JSON response returned from the Twitter API
 * The resulting parsed data is used to be return with the http response to the client for rendering
 */

public class ParseTweet {

    // 3 temporary test methods to start getting data in the meantime.. will pull out later

    // Test main method
    public static void main(String[] args) {

        Twitter twitter = configureTwitterApiAccess();
        QueryResult result = testQuery(twitter);

        for (Status status : result.getTweets()) {
            // "@" + status.getUser().getScreenName() + ":" + status.getText()
            System.out.println(status.getText());
        }
    }


    // For class testing.. configure API access
    private static Twitter configureTwitterApiAccess(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(ApiConstants.CONSUMER_KEY)
                .setOAuthConsumerSecret(ApiConstants.CONSUMER_SECRET)
                .setOAuthAccessToken(ApiConstants.ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ApiConstants.ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    // Test queries to have something to parse
    private static QueryResult testQuery(Twitter twitter){
        QueryResult result = null;
        Query query = new Query("JavaEE");
        // English only
        query.setLang("en");
        // 20 miles around Philly area
        //query.setGeoCode(new GeoLocation(39.9526, 75.1652), 20, Query.Unit.mi);
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return result;
    }



    /*
        All testing boilerplate above.. actual class behavior below
     */


    // Any params needed for construction?
    public ParseTweet(){

    }

    // public/private methods that will take the JSON object for parsing as needed..
    // Don't think the class methods should touch the http response object itself so they are not coupled together


    // What properties are we wanting from each JSON object in the request?.. these will be in the request from the client to the backend routes
}
