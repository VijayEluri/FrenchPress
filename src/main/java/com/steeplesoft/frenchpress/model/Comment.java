/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.steeplesoft.frenchpress.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jdlee
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String body;
    private String authorName;
    private String authorUrl;
    private String authorEmail;
    @ManyToOne
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if ((this.body == null) ? (other.body != null) : !this.body.equals(other.body)) {
            return false;
        }
        if ((this.authorName == null) ? (other.authorName != null) : !this.authorName.equals(other.authorName)) {
            return false;
        }
        if ((this.authorUrl == null) ? (other.authorUrl != null) : !this.authorUrl.equals(other.authorUrl)) {
            return false;
        }
        if ((this.authorEmail == null) ? (other.authorEmail != null) : !this.authorEmail.equals(other.authorEmail)) {
            return false;
        }
        if (this.author != other.author && (this.author == null || !this.author.equals(other.author))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (this.body != null ? this.body.hashCode() : 0);
        hash = 37 * hash + (this.authorName != null ? this.authorName.hashCode() : 0);
        hash = 37 * hash + (this.authorUrl != null ? this.authorUrl.hashCode() : 0);
        hash = 37 * hash + (this.authorEmail != null ? this.authorEmail.hashCode() : 0);
        hash = 37 * hash + (this.author != null ? this.author.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", body=" + body + ", authorName=" + authorName + ", authorUrl=" + authorUrl + ", authorEmail=" + authorEmail + ", author=" + author + '}';
    }
}