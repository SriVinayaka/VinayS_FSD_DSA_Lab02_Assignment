/**
 * 
 */
package com.gl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 */
public class SkyScrapperTest003 {

	/**
	 * @param args
	 */
	
	private ArrayList<Integer> floor_queue;
	private Integer[] priority;
	private String[] my_floor_values;
	
	public void read_array_data()
	{
		Scanner scr = new Scanner(System.in);
		int i = 1;
		Integer value = 0;
		int no_of_floors = 0;
		
		System.out.println("Enter the no of floors:");
		no_of_floors = scr.nextInt();
		
		priority = new Integer[no_of_floors];
		floor_queue = new ArrayList<Integer>();
		
		for(i = 1; i <= no_of_floors; i++)
		{
			System.out.println("Enter Day " + i + " floor size:");
			value = scr.nextInt();
			floor_queue.add(i-1, value);
			priority[i-1] = value;
			
		}
		Arrays.sort(priority, Comparator.reverseOrder());
		
		for(i = 0; i < no_of_floors; i++)
		{
			System.out.println(priority[i]);
		}
	}
	
	public void arrange_floor_data()
	{
		int i = 0;
		int j = 0;
		int size = 0;
		Integer max_value = 0;
		Integer floor_value1;
		//Integer floor_value2;
		
		size = priority.length;
		System.out.println(size);
		my_floor_values = new String[size];
		
		/*
		Integer[] new_priority = priority.clone();
		Arrays.sort(new_priority);
		for(int k = 0; k < size; k++)
		{
			System.out.println(new_priority[k]);
		}
		*/
		
		for(i=0; i < size; i++)
		{
			my_floor_values[i] = "";
			max_value = priority[i];

			for(j=0; j < size; j++)
			{
				floor_value1 = floor_queue.get(j);
				//System.out.println("Floor Value: =" + floor_value1);
				//floor_value2 = floor_queue.get(j+1);
				if((max_value == floor_value1))// && (i == j))
				{
						
						if(i == 0)
						{
							my_floor_values[i] += "Completed " + floor_value1.toString();
						}
						else if((my_floor_values[i].equals("")) && (i != size-1))
						{
							//System.out.println(1);
							my_floor_values[i] += "Waiting for " + floor_value1.toString();
							//break;							
						}
						/*
						else if(!(my_floor_values[i].equals("")))// && (i == j))
						{
							//System.out.println(1);
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
							//break;							
						}
						*/
						
						else if(i == size-1)
						{
							if(my_floor_values[i].equals(""))
							{
								my_floor_values[i] += "completed " + floor_value1.toString();
							}
							else
							{
								my_floor_values[i] += ", Completed " + floor_value1.toString();
							}
						}
						else if(i < size-1)
						{
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
						}
						else
						{
							my_floor_values[i] += ", Waiting for " + floor_value1.toString();
						}
				}
				else if(max_value > floor_value1)
				{
					//my_floor_values[i] += ", " + floor_value1.toString();
					////my_floor_values[i] += ", Waiting for " + floor_value1.toString();
				}
				else if(max_value < floor_value1)
				{
					if(my_floor_values[i].equals(""))
					{
						my_floor_values[i] += "completed " + floor_value1.toString();
					}
					else
					{
						my_floor_values[i] += ", Completed " + floor_value1.toString();
					}
				}
				else
				{
					my_floor_values[i] += ", Completed " + floor_value1.toString();
				}
				//System.out.println(j);

			}
			String myval = my_floor_values[i];
			System.out.printf("Day %d %s\n", i+1, myval);
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SkyScrapperTest003 sst = new SkyScrapperTest003();
		sst.read_array_data();
		sst.arrange_floor_data();
	}

}
