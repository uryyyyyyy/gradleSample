package com.sample.dao.rdb;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="e_junktable")
public class Model1 {

	@Id
	public Integer id;

	public String name;

	public String description;

	@Version
	public Timestamp lastUpdate;

}