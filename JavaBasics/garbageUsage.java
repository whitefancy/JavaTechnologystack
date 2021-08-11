package JavaBasics;

public class garbageUsage {
    //图中展示了7种不同分代的收集器：
    //Serial、ParNew、Parallel Scavenge、Serial Old、Parallel Old、CMS、G1；
    //（B）、而它们所处区域，则表明其是属于新生代收集器还是老年代收集器：
    //新生代收集器：Serial、ParNew、Parallel Scavenge；
    //老年代收集器：Serial Old、Parallel Old、CMS；
    //整堆收集器：G1；
    //（C）、两个收集器间有连线，表明它们可以搭配使用：
    //Serial/Serial Old、Serial/CMS、ParNew/Serial Old、ParNew/CMS、Parallel Scavenge/Serial Old、Parallel Scavenge/Parallel Old、G1；
    //（D）、其中Serial Old作为CMS出现"Concurrent Mode Failure"失败的后备预案（后面介绍）；
    //1-2、并发垃圾收集和并行垃圾收集的区别
    //（A）、并行（Parallel）
    //指多条垃圾收集线程并行工作，但此时用户线程仍然处于等待状态；
    //如ParNew、Parallel Scavenge、Parallel Old；
    //（B）、并发（Concurrent）
    //指用户线程与垃圾收集线程同时执行（但不一定是并行的，可能会交替执行）；
    //用户程序在继续运行，而垃圾收集程序线程运行于另一个CPU上；
    //如CMS、G1（也有并行）；
    //1-3、Minor GC和Full GC的区别
    //（A）、Minor GC
    //又称新生代GC，指发生在新生代的垃圾收集动作；
    //因为Java对象大多是朝生夕灭，所以Minor GC非常频繁，一般回收速度也比较快；
    //（B）、Full GC
    //又称Major GC或老年代GC，指发生在老年代的GC；
    //出现Full GC经常会伴随至少一次的Minor GC（不是绝对，Parallel Sacvenge收集器就可以选择设置Major GC策略）；
    //Major GC速度一般比Minor GC慢10倍以上；
    //下面将介绍这些收集器的特性、基本原理和使用场景，并重点分析CMS和G1这两款相对复杂的收集器；但需要明确一个观点：
    //没有最好的收集器，更没有万能的收集；
    //选择的只能是适合具体应用场景的收集器。

    //虚拟机性能监控与故障处理工具
    //JDK的命令行工具
    //jps 虚拟机进程状况工具
    //描述： 虚拟机进程状态管理工具；其他工具在使用时需要通过该工具来获取LVMID；
    //1.1 功能
    //列举正在运行的虚拟机进程； 进程本地虚拟机唯一ID（Local Virtaul Machine Identifer LVMID）
    //显示虚拟机执行主类（main（）方法所在的类）的名称
    //1.2 参数
    //注: options (选项) ； 本文将 options 理解为工具的参数。
    //jps 命令格式： jps [ options ] [hostid]
    //参数 描述
    //-l 输出主类的全名，如果是执行的jar，则输出jar的路径
    //-v 输出JVM启动时的JVM参数
    //当然常用参数还是 -l ，主要是为了获得ID值。
    //jstat 虚拟机统计信息监视工具
    //描述：虚拟机统计信息监控工具
    //监视虚拟机各种运行状态信息的命令行工具;
    //它可以显示本地或者远程虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据，在没有GUI图形化界面，只提供纯文本控制台环境的服务器上，它将是运行期定位虚拟机性能问题的首选工具。(jstat工具参数还是比较多，信息还是比较丰富)
    //2.2 命令格式
    //jstat [options] vmid [interval [s|ms] [count]] ] （远程命令格式略有不同）
    //jstat [-命令选项] [vmid] [间隔时间/毫秒] [查询次数]
    //2.3 主要工具参数
    //参数 功能作用
    //-class 监视类装载、卸载数量，以及总空间和装载耗时等
    //-gc 监视堆中 eden、 survivor 、老年代、元空间等空间大小和已使用情况，GC次数、耗时等
    //-gcmetacapacity 元空间
    //-gcutil 与gc 类似，但是注重的是占比情况
    //-printcompilation 输出已经被JIT重新编译的方法
    //-gcoldcapacity 老年代统计信息
    //-gcnew 新生代
    //-gccause 与-gcutil相似，但是会输出上一次GC的原因
    //jinfo Java配置信息工具
    //jmap Java内存映像工具
    //jhat 虚拟机堆转储快照分析工具
    //jstack Java堆栈跟踪工具
    //JDK的可视化工具
    //JConsole Java监视与管理控制台
    //VisualVM 多合一故障处理工具

    //查看JVM参数
    //jps -l 查看所有正在运行的Java程序，同时显示启动类类名，获取到PID
    //jinfo -flags PID 查看运行时进程参数与JVM参数
    //java -XX:+PrintFlagsFinal -version 查看当前虚拟机默认JVM参数
    //jstat -gc PID 1000 10 查看即时GC状态，每秒查看一次gc信息，共10次

    //CPU 负载过高
    //任务长时间不退出？CPU 负载过高？很可能因为死循环或者死锁，导致某些线程一直执行不被中断，但是不报错是最烦人的，所以日志里看不到错误信息，并且又不能用dump文件分析，因为跟内存无关。这个时候就需要用线程分析工具来帮我们了。
    //导出jstack文件
    //使用jstack PID > 文件，如果失败请加-F参数，如果还失败请使用Java程序启动时使用的用户执行jstack，下面是jstack的部分输出格式。
    //jstack的输出可以看到所有的线程以及他们的状态，我们就可以看有哪些我们自己创建的正在运行的线程，那很可能就是那个一直在执行的线程了，此时线程名就格外重要了，所以建议创建新线程时指定有意义的线程名。当然，通过PID查找也非常方便。
    //排查步骤
    //top 查看到哪个java程序负载高
    //top -p PID -H 查看该进程所有进程的运行状态
    //记录下高负载的线程ID，printf "&x" PID转换成16进制
    //jstack PID > 文件
    //在jstack文件中用转换成16进制之后的线程ID查询线程运行堆栈从堆栈中了解到线程在执行什么任务，并结合业务与代码判断问题所在
}
