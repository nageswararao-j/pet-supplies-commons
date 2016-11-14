package com.pet.supplies.exception;

import java.util.Map;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public class FunctionalRunTimeException extends RuntimeException
{
   /**
    * <code>serialVersionUID</code> indicates/is used for.
    */
   private static final long serialVersionUID = 1L;

   private Map<String, String> exceptionsMap;

   public FunctionalRunTimeException(String message)
   {
      super(message);
   }

   public FunctionalRunTimeException(String message, Throwable cause)
   {
      super(message, cause);
   }

   public FunctionalRunTimeException(String message, Throwable cause, Map<String, String> exceptionsMap)
   {
      super(message, cause);
      this.exceptionsMap = exceptionsMap;
   }

   public FunctionalRunTimeException(String message, Map<String, String> exceptionsMap)
   {
      super(message);
      this.exceptionsMap = exceptionsMap;
   }

   /**
    * Get the exceptionsMap.
    *
    * @return Returns the exceptionsMap as a Map<String,String>.
    */
   public Map<String, String> getExceptionsMap()
   {
      return exceptionsMap;
   }
}
