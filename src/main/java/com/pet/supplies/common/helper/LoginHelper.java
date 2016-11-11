package com.pet.supplies.common.helper;

import com.pet.supplies.common.model.AdminOrSellerModel;

import com.pet.supplies.common.domain.Address;
import com.pet.supplies.common.domain.User;
import com.pet.supplies.common.mapper.EntityToModelMapper;
import com.pet.supplies.common.model.AddressModel;
import com.pet.supplies.common.model.AuthenticateUserModel;

public class LoginHelper
{
   /**
    * TODO
    * 
    * @param model
    * @return
    */
   public static boolean isModelValuesNotNull(AuthenticateUserModel model)
   {
      return model != null && (model.getEmailId() != null || model.getPhone() != null) && model.getPassword() != null;
   }
   
   /**
    * TODO
    * @param model
    * @return
    */
   public static boolean isEmailAndPwdNotNulls(AdminOrSellerModel model)
   {
      return model != null && (model.getEmailId() != null || model.getPhone() != null) && model.getPassword() != null;
   }
   
   /**
    * TODO
    * @param authModel
    * @param user
    */
   public static void setUserToAuthModelAfterLogin(AuthenticateUserModel authModel, User user)
   {
      if (user != null)
      {
         Address address = user.getAddress();
         AddressModel addressModel = EntityToModelMapper.mapAddressEntityToAddressModel(address);
         authModel.setAddress(addressModel);
         authModel.setUserName(user.getName());
      }
   }

}
