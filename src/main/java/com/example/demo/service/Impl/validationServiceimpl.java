package com.example.demo.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.validationService;
import com.example.demo.repository.validationRepository;
import com.example.demo.entity.validationEntity;
import com.example.demo.exception.ValidationException;
import java.util.List;
@Service
public class validationServiceimpl implements validationService{
   @Autowired validationRepository valid;//  acces the method in diff files
   //save();
   //findall();
   //findById();
   //deleteById();
   //existById();
   @Override
    public validationEntity postdata(validationEntity stu){
        return valid.save(stu);
    }
    @Override
    public validationEntity putgetdata(long id){
       return valid.findById(id).orElseThrow()->new ValidationException(null);
    }
