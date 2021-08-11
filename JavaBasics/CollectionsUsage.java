package JavaBasics;

public class CollectionsUsage {
    //集合
    //Java集合框架
    //最初版本
    //Vector,Stack,Hashtable,BitSet,Enumeration
    //集合的接口与实现分离
    //队列
    //接口 add remove size
    //实现
    //循环数组
    //ArrayDeque类
    //有界集合，容量有界
    //链表
    //LinkedList类
    //对象数量没有上限
    //AbstractQueue类
    //实现自己的队列，比实现Queue接口的方法轻松
    //Collection接口
    //集合类的基本接口
    //基本方法
    //add
    //iterator
    //AbstractCollection类
    //继承该类实现自定义的集合
    //迭代器
    //Iterator接口
    //方法
    //next
    //标准类库中任何集合都可以使用for each 循环
    //hasNext
    //remove
    //it.remove()
    //it.next()//必须的
    //ir.remove()
    //forEachRemaining
    //iterator.forEachRemaining(element->do something with element)
    //泛型实用方法
    //contains
    //size
    //isEmpty
    //containsAll
    //equals
    //addAll
    //remove
    //从这个集合中删除等于 obj 的对象。如果有匹配的对象被删除， 返回 true
    //removeAll
    //从这个集合中删除 other 集合中存在的所有元素。如果由于这个调用改变了集合，返回 true
    //clear
    //retainAll
    //从这个集合中删除所有与 other 集合中的元素不同的元素。如果由于这个调用改变了
    //集合， 返回 true
    //toArray
    //返回这个集合的对象数组
    //<T> T[]toArray(T[]arrayToFi11)
    //返回这个集合的对象数组。如果 arrayToFill 足够大， 就将集合中的元素填入这个数组
    //中。剩余空间填补 null ; 否则， 分配一个新数组， 其成员类型与 arrayToFill 的成员类
    //型相同， 其长度等于集合的大小， 并填充集合元素
    //集合框架中的接口
    //Collection
    //List
    //有序集合
    //元素添加 到 容 器 中 的 特 定 位 置
    //访问元素
    //迭代器访问
    //随机访问
    //整数索引
    //实现
    //数组
    //由数组支持的有序集合可以快速地随机访问
    //链表
    //链表尽管也是有序的， 但是随机访问很慢，所以最好使用迭代器来遍历
    //Set
    //SortedSet
    //NavigableSet
    //包含一些搜索和遍历有序集和映射的方法
    //实现
    //TreeSet
    //提供用于排序的比较器对象
    //方法声明等同于 Collection 接口
    //不允许增加重复的元素
    //适当地定义集的 equals 方法
    //Queue
    //Deque
    //方法
    //Queue的方法加First,Last
    //方法
    //add
    //offer
    //remove
    //poll
    //element
    //peek
    //有两个端头的队列， 即双端队列
    //不支持在队列中间添加元素。
    //map
    //SortedMap
    //NavigableMap
    //包含一些搜索和遍历有序集和映射的方法
    //实现
    //TreeMap
    //增加了几个便于定位元素以及反向遍历的方法
    //提供用于排序的比较器对象
    //方法
    //get
    //getOrDefault
    //put
    //putAll
    //containsKey
    //containsValue
    //forEach
    //更新映射项
    //counts.merge(word, 1, Integer::sum); 
    //如果不存在，填入1，存在则与1加和
    //putIfAbset
    //compute
    //computeIfPresent
    //应用函数于k v
    //replaceAll

