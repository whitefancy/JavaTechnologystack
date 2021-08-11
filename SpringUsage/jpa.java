package SpringUsage;

public class jpa {
    //类上注解
    //@Entity
    //定义该类为持久化类型，并有一个对应的表
    //@Table（name=‘users’）
    //指定表名，未指定则类名即为表名
    //JPA配置中每个实体都应该有独一无二的名称
    //不同包中多个同名类需要使用name属性来区分
    //字段
    //@Id
    //标记了主键属性
    //如果列名不同，可以使用@Column注解更改名称
    //主键可以有多个列组成，称为自然主键
    //但从业务角度看，拥有单一主键列并为其分配无意义的值是比较流行的解决方案
    //好处
    //此类主键称为代理或合成主键
    //应用程序不负责生成主键值
    //新纪录插入期间由JPA供应商分配
    //java的setter、getter设计初衷一小部分原因是为了封装内部细节，但这占比非常小。
    //真正导致实体类setter、getter不可或缺的根本原因 是java中属性不能多态，只有方法可以多态。
    //动态类型语言因为没有类型系统，没有‘完整’的多态特性，所以并不需要。
    //Id生成策略
    //标识
    //序列
    //UUID
    //javax.persistence.GenerationType枚举类型
    //@GeneratedValue
    //strategy属性指定ID生成策略
    //没有指定
    //Oracle sequence
    //MySQL identity
    //private Long id；
    //实体类应该是顶层类，不必扩展自任何超类或者实现任何接口，也不必序列化
    //实体类应该至少有一个public的无参构造函数，且不应该是final的
    //因为一些ORM提供程序可能对实体类进行扩展，以便运行时创建相应的代理类
    //实体类中的公共方法也不应该被标记为final
    //不必为持久化字段创建getter/setter方法
    //ORM提供程序可以直接访问持久化字段值
    //可以将业务逻辑放置在setter和getter方法中
    //将属性映射到列
    //默认所有类中的特性都持久化
    //不想持久化，使用@Transient注解 或 transient修饰符标记
    //默认列名与属性名相同
    //注解
    //@Column(name="passwd",nullable=false,length=128)
    //在对象之间创建关联
    //多重性
    //一对一
    //只有两个对象彼此相关联
    //举例
    //@Entity
    //public class User{
    //@OneToOne
    //@JoinColumn(name="address_id")
    //private Address address;
    //}
    //@Entity
    //public class Address{}
    //注解
    //多对一
    //多个对象可以指向相同实例
    //注解
    //@ManyToOne(Optional=false)
    //该关联是Emploee类型所必需的
    //@JoinColumn(name="company_id")
    //指定外键列
    //表明该列存在与Company实体中
    //举例
    //@Entity
    //public class Employee{
    //@ManyToOne(Optional=false)
    //@JoinColumn(name="company_id")
    //private Company company;
    //}
    //@Entity
    //public class Company{}
    //一对多关联
    //一个实例域多个相同类型的对象产生关系
    //举例
    //@OneToMany
    //@JoinColumn(name="student_id")
    //private Set<Book> books=new HashSet<Book>();
    //多对多关联
    //标签和产品的关系
    //举例
    //@ManyToMany
    //@JoinTable(name="product_catalog",joinColumns=@JoinColumn(name="product_id"),inverseJoinColumns=@JoinColumn(name="catalog_id"))
    //private Set<catalog> catalogs=new HashSet<Catalog>();
    //注解
    //@JoinTable
    //两个表之间需要称为关联表的中间表
    //该表包含对每个表中主键列的引用
    //本例中关联表名为product_catalog
    //@JoinColumn
    //指定了product_catalog表中存在的列名，和对两张表主键的引用
    //关联中的方向性
    //单向
    //导航只能从关联的源对象到目标对象
    //双向
    //两个实体都注解关联，就变成了双向
    //注解
    //@OneToOne(mappedBy="address")
    //mappdeBy是只读的，设置该镜子属性值对创建和删除关联没有影响
    //Java类型映射到SQL类型
    //Java_SQL类型映射表（Java-ORM-SQL）
    //int-integer-INTEGER
    //long-long-BIGINT
    //short-short-SMALLINT
    //BigDecimal-big_decimal-NUMERIC
    //String-string-VARCHAR
    //byte-byte-TINYINT
    //boolean-boolean-BIT
    //Date-timestamp-TIMESTANP
    //Calendar-calendar-DATE
    //Serializable-serializable-VARBINARY
    //Class-class-VARCHAR
    //配置和使用JPA
    //Spring的JPA支持
    //在Spring容器中设置JPA
    //好处
    //自动EntityManager管理
    //常见的数据访问异常
    //集成事务管理
    //基于纯JPA实现DAO
    //处理和转换异常
    //在Spring环境中进一步配置JPA
}
