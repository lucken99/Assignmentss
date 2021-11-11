package com.nagarro.util;

import java.util.Comparator;

import com.nagarro.model.TShirt;

public class RatingComparator implements Comparator<TShirt> {

	public int compare(TShirt tShirt1 , TShirt tShirt2) {
		return Double.compare( tShirt1.getRating() , tShirt2.getRating()) ;
	}
	
	
}
