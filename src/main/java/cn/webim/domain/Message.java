package cn.webim.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2274357989971584911L;

    @Size(max = 255)
    @NotNull
    @Column
    private String content;

    @ManyToOne(targetEntity = User.class, optional = false)
    private User sender;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
