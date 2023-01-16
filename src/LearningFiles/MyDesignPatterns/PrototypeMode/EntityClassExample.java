//package LearningFiles.MyDesignPatterns.PrototypeMode;
//
//import com.sun.istack.internal.NotNull;
//import lombok.NonNull;
//
///**
// * @ClassName EntityClassExample
// * @Description 原型模式测试实体类
// * @Author zhumengren
// * @Date 2022/10/20 10:25
// * @Email zhumengren@sinosoft.com
// * @Version 1.0
// **/
//public class EntityClassExample implements Cloneable {
//    private String name;
//    private Integer age;
//    private Address address;
//
//    public EntityClassExample() {
//    }
//
//    public EntityClassExample(String name, Integer age, Address address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }
//
//    public EntityClassExample(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    @Override
//    public String toString() {
//        return "EntityClassExample{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", address=" + address +
//                '}';
//    }
//
//    ///** 浅拷贝 */
//    //@Override
//    //@NonNull
//    //@NotNull
//    //// 浅拷贝
//    //public EntityClassExample clone() {
//    //    try {
//    //       return (EntityClassExample) super.clone();
//    //    } catch (CloneNotSupportedException e) {
//    //        e.printStackTrace();
//    //    }
//    //    return null;
//    //}
//    //
//    //public class Address{
//    //    // 地市
//    //    public String city;
//    //    // 区县
//    //    public String county;
//    //    // 乡镇街道
//    //    public String street;
//    //}
//
//
//
//    /** 深拷贝 */
//    @Override
//    @NonNull
//    @NotNull
//    // 深拷贝
//    public EntityClassExample clone() {
//        try {
//            EntityClassExample cloneEntity = (EntityClassExample) super.clone();
//            cloneEntity.setName(this.name);
//            cloneEntity.setAddress(this.address.clone());
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public class Address implements Cloneable {
//        // 地市
//        private String city;
//        // 区县
//        private String county;
//        // 乡镇街道
//        private String street;
//
//        public Address() {
//        }
//
//        public Address(String city, String county, String street) {
//            this.city = city;
//            this.county = county;
//            this.street = street;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getCounty() {
//            return county;
//        }
//
//        public void setCounty(String county) {
//            this.county = county;
//        }
//
//        public String getStreet() {
//            return street;
//        }
//
//        public void setStreet(String street) {
//            this.street = street;
//        }
//
//        @Override
//        public String toString() {
//            return "Address{" +
//                    "city='" + city + '\'' +
//                    ", county='" + county + '\'' +
//                    ", street='" + street + '\'' +
//                    '}';
//        }
//
//
//        @Override
//        @NonNull
//        @NotNull
//        public Address clone() {
//            try{
//                Address newAddress = (Address)super.clone();
//                newAddress.city = this.city;
//                newAddress.county = this.county;
//                newAddress.street = this.street;
//                return newAddress;
//            }catch (CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
//
//
//}
