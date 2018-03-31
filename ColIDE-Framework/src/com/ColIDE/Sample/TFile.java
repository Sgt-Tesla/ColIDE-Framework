package com.ColIDE.Sample;

import java.util.ArrayList;

public class TFile 
{
	
	private static final String LINE_INDEX_EXCEPTION = "LineIndexException: Line cannot be inserted outside of bounds!";
	
	/**
	 * The Line state for the line being unverified
	 */
	public static final byte L_UNVERIF = 0;
	
	/**
	 * The Line state for the line being local
	 */
	public static final byte L_LOCAL = 1;
	
	/**
	 * The Line state for the line being verified
	 */
	public static final byte L_VERIFIED = 2;
	
	/**
	 * The Lines in the file
	 */
	private ArrayList<Line> lines;
	
	//TODO: Make constructor
	
	
	/**
	 * Inserts a new Line into the file 
	 * @param index The index to insert the line at
	 * @param text The text of the line being inserted
	 * @param state The state of the Line being inserted (eg. The bytes above)
	 */
	public void insertLine(int index, String text, byte state)
	{
		try
		{
			Line element = new Line(text, state);
			lines.add(index, element);
		}
		catch(Exception e)
		{
			try 
			{
				throw new Exception(LINE_INDEX_EXCEPTION + " ( " + index + " ) ");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}
	
	
	/**
	 * Inserts an unverified line into the file
	 * @param index The index for the line to be inserted at
	 * @param text The text for the line
	 */
	public void insertLine(int index, String text)
	{
		this.insertLine(index, text, L_UNVERIF);
	}
	
	public void updateLine(int index, String text, byte state)
	{
		Line element = new Line(text, state);
		
		lines.set(index, element);
	}
	
	class Line
	{
		public String text;
		public byte state; 
		
		public Line(String text, byte state)
		{
			this.text = text;
			this.state = state;
		}
	}
}
