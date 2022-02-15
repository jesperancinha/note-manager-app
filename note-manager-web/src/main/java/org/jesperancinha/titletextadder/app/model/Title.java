package org.jesperancinha.titletextadder.app.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Title {

    private String id;

    private String title;

    private String text;

    private Date date;

    private Integer score;
}
