/**
 * 
 */
package com.technical99.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.technical99.entity.entityenum.BatchStatusEnum;
import com.technical99.entity.entityenum.BatchTypeEnum;
import com.technical99.entity.entityenum.LiveStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SHYAM
 *
 */

@Entity
@Table(name = "BatchMaster")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonPropertyOrder({ "Id", "CourseId", "BatchType", "Duration", "RemDays", "StartDate", "EndDate", "StartTime",
		"EndTime", "Status", "LiveStatus", })
public class BatchMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BatchId")
	private Long id;

	@Column(name = "CourseId")
	private Long courseId;

	@Column(name = "batchType")
	@Enumerated(EnumType.STRING)
	private BatchTypeEnum batchType;

	@Column(name = "StartTime")
	private String startTime;

	@Column(name = "EndTime")
	private String endTime;


	@Column(name = "Duration")
	private int duration;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private BatchStatusEnum status;

	@Column(name = "LiveStatus")
	@Enumerated(EnumType.STRING)
	private LiveStatusEnum liveStatus;

	@Column(name = "StartDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;

	@Column(name = "EndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	// @Column(name = "RemDays")
	@Transient
	private int remDays;

	@Column(name = "Month")
	private String month;
	
	public String getBatchType() {
		return (Objects.isNull(batchType) ? ""
				: batchType == BatchTypeEnum.WE ? "Saturday - Sunday" : "Monday To Friday");
	}

//	public int getDuration() {
//		return (int) (Objects.isNull(endDate)||Objects.isNull(startDate) ? 0 : ChronoUnit.DAYS.between(startDate, endDate));
//	}
//	
//	public int getRemDays() {
//		return (int) (Objects.isNull(endDate) ? 0 : ChronoUnit.DAYS.between(LocalDate.now(), endDate));
//	}

	
//	
//	public String getMonth() {	
//		return (String) (Objects.isNull(startDate) ? "" : startDate.getMonth());
//	}
}
