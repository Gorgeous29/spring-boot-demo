package cn.webim.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -7720113192947811738L;

    @Size(max = 18, message = "用户名不能超过18个字符")
    @NotNull
    @Column(unique = true)
    private String username;

    @Size(max = 18, message = "密码不能超过18个字符")
    @NotNull
    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
