package com.springrest.springrest.user.Customannotations;

//import java.util.Arrays;
//import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class NameConstraintValidator  implements ConstraintValidator<NameCustom,String>{
	
	private String regex = "^[a-zA-Z]*$";
             
			 @Override
			 public boolean isValid(String name, ConstraintValidatorContext context) {
			 if (StringUtils.isBlank(name))
			 return true;

			 Pattern pat = Pattern.compile(regex);
			 return pat.matcher(name).matches() ;
	/*
	List<String> name = Arrays.asList("Parth","Ekta","Promod") ;
	@Override
	 public boolean isValid(String value, ConstraintValidatorContext context) {
	    return name.contains(value) ;
    }  */
	
}
}
			 


