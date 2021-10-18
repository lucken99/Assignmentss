package com.lalit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, String> {
    @Query("SELECT t FROM TShirt t WHERE t.availability='Y' and t.colour LIKE %?1%"
            + " AND t.genderRecommendation LIKE %?2%"
            + " AND t.size LIKE %?3%")
    public List<TShirt> search(String color, String gender, String size);
}
