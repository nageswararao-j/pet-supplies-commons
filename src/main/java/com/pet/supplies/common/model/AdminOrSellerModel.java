package com.pet.supplies.common.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Setter
@Getter
public class AdminOrSellerModel implements Serializable
{

   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Long id;

   private String name;

   private String emailId;

   private String phone;

   private String password;

   private boolean active;
   
   private AddressModel address;

   private boolean register;
   
   private boolean isPresent;

}
