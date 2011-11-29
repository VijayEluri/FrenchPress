/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.steeplesoft.frenchpress.beans;

import com.steeplesoft.frenchpress.model.Post;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;

/**
 *
 * @author jdlee
 */
@Model
public class PostBean {

    @Inject
    private PostService postService;
    private Post post = new Post();
    private HtmlDataTable dataTable;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getPosts(int limit) {
        return postService.getPosts(limit);
    }

    public void loadPost() {
        post = postService.getPost(post.getId());
    }

    public String update() {
        Post savedPost = postService.getPost(post.getId());
        if (savedPost == null) {
            throw new RuntimeException("Post not found.  Id: " + post.getId());
        } else {
            if (savedPost.getVersion() > post.getVersion()) {
//                throw new MidErrorCollisionException();
            } else {
                postService.updatePost(post);
                return "/admin/index?faces-redirect=true";
            }
        }

        return null;
    }

    public String save() {
        postService.createPost(post);
        return "/admin/index?faces-redirect=true";
    }
    
    public String delete() {
        Post post = (Post)dataTable.getRowData();
        postService.deletePost(post);
        
        return null;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }
}