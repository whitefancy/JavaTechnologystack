package javacore;

import java.util.concurrent.*;

/**
 * 阻塞队列
 * 使用队列，可以安全地从一个线程向另一个线程传递数据
 * 生产者线程 消费者线程
 * 仍是基于Java并发程序设计基础的底层构建块
 * 当队列满或空时，会导致线程阻塞，从而协调多个线程之间的合作
 * 将中间结果存储在阻塞队列里，会自动地平衡负载
 * 为了维持阻塞的特性，线程管理应该使用put和take方法，操作元素，使用offer，poll，peek
 * 避免使用add，remove和element
 * 像队列插入null是非法的，因为返回null表示插入或者取出失败。
 */
public class BlockingQueueTest {
    LinkedBlockingDeque queue = new LinkedBlockingDeque();//没有上限，可以指定上限
    ArrayBlockingQueue queue1 = new ArrayBlockingQueue(500);//有上限，可以设置公平参数，防止等待过长
    PriorityBlockingQueue queue2 = new PriorityBlockingQueue();//没有上限，不是先进先出的队列
    DelayQueue queue3 = new DelayQueue();//进入队列必须等待一段时间才能出去
    TransferQueue queue4;//接口，可以允许生产者等待，只有有了消费者，才能接受元素
}
