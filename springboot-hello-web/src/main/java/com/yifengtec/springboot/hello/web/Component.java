//package com.yifengtec.springboot.hello.web;
//
//import java.io.IOException;
//
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.validation.DefaultMessageCodesResolver;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//
//@JsonComponent
//public class Component {
//	
//	 public static class Serializer extends JsonSerializer<Object>{
//
//		@Override
//		public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
//				throws IOException, JsonProcessingException {
//			// TODO Auto-generated method stub
//		}
//		 
//	 }
//	 
//	 public static class Deserializer extends JsonDeserializer<Object>{
//
//		@Override
//		public Object deserialize(JsonParser arg0, DeserializationContext arg1)
//				throws IOException, JsonProcessingException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		 
//	 }
//}
