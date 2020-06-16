package cn.com.sm.utils;

/**
 * @Auther: Lee
 * @Date: 6/15/2020 9:11 AM
 * @Software: IntelliJ IDEA
 * @Description:
 */
public class Constants {
    public static final String AUTHORIZATION = "Authorization";
    public static enum USER_TYPE{
        USER("0","USER"),ADMIN("1","ADMIN");
        private String type;

        private String type_name;

        private USER_TYPE(String type,String type_name){
            this.type = type;
            this.type_name = type_name;
        }

        public String getType() {
            return type;
        }

        public String getType_name() {
            return type_name;
        }
    }
}
