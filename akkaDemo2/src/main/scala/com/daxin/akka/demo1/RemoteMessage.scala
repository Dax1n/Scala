package com.daxin.akka.demo1


//能被akka作为消息传递的对象必须实现Serializable接口
trait RemoteMessage  extends Serializable



//能被akka作为消息传递的对象必须实现Serializable接口
//这个样例类完成worker到master的消息封装
case class RegisterWorker(id: String, memory: Int, cores: Int) extends RemoteMessage



//返回给worker一个masterURL原因：
//因为以后可能是高可用的集群，Master节点有多个，如果当前master宕机之后，更换备用master没有告诉worker最新地址的话
//worker将还会向原来的master发消息。
case class RegisteredWorker(masterUrl: String) extends RemoteMessage


/**
 * worker自己给自己发消息，在自己进程内部发消息不需要携带数据
 */
case object SendHeartBeat


/**
 * 
 * worker 发送给master的心跳
 * 
 * WorkId当前的workID
 * 
 * 
 */
case class HeartBeat2Master(workId:String) extends RemoteMessage