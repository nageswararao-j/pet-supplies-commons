package com.pet.supplies.common.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@XmlRootElement
@Getter
@Setter
public class ProductModel implements Serializable
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   public ProductModel()
   {

   }

   @XmlElement
   private Long productId;

   @XmlElement
   private String productName;

   private BigDecimal price;

   private String currency;

   private String status;

   private int quantity;

   private String desc;

   private Set<ImageModel> imageUrls;
   
   private Long sellerId;
   
   private String categoryCode;
   
}
