package com.usa.project.service;
import com.usa.project.model.Cabin;
import com.usa.project.model.custom.YearAmount;
import com.usa.project.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CabinService {
    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin> e= cabinRepository.getCabin(cabin.getId());
            if(e.isEmpty()){
                return cabinRepository.save(cabin);
            }else{
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e= cabinRepository.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                cabinRepository.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int id) {
        Boolean aBoolean = getCabin(id).map(costume -> {
            cabinRepository.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<YearAmount> getTopCabinByYear(){
        List<Object[]> report= cabinRepository.getTopByYear();
        List<YearAmount>res=new ArrayList<>();
        for(int i=0;i<report.size();i++){
            res.add(new YearAmount((int)report.get(i)[0],(int) report.get(i)[1]));
        }
        return res;
    }
}

