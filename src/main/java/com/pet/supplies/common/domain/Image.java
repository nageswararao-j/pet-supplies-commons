package com.pet.supplies.common.domain;

import lombok.Setter;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Entity
@Setter
@Getter
@Table(name = "IMAGE")
public class Image
{
   @Id
   @GeneratedValue
   @Column(name = "IMG_ID")
   private int img_id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "URL")
   private String url;

   public Image()
   {

   }

   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;

}
