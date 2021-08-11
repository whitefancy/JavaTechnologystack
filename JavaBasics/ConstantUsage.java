package JavaBasics;

public class ConstantUsage {
    //常量类
    //第一种使用接口：
    //public interface Constants{
    //public static final int AUDIT_STATUS_PASS = 1;
    //public static final int AUDIT_STATUS_NOT_PASS = 2;
    //}
    //第二种使用类:
    //public class Constans{
    //public static final int AUDIT_STATUS_PASS = 1;
    //public static final int AUDIT_STATUS_NOT_PASS = 2;
    //}
    //第三种使用枚举:
    //public enum Constants {
    //AUDIT_STATUS_PASS(1),
    //AUDIT_STATUS_NOT_PASS(2);
    //private int status;
    //private Constants(int status){
    //this.setStatus(status);
    //}
    //public int getStatus() {
    //return status;
    //}
    //public void setStatus(int status) {
    //this.status = status;
    //}
    //}
    //第一种和第二种是一样的，第一种写起来更方便，不用 public static final ，直接 int AUDIT_STATUS_PASS = 1 就行。第三种好在能把说明也写在里面。
    //建议使用枚举。《Effective Java》中也是推荐使用枚举代替 int 常量的。
    //枚举当然是首选，另如果不用枚举，在《Effective Java》一书中，作者建议使用一般类加私有构造方法的方式，至于为什么不用接口，那就要上升到语言哲学问题了。
    //public class Constants {
    //private Constants() {}
    //public static final int AUDIT_STATUS_PASS = 1;
    //public static final int AUDIT_STATUS_NOT_PASS = 2;
}
