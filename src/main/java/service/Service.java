package service;

import annot.CustomDateFormat;
import annot.JsonValue;
import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;



public class Service {

    public String convertToJson(Object object) throws IllegalAccessException {
        Class objectToString = object.getClass();

        Field[] privateFieldsOfObject = objectToString.getDeclaredFields();
        StringBuilder forJson = new StringBuilder();
        forJson.append("{");
        for (int i=0; i<privateFieldsOfObject.length;i++ ) {
            Field field = privateFieldsOfObject[i];
            field.setAccessible(true);

            if (field.get(object)==null || field.get(object).toString().equals(null)){
                continue;
            }

            String  value = field.get(object).toString();


           if( field.isAnnotationPresent(JsonValue.class)) {
               forJson.append("\"" + field.getAnnotation(JsonValue.class).name() + "\"");
               forJson.append(":" + "\"" + value + "\"" + " , ");

           }
            else {
                    if(field.isAnnotationPresent(CustomDateFormat.class)){
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(field.getAnnotation(CustomDateFormat.class).format());
                 String tmpData= formatter.format((TemporalAccessor) field.get(object));
                 forJson.append("\""+field.getName() +"\"");
                 forJson.append(":" +"\"" +tmpData+ "\"" +" , ");
            } else {

                         forJson.append("\""+field.getName()+"\"");
                         forJson.append(":"+ "\""+value + "\"" +" , ");
                }
            }
            }


      if (forJson.length()>3){
          forJson.setLength(forJson.length() - 3);
      }//удаляет запятую после последнего поля класса
        forJson.append("}");
        return forJson.toString();

    }

}

