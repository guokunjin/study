package cn.gkj.demo.entry;

public class User {
    private String username;

    private String nickname;

    private String pw;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("username='").append(username).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", pw='").append(pw).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw == null ? null : pw.trim();
    }
}