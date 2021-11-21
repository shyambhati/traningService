/**
 * 
 */
package com.technical99.entity.dto;

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


@Data
@JsonPropertyOrder({ "Id",   "BatchType",   "RemDays", "StartDate", "EndDate", })
public class BatchMasterDto {

	private Long id;
	private String batchType;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate startDate;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate endDate;
	private int remDays;

}
