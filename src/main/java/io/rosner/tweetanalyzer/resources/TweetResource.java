package io.rosner.tweetanalyzer.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.twitter.Extractor;
import com.twitter.Extractor.Entity;
import com.yammer.metrics.annotation.Timed;


@Path("/tweet")
public class TweetResource {
    private final Extractor extractor;
	
	public TweetResource() {
		extractor = new Extractor();
		extractor.setExtractURLWithoutProtocol(true);
    }

    @POST
    @Timed
    @Path("/analyze.json")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, List<Entity>> analyzeTweet(@FormParam("tweet_text") String tweetText) {
    	Map<String,List<Entity>> result = new HashMap<String, List<Entity>>();
    	List<Entity> hashtags = extractor.extractHashtagsWithIndices(tweetText);
    	List<Entity> mentionedScreennames = extractor.extractMentionsOrListsWithIndices(tweetText);
    	List<Entity> urls = extractor.extractURLsWithIndices(tweetText);
    	result.put("hashtags", hashtags);
    	result.put("screennames", mentionedScreennames);
    	result.put("urls", urls);
    	return result;
    }

}