package com.pet.supplies.common.mapper;

import com.pet.supplies.common.domain.Image;
import com.pet.supplies.common.model.ImageModel;

import com.pet.supplies.common.domain.Product;
import com.pet.supplies.common.model.ProductModel;
import java.util.Random;
import com.pet.supplies.common.constants.BusinessConstants;
import com.pet.supplies.common.domain.AdminOrSeller;
import com.pet.supplies.common.model.AdminOrSellerModel;
import org.apache.commons.collections.CollectionUtils;
import java.util.Collections;
import com.pet.supplies.common.domain.Address;
import com.pet.supplies.common.domain.CartItem;
import com.pet.supplies.common.domain.Orders;
import com.pet.supplies.common.domain.User;
import com.pet.supplies.common.domain.AuthenticateUser;
import com.pet.supplies.common.model.AddressModel;
import com.pet.supplies.common.model.AuthenticateUserModel;
import com.pet.supplies.common.model.CartItemModel;
import com.pet.supplies.common.model.OrdersModel;
import com.pet.supplies.common.model.UserModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public class ModelToEntityMapper
{
   /**
    * TODO
    * 
    * @param model
    * @return
    */
   public static CartItem mapCartItemModelToCartItemEntity(CartItemModel model)
   {
      CartItem cartItem = new CartItem();
      if (model != null)
      {
         cartItem.setProductId(model.getProductId());
         cartItem.setQuantity(model.getQuantity());
         cartItem.setProductName(model.getProductName());
         cartItem.setPrice(model.getPrice());
         cartItem.setCurrency(model.getCurrency());
      }
      return cartItem;
   }

   /**
    * TODO
    * 
    * @param models
    * @return
    */
   public static Set<Orders> mapOrderModelsToOrderEntities(List<OrdersModel> models)
   {
      Set<Orders> orders = new HashSet<Orders>();
      if (CollectionUtils.isNotEmpty(models))
      {
         models.forEach(model -> {
            orders.add(mapOrderModelToOrderEntitity(model));
         });
      }
      return orders;
   }

   /**
    * TODO
    * 
    * @param orders
    * @param model
    */
   public static Orders mapOrderModelToOrderEntitity(OrdersModel model)
   {
      Orders order = new Orders();
      if (model == null)
      {
         return order;
      }
      order.setProductId(model.getProductId());
      order.setProductName(model.getProductName());
      order.setProductPrice(model.getProductPrice());
      order.setCurrency(model.getCurrency());
      order.setQuantity(model.getQuantity());
      order.setStatus(model.getStatus());
      order.setShippingAddress(model.getShippingAddress());
      order.setOrderDate(model.getOrderDate());
      return order;
   }

   /**
    * TODO
    * 
    * @param model
    * @return
    */
   public static AuthenticateUser mapAuthenticateUserModelToAuthenticateUserEntity(AuthenticateUserModel model)
   {
      AuthenticateUser authUser = new AuthenticateUser();
      if (model != null)
      {
         authUser.setActive(model.isActive());
         authUser.setEmailId(model.getEmailId());
         authUser.setPassword(model.getPassword());
         authUser.setPhone(model.getPhone());
         authUser.setProfile(model.getProfile());
      }
      return authUser;
   }

   /**
    * TODO
    * 
    * @param
    * @return
    */
   public static Address mapAddressModelToAddressEntity(AddressModel model)
   {
      Address entity = new Address();
      if (model != null)
      {
         entity.setAddress(model.getAddress());
         entity.setCity(model.getCity());
         entity.setState(model.getState());
         entity.setZipCode(model.getZipCode());
         entity.setEmail(model.getEmail());
         entity.setPhone(model.getPhone());
         entity.setCountry(model.getCountry());
      }
      return entity;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static User mapUserModelToUserEntity(UserModel model)
   {
      User user = new User();
      if (model != null)
      {
         user.setAddress(mapAddressModelToAddressEntity(model.getAddress()));
         user.setName(model.getName());
      }
      return user;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static User prepateUserEntity(AuthenticateUserModel model)
   {
      User user = new User();
      if (model != null)
      {
         user.setName(model.getUserName());
      }
      return user;
   }

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static AdminOrSeller prepateSellerEntity(AdminOrSellerModel model)
   {
      AdminOrSeller seller = new AdminOrSeller();
      if (model != null)
      {
         seller.setActive(model.isRegister());
         seller.setEmailId(model.getEmailId());
         seller.setPhone(model.getPhone());
         seller.setCode(generateSellerCode());
         seller.setName(model.getName());
         seller.setPassword(model.getPassword());
      }
      return seller;
   }

   public static String generateSellerCode()
   {
      String prefix = BusinessConstants.SELLER_PREFIX;
      Random random = new Random();
      int i = random.nextInt(10);
      return prefix + i;
   }

   public static Product mapProductModelToProductEntity(ProductModel model)
   {
      Product product = new Product();
      if (model != null)
      {
         product.setName(model.getProductName());
         product.setCurrency(model.getCurrency());
         product.setDesc(model.getDesc());
         product.setPrice(model.getPrice());
         product.setQuantity(model.getQuantity());
         product.setStatus(model.getStatus());
         product.setImageUrls(mapImageModelsToImageEntities(model.getImageUrls(),product));
      }
      return product;
   }

   public static Set<Image> mapImageModelsToImageEntities(Set<ImageModel> imageUrls,Product product)
   {
      Set<Image> images = new HashSet<Image>();
      if (CollectionUtils.isNotEmpty(imageUrls))
      {
         imageUrls.forEach(imageModel -> {
            images.add(mapImageModelToImageEntity(imageModel,product));
         });
      }
      return images;
   }

   /**
    * TODO
    * 
    * @param imageModel
    * @return
    */
   public static Image mapImageModelToImageEntity(ImageModel imageModel,Product product)
   {
      Image newImage = new Image();
      if (imageModel != null)
      {
         newImage.setName(imageModel.getName());
         newImage.setUrl(imageModel.getUrl());
         newImage.setProduct(product);
      }
      return newImage;
   }

}
