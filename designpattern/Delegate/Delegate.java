package designpattern.Delegate;

public class Delegate {
    //骤1
    //创建业务服务接口。
    //业务服务.java
    //public interface BusinessService {
    //   public void doProcessing();
    //}
    //第2步
    //创建具体的服务类。
    //EJBService.java
    //public class EJBService implements BusinessService {
    //   @Override
    //   public void doProcessing() {
    //      System.out.println("Processing task by invoking EJB Service");
    //   }
    //}
    //JMSService.java
    //public class JMSService implements BusinessService {
    //   @Override
    //   public void doProcessing() {
    //      System.out.println("Processing task by invoking JMS Service");
    //   }
    //}
    //第 3 步
    //创建业务查找服务。
    //业务查找程序
    //public class BusinessLookUp {
    //   public BusinessService getBusinessService(String serviceType){
    //
    //      if(serviceType.equalsIgnoreCase("EJB")){
    //         return new EJBService();
    //      }
    //      else {
    //         return new JMSService();
    //      }
    //   }
    //}
    //第四步
    //创建业务委托。
    //业务委托.java
    //public class BusinessDelegate {
    //   private BusinessLookUp lookupService = new BusinessLookUp();
    //   private BusinessService businessService;
    //   private String serviceType;
    //   public void setServiceType(String serviceType){
    //      this.serviceType = serviceType;
    //   }
    //   public void doTask(){
    //      businessService = lookupService.getBusinessService(serviceType);
    //      businessService.doProcessing();
    //   }
    //}
    //第 5 步
    //创建客户端。
    //客户端.java
    //public class Client {
    //
    //   BusinessDelegate businessService;
    //   public Client(BusinessDelegate businessService){
    //      this.businessService  = businessService;
    //   }
    //   public void doTask(){
    //      businessService.doTask();
    //   }
    //}
    //第 6 步
    //使用 BusinessDelegate 和 Client 类来演示 Business Delegate 模式。
    //BusinessDelegatePatternDemo.java
    //public class BusinessDelegatePatternDemo {
    //
    //   public static void main(String[] args) {
    //      BusinessDelegate businessDelegate = new BusinessDelegate();
    //      businessDelegate.setServiceType("EJB");
    //      Client client = new Client(businessDelegate);
    //      client.doTask();
    //      businessDelegate.setServiceType("JMS");
    //      client.doTask();
    //   }
    //}
    //第 7 步
    //验证输出。
    //Processing task by invoking EJB Service
    //Processing task by invoking JMS Service
}
