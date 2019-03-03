package com.ynet.fullview.controller;

import com.ynet.fullview.model.Comment;
import com.ynet.fullview.service.CommentService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 22:36
 * Description: No Description
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/addComment")
    public JsonResult addCommnet(Comment comment){
        commentService.addCommnet(comment);
        return new JsonResult();
    }

    @RequestMapping("/deleteComment")
    public JsonResult deleteCommnet(Comment comment){
        commentService.deleteCommnet(comment);
        return new JsonResult();
    }

    @RequestMapping("/updateComment")
    public JsonResult upateCommnet(Comment comment){
        commentService.upateCommnet(comment);
        return new JsonResult();
    }

    @RequestMapping("/queryComment")
    public JsonResult queryComment(Comment comment){
        return new JsonResult(commentService.queryComment(comment));
    }

}

