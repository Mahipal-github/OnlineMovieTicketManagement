package com.cg.moviemanagement.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*************************************************************************************************************************
 *          @author          Arshad, Poojith, Mahipal 
 *          Description      It is a convertor class, which converts LocalDate into SQL Date, for data being injected to databases
 *          				 and SQL date to  LocalDate for data being called from database to the app.
 *         Version             1.0
 *         Created Date    02-SEP-2020
 *************************************************************************************************************************/

@Converter(autoApply = true)
public class LDTConventer implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate ldt) {
		if (ldt != null)
			return Date.valueOf(ldt); //convert LocalDate into java.sql.Date
		return null;
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqldt) {
		if (sqldt != null)
			return sqldt.toLocalDate();
		return null;
	}


}
