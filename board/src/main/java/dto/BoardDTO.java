package dto;

import java.sql.Date;

import lombok.Data;

// @Data == @Getter, @Setter, @EqulsAndHashCode, @toString, @NoArgsContructors




@Data
public class BoardDTO {
private int bno;
private String name;
private String title;
private String content;
private String attach;
private int re_ref;
private int re_lev;
private int re_seq;
private int readcnt;
private Date regdate;
private String password;

}
