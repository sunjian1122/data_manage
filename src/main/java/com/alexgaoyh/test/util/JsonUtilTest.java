package com.alexgaoyh.test.util;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonFilter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

/**
 *  json 数据过滤 
 *  防止在数据实体进行json化的时候，出现多余数据量，对多余数据量的数据进行过滤
 * @author alexgaoyh
 *
 */
@JsonFilter("myFilter")
public class JsonUtilTest {

	private String name = "alexgaoyh";  

	private String website = "http://my.oschina.net/alexgaoyh";
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public static void main(String[] args) throws IOException {  
    	JsonUtilTest value = new JsonUtilTest();  
  
        ObjectMapper mapper = new ObjectMapper();
        
        // first, construct filter provider to exclude all properties but 'name', bind it as 'myFilter'  
        FilterProvider filtersExpect = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept(getFilter(value)));  
        // and then serialize using that filter provider:  
        String jsonExpect = mapper.filteredWriter(filtersExpect).writeValueAsString(value);  
        System.out.println(jsonExpect);
        
        //排除不想要的属性  用来解决对象间循环关联的情况的
        FilterProvider filtersAll = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.serializeAllExcept(getFilter(value)));  
        String jsonAll = mapper.filteredWriter(filtersAll).writeValueAsString(value);  
        System.out.println(jsonAll);
    }  
  
    private static Set<String> getFilter(JsonUtilTest value) {  
        Set<String> set = new HashSet<String>();  
        if (value.getName() != null) {  
            set.add("name");  
        }  
        return set;  
    }  
}
