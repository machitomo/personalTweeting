package com.tom.toy.personalTweeting.service;

public class TweetSetting{
    private String tweet;
    public WordAction wordAction;
    public UrlAction urlAction;

    public String getTweet() {
        return tweet;
    }

    public boolean setTweet(PostTemplate postTemplate){
        // アクションクラスに入れる。
        wordAction = new WordAction();
        urlAction = new UrlAction();

        wordAction.setWord(postTemplate.getWord());
        urlAction.setUrl(postTemplate.getUrl());

        // 各項目の精査
        if (!check_word() || !check_url()){
            return false;
        }

        // ツイートの作成
        this.tweet = create_tweet(wordAction.getWord(),urlAction.getUrl());

        // ツイートの精査
        if (!check_all_count(140,this.tweet)){
            return false;
        }

        return true;
    }

    /**
     * 文字列のチェック
     */
    private boolean check_word(){
        if (!wordAction.wordCheck() || !wordAction.wordCount()){
            return false;
        }else{
            return true;
        }
    }

    /**
     * URLのチェック
     */
    private boolean check_url(){
        if (!urlAction.urlCount()){
         return false;
        }else {
            return true;
        }
    }

    /**
     * Tweetの作成
     * TODO ハッシュタグ等の機能を追加する可能性を考える
     * @param word
     * @param url
     * @return combo_tweet
     */
    private String create_tweet(String word,String url){
        String combo_tweet = word + "\n" + url;
        return combo_tweet;
    }

    /**
     * Tweet文字数のカウント
     * @param count_limit
     * @param tweet
     * @return tweet_count
     */
    private boolean check_all_count(int count_limit, String tweet) {

        if (tweet.length() > count_limit){
            String err_word = "コメントとURLの合計文字数が" + count_limit + "文字を超えています。";
            LogUtils.error(err_word);
            System.err.println(err_word);

            return false;
        }else{
            return true;
        }
    }

}
