package com.tom.toy.personalTweeting.service;

public class UrlAction {
    private String url;
    private int url_count;
    private int url_limit = 140; // デフォルト140文字

    public void setUrl(String url) {
        this.url = url;
    }
    public void setUrl_count(int url_count) {
        this.url_count = url_count;
    }
    public void setUrl_limit(int url_limit) {
        this.url_limit = url_limit;
    }

    public String getUrl() {
        return url;
    }
    public int getUrl_count() {
        return url_count;
    }
    public int getUrl_limit() {
        return url_limit;
    }

    /**
     * URL文字数カウント
     */
    public boolean urlCount(){
        if (url.length() > this.url_limit){
            String err_word = "URLの文字数が１４０文字を超えています。";

            LogUtils.error(err_word);
            System.err.println(err_word);

            return false;
        }else{
            this.url_count = this.url.length();
            return true;
        }
    }

    /**
     * URLの短縮したい。
     */

    /**
     * リンク切れかどうかの精査
     */
    // TODO google系の証明書エラーに対する解決策が決まり次第作成する。
//    private static void linkCeck(String urlString){
//        URL url;
//        int response = 0;
//
//        try {
//            url = new URL(urlString);
//            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
//            connection.connect();
//            response = connection.getResponseCode();
//            connection.disconnect();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}
