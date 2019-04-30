package com.tom.toy.personalTweeting.service;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PersonalTweeting {

    public boolean mainTweeting(PostTemplate postTemplate){

        // resourceデータの取得
        Properties props = load("twitter_config.properties");

        // パラメータデータのセッティング
        Twitter twitter = setTwitter(props);

        // ツイート内容の作成
        TweetSetting tweetSetting = new TweetSetting();
        if (!tweetSetting.setTweet(postTemplate)){
            return false;
        }

        // tweet
        tweet(tweetSetting.getTweet(),twitter);

        return true;
    }

    /**
     * パラメータの読み込み
     * @param resourceFile
     * config.properties
     */
    public static Properties load(String resourceFile){
        try (InputStream is = ClassLoader.getSystemResourceAsStream(resourceFile);
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {
            Properties props = new Properties();
            props.load(reader);
            return props;
        } catch (IOException e) {
            // TODO 何かログを出す
            // TODO 適切な例外を設計して処理する
            throw new RuntimeException(e);
        }
    }

    // twitterパラメータの作成
    // TODO 何してるかは正直よくわからん
    private static Twitter setTwitter(Properties props){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAccessToken(props.getProperty("ACCESS_TOKEN"))
                .setOAuthAccessTokenSecret(props.getProperty("ACCESS_TOKEN_SECRET"))
                .setOAuthConsumerKey(props.getProperty("CONSUMER_KEY"))
                .setOAuthConsumerSecret(props.getProperty("CONSUMER_SECRET"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        return twitter;
    }

    // tweetするとこ
    private static void tweet(String word, Twitter twitter){
        try {
            twitter.updateStatus(word);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
