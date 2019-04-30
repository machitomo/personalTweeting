package com.tom.toy.personalTweeting.controller;

import com.tom.toy.personalTweeting.service.PersonalTweeting;
import com.tom.toy.personalTweeting.service.PostTemplate;
import com.tom.toy.personalTweeting.service.TweetSetting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RestTweetController {

    @RequestMapping("test")
    private String hello(){
        return "Test Page";
    }

    /**
     * 登録
     * @param data
     * @return
     */
    @RequestMapping(value="/tweet", method=RequestMethod.POST)
    private String create(@RequestBody PostTemplate data){
        PersonalTweeting personalTweeting = new PersonalTweeting();
        if (personalTweeting.mainTweeting(data)){
            return "送信されました。";
        }else {
            return "送信されませんでした。ログを確認ください。";
        }

    }

    /**
     * 参照
     * @param id
     * @return
     */
    @RequestMapping(value="/resource/{id}", method=RequestMethod.GET)
    private String read(@PathVariable String id){
        return "参照だよ。";
    }

    /**
     * 削除
     * @param id
     * @return
     */
    @RequestMapping(value = "/resouce/{id}", method = RequestMethod.DELETE)
    private String delete(@PathVariable String id){
        return "削除だよ。";
    }

    /**
     * 更新
     * @param id
     * @param data
     * @return
     */
    @RequestMapping(value = "/resouse/{id}",method = RequestMethod.PUT)
    private String update(@PathVariable String id, @RequestBody String data){
        return "更新だよ。";
    }

}