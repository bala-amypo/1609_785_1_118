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
    // @Override
   
    // public List<validationEntity>getdata(){
    //     return valid.findAll();
    // }
    // @Override
    // public String deletedata(long id){
    //     valid.deleteById(id);
    //     return "deleted successfully";
    // }
    @Override
    public validationEntity putgetdata(long id){
       return valid.findById(id).orElseThrow()->new ValidationException(null);
    }
//     @Override
//     public validationEntity putupdatedata(long id,validationEntity std){
//         if(valid.existsById(id)){//checking where it isprsent or not in spfici row
//             std.setId(id);//settting the value to that roe
//             return valid.save(std);//return the value
//         }
//         return null;
//     }
   

// }/