    //ArrayDeque
    //用途
    //栈或队列的推荐实现
    //不可以插入null
    //次选是LinkedList
    //可以插入null
    //方法
    //addLast
    //offerLast
    //pollFirst
    //pollLast
    //peekLast
    //peekFirst
    //线程不安全
    //除了以Map结尾的，都实现了Collection接口
    //AbstractCollection
    //AbstractList
    //AbstractSequentialList
    //LinkedList
    //链表却将每个对象存放在独立的结点中
    //Java 程序设计语言中，所有链表实际上都是双向链接的
    //链 表 与 泛 型 集 合 之 间 有 一 个 重 要 的 区 别。链 表 是 一 个 有 序 集 合
    //使用ListIterator遍历、添加、删除
    //缺陷
    //不应使用get(i)方法
    //使用场景
    //使用链表的唯一理由是尽可能地减少在列表中间插人或删除
    //元素所付出的代价。如果列表只有少数几个元素， 就完全可以使用 ArrayList
    //ArrayList
    //缺陷
    //从数组的中间位置删除一个元素要付出很大的代价
    //AbstractSet
    //HashSet
    //LinkedHashSet
    //用来记住插人元素项的顺序。这样就可以避免在散歹表中的项从表面上看是随机排列的。当条目插入到表中时，就会并人到双向链表中
    //散列表（HashTable）可以快速地査找所需要的对象
    //散列表为每个对象计算一个整数， 称为散列码（hashcode。)
    //具有不同数据域的对象将产生不同的散列码。
    //散列码由对象是实例域产生 hashCode()方法
    //自己实现的hashCode()方法要与equals（）方法兼容
    //实现
    //在 Java 中，散列表用链表数组实现
    //每个列表称为桶 bucket
    //有时候会遇到桶被占满的情况， 这也是不可避免的。这种现象被称为散列冲突（ hash collision) o 这时， 需要用新对象与桶中的所有对象进行比较，査看这个对象是否已经存在。如果散列码是合理且随机分布的， 桶的数目也足够大， 需要比较的次数就会很少。
    //在 JavaSE 8 中， 桶满时会从链表变为平衡二叉树。如果选择的散列函数不当， 会产生很多冲突，或者如果有恶意代码试图在散列表中填充多个有相同散列码的值， 这样就能提高性能。
    //通常， 将桶数设置为预计元素个数的 75% ~ 150%
    //如果散列表太满， 就需要再散列 （rehashed)。如果要对散列表再散列， 就需要创建一个桶数更多的表，并将所有元素插入到这个新表中，然后丢弃原来的表。
    //使用场景
    //只有不关心集合中元素的顺序时才应该使用 HashSet
    //在更改集中的元素时要格外小心。如果元素的散列码发生了改变， 元素在数据结构中的位置也会发生变化
    //EnumSet
    //枚举类型元素集的高效实现。 由于枚举类型只有有限个实例， 所以EnumSet 内部用位序列实现。如果对应的值在集中， 则相应的位被置为 1。
    //EnumSet 类没有公共的构造器。可以使用静态工厂方法构造这个集
    //TreeSet
    //树集是一个有序集合
    //可以以任意顺序将元素插入到集合中。在对集合进行遍历时，每个值将自动地按照排序后的顺序呈现
    //将一个元素添加到树中要比添加到散列表中慢，但是，与检查数组或链表中的重复元素相比还是快很多
    //要使用树集， 必须能够比较元素。这些元素必须实现 Comparable 接口.或者构造集时必须提供一个 Comparator
    //应用场景
    //数据可以排序
    //树的排序必须是全序
    //任意两个元素必须是可比的， 并且只有在两个元素相等时结果才为 0
    //ArrayDeque
    //AbstractQueue
    //PriorityQueue
    //（priority queue) 中的元素可以按照任意的顺序插人，却总是按照排序的顺序进行检索。也就是说，无论何时调用 remove 方法，总会获得当前优先级队列中最小的元素。
    //优先级队列使用了一个优雅且高效的数据结构，称为堆（heap)。堆是一个可以自我调整的二叉树，对树执行添加（ add) 和删除（remore) 操作， 可以让最小的元素移动到根，而不必花费时间对元素进行排序。
    //一个优先级队列既可以保存实现了 Comparable 接口的类对象， 也可以保存在构造器中提供的Comparator 对象。
    //应用场景
    //任务调度
    //AbstractMap
    //HashMap
    //LinkedHashMap
    //用来记住插人元素项的顺序。这样就可以避免在散歹表中的项从表面上看是随机排列的。当条目插入到表中时，就会并人到双向链表中
    //链接散列映射将用访问顺序， 而不是插入顺序， 对映射条目进行迭代。每次调用 get 或put, 受到影响的条目将从当前的位置删除， 并放到条目链表的尾部（只有条目在链表中的位置会受影响， 而散列表中的桶不会受影响。一个条目总位于与键散列码对应的桶中
    //应用场景
    //访问顺序对于实现高速缓存的“ 最近最少使用” 原则十分重要
    //散列或比较函数只能作用于键。与键关联的值不能进行散列或比较
    //TreeMap
    //EnumMap
    //WeakHashMap
    //应用场景
    //假定对某个键的最后一次引用已经消亡，不再有任何途径引用这个值的对象了。但是，由于在程序中的任何部分没有再出现这个键，所以，这个键 / 值对无法从映射中删除。
    //当对键的唯一引用来自散列条目时， 这一数据结构将与垃圾回收器协同工作一起删除键 / 值对。
    //WeakHashMap 使用弱引用 （ weak references) 保存键。
    //如果某个对象只能由 WeakReference 引用， 垃圾回收器仍然回收它，但要将引用这个对象的弱引用放人队列中。
    //IdentityHashMap
    //标识散列映射
    //键的散列值不是用hashCode函数计算的， 而是用 System.identityHashCode 方法计算的
    //根据对象的内存地址产生
    //在对两个对象进行比较时，IdentityHashMap类使用 ==, 而不使用 equals
    //不同的键对象， 即使内容相同， 也被视为是不同的对象。
    //应用场景
    //对象串行化）时， 这个类非常有用， 可以用来跟踪每个对象的遍历状况
    //映射用来存放键 / 值对
    //线程安全
    //映射
    //Map
    //LinkedHashMap
    //LinkedHashMap 的accessOrder参数控制的，true为访问顺序遍历，false为插入顺序遍历。
    //按照访问顺序遍历时，每次访问完map中的元素后，会将该元素置入map的最后一位，
    //LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(6,0.75f,true);
    //for(Iterator iterator = lhm.keySet().iterator();iterator.hasNext();){
    //String name = (String)iterator.next();
    //lhm.get(name);
    //}
    //LinkedHashMap是通过比HashMap多了一个双向链表实现的有序。

