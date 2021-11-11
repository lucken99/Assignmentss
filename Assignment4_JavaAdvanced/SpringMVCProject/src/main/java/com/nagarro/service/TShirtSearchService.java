
package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nagarro.dao.TShirtDao;
import com.nagarro.model.TShirt;
import com.nagarro.dto.RequiredTShirtDto;
import com.nagarro.util.PriceComparator;
import com.nagarro.util.RatingComparator;

public class TShirtSearchService {

	public ArrayList<TShirt> getMatchingTShirts(RequiredTShirtDto requiredTShirtDto) {
		ArrayList<TShirt> matchedTShirts = new ArrayList<TShirt>();
		TShirtDao tShirtDao = new TShirtDao();
		List<TShirt> allTShirts = tShirtDao.getAllTShirts();

		for (TShirt tShirt : allTShirts) {

			if (tShirt.getColor().equalsIgnoreCase(requiredTShirtDto.getColor())
					&& tShirt.getSize().equalsIgnoreCase(requiredTShirtDto.getSize())
					&& tShirt.getGender().equalsIgnoreCase(requiredTShirtDto.getGender())) {
				matchedTShirts.add(tShirt);
			}
		}

		Comparator<TShirt> tShirtComparator = null;
		if (requiredTShirtDto.getSortPreference() == 1) {
			tShirtComparator = new PriceComparator();
		}

		else if (requiredTShirtDto.getSortPreference() == 2) {
			tShirtComparator = new RatingComparator();
		}

		else {
			System.out.println("Wrong Choice");
		}

		Collections.sort(matchedTShirts, tShirtComparator);

		return matchedTShirts;

	}

}
