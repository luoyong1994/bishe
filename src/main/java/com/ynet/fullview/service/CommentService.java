package com.ynet.fullview.service;

import com.ynet.fullview.dao.CommentDao;
import com.ynet.fullview.model.Comment;
import com.ynet.fullview.util.JsonResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 22:47
 * Description: No Description
 */
@Service
public class CommentService {
    @Resource
    private CommentDao commentDao;

    public JsonResult addCommnet(Comment comment){
        commentDao.addCommnet(comment);
        return new JsonResult();
    }

    public JsonResult deleteCommnet(Comment comment){
        commentDao.deleteCommnet(comment);
        return new JsonResult();
    }

    public JsonResult upateCommnet(Comment comment){
        commentDao.upateCommnet(comment);
        return new JsonResult();
    }

    public JsonResult queryComment(Comment comment){
        return new JsonResult(commentDao.queryComment(comment));
    }
}
