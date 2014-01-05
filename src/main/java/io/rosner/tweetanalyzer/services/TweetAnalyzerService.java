package io.rosner.tweetanalyzer.services;

import io.rosner.tweetanalyzer.TweetAnalyzerConfiguration;
import io.rosner.tweetanalyzer.resources.TweetResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class TweetAnalyzerService extends Service<TweetAnalyzerConfiguration> {
	public static void main(String[] args) throws Exception {
		new TweetAnalyzerService().run(args);
	}

	@Override
	public void initialize(Bootstrap<TweetAnalyzerConfiguration> bootstrap) {
		bootstrap.setName("tweet-analyzer-ws");
	}

	@Override
	public void run(TweetAnalyzerConfiguration configuration,
			Environment environment) throws Exception {
		environment.addResource(new TweetResource());
	}
}