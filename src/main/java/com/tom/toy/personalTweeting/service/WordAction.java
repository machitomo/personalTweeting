package com.tom.toy.personalTweeting.service;

/**
 * 文字列に対するアクションを書く。
 * ex) 禁止文字列の検出等、特定文字列のマスク（****に置き換え）等
 */

public class WordAction {
    private String word;
    private int word_count;
    private int word_limit = 140; // デフォルト140文字

    public String getWord() {
        return word;
    }
    public int getWord_count() {
        return word_count;
    }
    public int getWord_limit() {
        return word_limit;
    }

    public void setWord(String word) {
        this.word = word;
    }
    public void setWord_count(int word_count) {
        this.word_count = word_count;
    }
    public void setWord_limit(int word_limit) {
        this.word_limit = word_limit;
    }

    /**
     * 文字列精査
     */
    public boolean wordCheck() {
        if (word.isEmpty()){
            String err_word = "コメントがありません。";

            LogUtils.error(err_word);
            System.err.println(err_word);
            return false;
        }else{
            return true;
        }
    }

    /**
     * 文字数が制限値を超えているかどうかの検査
     */
    public boolean wordCount(){
        if (word.length() > this.word_limit){
            String err_word = "コメント文字数が" + this.word_limit + "文字を超えています。";

            LogUtils.error(err_word);
            System.err.println(err_word);
            return false;
        }else{
            this.word_count = this.word.length();
            return true;
        }
    }
}