    //视图与包装器
    //keySet 方法返回一个实现 Set接口的类对象， 这个类的方法对原映射进行操作。这种集合称为视图
    //映射视图
    //集合框架不认为映射本身是一个集合
    //可以得到映射的视图（ View )
    //KeySet（）
    //keySet 方法返回一个实现 Set接口的类对象， 这个类的方法对原映射进行操作。这种集合称为视图。
    //values()
    //entrySet()
    //entry
    //getKey
    //getValue
    //setValue
    //Iterator
    //ListIterator
    //Listlterator 接口有两个方法， 可以用来反向遍历链表
    //previous
    //hasPrevious
    //如果在某个迭代器修改集合时， 另一个迭代器对其进行遍历，一定会出现混乱的状况。
    //为了避免发生并发修改的异常，请遵循下述简单规则：可以根据需要给容器附加许多的
    //迭代器，但是这些迭代器只能读取列表。另外，再单独附加一个既能读又能写的迭代器。
    //RandomAccess
    //为了避免对链表完成随机访问操作
    //用它来测试一个特定的集合是否支持高效的随机访问

    //轻量集合包装器
    //Arrays 类的静态方法 asList 将返回一个包装了普通 Java 数组的 List 包装器。
    //返回的对象不是 ArrayList。它是一个视图对象， 带有访问底层数组的 get 和 set 方法。
    //Collections 类包含很多实用方法， 这些方法的参数和返回值都是集合。
    //Collections.singleton(anObject)
    //返回一个视图对象
    //实现了一个不可修改的单元素集， 而不需要付出建立数据结构的开销。
    //子范围视图
    //使用 subList 方法来获得一个列表的子范围视图
    //List group2 = staff.subList(10, 20);
    //group2.clear();
    //SortedSet 接口
    //SubSet
    //headSet
    //tailSet
    //SortedMap 接口
    //SubMap
    //headMap
    //tailMap
    //不可修改的视图
    //用于产生集合的不可修改视图
    //使用场景
    //对现有集合增加了一个运行时的检查
    //Collections.unmodifiable...
    //不可修改视图并不是集合本身不可修改。由于视图只是包装了接口而不是实际的集合对象， 所以只能访问接口中定义的方法

