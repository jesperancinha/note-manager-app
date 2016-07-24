package com.steelzack.titletextadder.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "titles")
public class TitleEntity {

	@Id
	@Column(name = "title_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "title_text")
	private String text;

	@Column(name = "title_submission_date")
	private Date date;

	@Column(name = "title_text_score")
	private Integer score;

}
