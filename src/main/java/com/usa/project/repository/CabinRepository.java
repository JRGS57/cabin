package com.usa.project.repository;

import com.usa.project.model.Cabin;
import com.usa.project.repository.crud.CabinCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabinRepository {
    @Autowired
    private CabinCrudRepository cabinCrudRepository;

    public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }

    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }

    public Cabin save(Cabin cabin){
        return cabinCrudRepository.save(cabin);
    }
    public void delete(Cabin cabin){
        cabinCrudRepository.delete(cabin);
    }

    public List<Object[]> getTopByYear(){
        return cabinCrudRepository.countTotalBoatByRooms();
    }

}
