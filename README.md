# What is it?
This is a simple webservice build with [yammer's dropwizard framework](http://www.dropwizard.io/) and is mainly based on @alexeypro's (dropwizard-archetype)[https://github.com/alexeypro/dropwizard-archetype].

It uses [Twitters own Java-Library](https://github.com/twitter/twitter-text-java)
to analyze tweets in case you just have the tweet text for whatever reason. 

Here is how to use it:
A simple call returns the entities that are extracted through the twitter library. 
If you need more information about this, consider reading there [docs](https://github.com/twitter/twitter-text-java).
```
curl "http://localhost:8080/tweet/analyze.json" -d "tweet_text=Hey @fancy, have you seen this project at http://github.com/rosner/tweet-analyzer-ws? #diploma #thesis"
```

And here is the simple result:
```javascript
{
    "hashtags": [
        {
            "displayURL": null,
            "end": 94,
            "expandedURL": null,
            "listSlug": null,
            "start": 86,
            "type": "HASHTAG",
            "value": "diploma"
        },
        {
            "displayURL": null,
            "end": 102,
            "expandedURL": null,
            "listSlug": null,
            "start": 95,
            "type": "HASHTAG",
            "value": "thesis"
        }
    ],
    "screennames": [
        {
            "displayURL": null,
            "end": 10,
            "expandedURL": null,
            "listSlug": null,
            "start": 4,
            "type": "MENTION",
            "value": "fancy"
        }
    ],
    "urls": [
        {
            "displayURL": null,
            "end": 84,
            "expandedURL": null,
            "listSlug": null,
            "start": 42,
            "type": "URL",
            "value": "http://github.com/rosner/tweet-analyzer-ws"
        }
    ]
}
```

# How to build an run this?
It's a maven based project, so `mvn package` builds a jar located under `target/twitter-ws-0.0.01-SNAPSHOT.jar` 
so you can run it with `java -jar target/twitter-ws-0.0.1-SNAPSHOT.jar server`.
After startup, ther service will be available under the default port of `8080` unless you change it to [your will](http://www.dropwizard.io/manual/core/#man-core-configuration).
That's all there is.
