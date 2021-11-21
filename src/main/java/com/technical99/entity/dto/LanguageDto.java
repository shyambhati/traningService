package com.technical99.entity.dto;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.technical99.entity.entityenum.StatusEnum;
import lombok.Data;

@Data
public class LanguageDto {

	private int LangId;

	private String Name;

	@Enumerated(EnumType.STRING)
	StatusEnum status;

	private int Ordering;

	private int learners;

}