    //同步视图
    //Collections.synchronizedMap(..
    //使用视图机制来确保常规集合的线程安全
    //另一个线程调用另一个方法之前，刚才的方法调用必须彻底完成。
    //受查视图
    //应用场景
    //“ 受査” 视图用来对泛型类型发生问题时提供调试支持
    //实际上将错误类型的元素混人泛型集合中的问题极有可能发生。
    //List<String> safestrings = Collections.checkedList(strings，String,class);
    //视图的 add 方法将检测插人的对象是否属于给定的类。
    //定义了一个安全列表
    //可选操作
    //视图的局限性
    //只可以读、 无法改变大小、只支持删除而不支持插人，这些与映射的键视图情况相同。
    //算法
    //泛型集合接口有一个很大的优点， 即算法只需要实现一次。

//排序与混排
//Java 程序设计语言直接将所有元素转人一个数组，对数组进行排序，然后，再将排序后的序列复制回列表。
//集合类库中使用的排序算法比快速排序要慢一些，快速排序是通用排序算法的传统选择。但是，归并排序有一个主要的优点：稳定， 即不需要交换相同的元素。
//如果提供的列表没有实现 RandomAccess 接口，shuffle 方法将元素复制到数组中，然后打乱数组元素的顺序，最后再将打乱顺序后的元素复制回列表。
//二分查找
//只有采用随机访问，二分査找才有意义。如果必须利用迭代方式一次次地遍历链表的一半元素来找到中间位置的元素，二分査找就完全失去了优势。因此，如果为 binarySearch 算法提供一个链表， 它将自动地变为线性查找。
//简单算法
//查找最大元素
//复制到另一个列表
//使用常量值填充容器
//转置列表的元素顺序
//Collections.removeIf
//Collections.replaceAll
//批操作
//colll.removeAll(coll2);
//colli.retainAll(coll2);
//将从 colli 中删除 colli2 中出现的所有元素。
//relocated.addAll(staff.subList(0, 10)):
//staff.subList(0, 10).clear();
//集合与数组转换
//HashSet<String> staff = new HashSeto(Arrays.asList(values));
//Object[] values = staff.toArray0;
//String[] values = staff.toArray(new String[0]);
//自定义算法
//如果编写自己的算法（实际上，是以集合作为参数的任何方法，) 应该尽可能地使用接口，而不要使用具体的实现。
//遗留的集合
//Vector
//RandomAccess
//Stack
//可以在任何地方进行插入或删除操作
//Hashtable
//Properties
//键与值都是字符串
//表可以保存到一个文件中， 也可以从文件中加载
//使用一个默认的辅助表
//属性映射通常用于程序的特殊配置选项
//实现属性映射的 Java 平台类称为 Properties。
//位集 BitSet
//于存放一个位序列（它不是数学上的集，称为位向量或位数组更为合适)
//应用场景
//需要高效地存储位序列（例如，标志）就可以使用位集。
//方法
//get(i)
//set(i)
//clear(i)
//and or xor andNot
//由于位集将位包装在字节里，所以，使用位集要比使用 Boolean 对象的 ArrayList 更加高效
    //ConcurrentHashMap
    //HashTable 在每次同步执行时都要锁住整个结构。ConcurrentHashMap 锁的方式是稍微细粒度的。 ConcurrentHashMap 将 hash 表分为 16 个桶（默认值）
    //最大并发个数就是Segment的个数，默认值是16，可以通过构造函数改变一经创建不可更改，这个值就是并发的粒度，每一个segment下面管理一个table数组，加锁的时候其实锁住的是整个segment。
    //Java7ConcurrentHashMap 类中包含两个静态内部类 HashEntry 和 Segment。HashEntry 用来封装映射表的键 / 值对；Segment 用来充当锁的角色，每个 Segment 对象守护整个散列映射表的若干个桶。每个桶是由若干个 HashEntry 对象链接起来的链表。一个 ConcurrentHashMap 实例中包含由若干个 Segment 对象组成的数组。
    //Java8为进一步提高并发性，放弃了分段锁，锁的级别控制在了更细粒度的table元素级别，也就是说只需要锁住这个链表的head节点，并不会影响其他的table元素的读写，好处在于并发的粒度更细，影响更小，从而并发效率更好
    //使用CAS + synchronized 来保证实现put操作：如果Key对应的数组元素为null，则通过CAS操作将其设置为当前值。如果Key对应的数组元素（也即链表表头或者树的根元素）不为null，则对该元素使用synchronized关键字申请锁，然后进行操作。如果该put操作使得当前链表长度超过一定阈值，则将链表（寻址时间复杂度为O(N)）转换为红黑树（寻址时间复杂度为O(log(N))，插入操作完成之后如果所有元素的数量大于当前容量（默认16）*负载因子（默认0.75）就进行扩容。
    //PutAll()方法会使用全锁。
    //hashtable的put方法
    //public synchronized V put(K key, V value) {
    //// Make sure the value is not null
    //if (value == null) {
    //throw new NullPointerException();
    //}
    //// Makes sure the key is not already in the hashtable.
    //Entry<?,?> tab[] = table;
    //int hash = key.hashCode();
    //int index = (hash & 0x7FFFFFFF) % tab.length;
    //@SuppressWarnings("unchecked")
    //Entry<K,V> entry = (Entry<K,V>)tab[index];
    //for(; entry != null ; entry = entry.next) {
    //if ((entry.hash == hash) && entry.key.equals(key)) {
    //V old = entry.value;
    //entry.value = value;
    //return old;
    //}
    //}
    //addEntry(hash, key, value, index);
    //return null;
    //}
    //通过Object的hashcode方法对key进行散列运算
    //int hash = key.hashCode();
    //与0x7FFFFFFF相与之后，对数组长度取域，确保能散列到数组上。
    //int index = (hash & 0x7FFFFFFF) % tab.length;
    //将entry放入数组中的index位置，如果有hash冲突，头插法解决（即数组中链表的头节点始终是后一个元素）
    //hashmap的put方法
    //public V put(K key, V value) {
    //return putVal(hash(key), key, value, false, true);
    //}static final int hash(Object key) {
    //int h;
    //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    //}
    //final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
    //boolean evict) {
    //Node<K,V>[] tab; Node<K,V> p; int n, i;
    //if ((tab = table) == null || (n = tab.length) == 0)
    //n = (tab = resize()).length;
    ////此处通过（n1） & hash 计算出的值作为tab的下标i，并另p表示tab[i]，也就是该链表第一个节点的位置。并判断p是否为null。
    //if ((p = tab[i = (n1) & hash]) == null)
    ////当p为null时，表明tab[i]上没有任何元素，那么接下来就new第一个Node节点，调用newNode方法返回新节点赋值给tab[i]。
    //tab[i] = newNode(hash, key, value, null);
    //else {
    ////下面进入p不为null的情况，有三种情况：p为链表节点；p为红黑树节点；p是链表节点但长度为临界长度TREEIFY_THRESHOLD，再插入任何元素就要变成红黑树了。
    //Node<K,V> e; K k;
    ////HashMap中判断key相同的条件是key的hash相同，并且符合equals方法。这里判断了p.key是否和插入的key相等，如果相等，则将p的引用赋给e。
    //if (p.hash == hash &&
    //((k = p.key) == key || (key != null && key.equals(k))))
    //e = p;
    //else if (p instanceof TreeNode)
    //e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
    //else {
    //for (int binCount = 0; ; ++binCount) {
    //if ((e = p.next) == null) {
    //p.next = newNode(hash, key, value, null);
    //if (binCount >= TREEIFY_THRESHOLD1) // -1 for 1st
    //treeifyBin(tab, hash);
    //break;
    //}
    //if (e.hash == hash &&
    //((k = e.key) == key || (key != null && key.equals(k))))
    //break;
    //p = e;
    //}
    //}
    //if (e != null) { // existing mapping for key
    //V oldValue = e.value;
    //if (!onlyIfAbsent || oldValue == null)
    //e.value = value;
    //afterNodeAccess(e);
    //return oldValue;
    //}
    //}
    //++modCount;
    //if (++size > threshold)
    //resize();
    //afterNodeInsertion(evict);
    //return null;
    //}
    
}
