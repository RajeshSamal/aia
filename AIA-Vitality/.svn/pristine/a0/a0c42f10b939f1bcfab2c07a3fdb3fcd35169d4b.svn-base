package com.aia.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ColumnHeader {
	
	static Logger logger = Logger.getLogger(ColumnHeader.class);
	private static List<String> columnList = new ArrayList<String>();
	private static final String MEMBER_FIRST_NAMES = "MEMBER_FIRST_NAMES";
	private static final String MEMBER_SURNAME = "MEMBER_SURNAME";
	private static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
	private static final String AIA_VITALITY_MEMBER_NUMBER = "AIA_VITALITY_MEMBER_NUMBER";
	private static final String VITALITY_STATUS = "VITALITY_STATUS";
	private static final String ENTITY_REFERENCE_NUMBER = "ENTITY_REFERENCE_NUMBER";
	private static final String LANGUAGE_PREFERENCE = "LANGUAGE_PREFERENCE";
	private static final String RECORD_STATUS = "RECORD_STATUS";
	
 
	public static List<String> getColumnHeader()
	{
		if(!columnList.isEmpty())
		{
			return columnList;
		}
		else
		{
			columnList.add(MEMBER_FIRST_NAMES);
			columnList.add(MEMBER_SURNAME);
			columnList.add(EMAIL_ADDRESS);
			columnList.add(AIA_VITALITY_MEMBER_NUMBER);
			columnList.add(VITALITY_STATUS);
			columnList.add(ENTITY_REFERENCE_NUMBER);
			columnList.add(LANGUAGE_PREFERENCE);
			columnList.add(RECORD_STATUS);
			return columnList;
		}
		
	}

}
