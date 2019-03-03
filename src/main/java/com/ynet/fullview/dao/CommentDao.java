package com.ynet.fullview.dao;

import com.ynet.fullview.model.Comment;
import com.ynet.fullview.util.JsonResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 22:48
 * Description: No Description
 */
@Repository
public interface CommentDao {
    public JsonResult addCommnet(Comment comment);

    public JsonResult deleteCommnet(Comment comment);

    public JsonResult upateCommnet(Comment comment);

    public List<Comment> queryComment(Comment comment);
}
