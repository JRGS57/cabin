package com.usa.project.repository.crud;

import com.usa.project.model.Cabin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CabinCrudRepository extends CrudRepository<Cabin,Integer> {

    @Query("SELECT c.rooms, COUNT(c.rooms) from Cabin AS c group by c.rooms order by COUNT(c.rooms) DESC")
    public List<Object[]> countTotalBoatByRooms();

}
