package cn.itcast

object MyPredefGirl {

  //正常隐式转化那都是在后面new 一个其他类的对象，本例隐式转换也是如此，由于Ordered是特质，本例中创建了一个匿名类，然后在匿名类中实现compare方法

  implicit def girl2Ordered(g: Girl) = new Ordered[Girl] {
    override def compare(that: Girl): Int = {
      g.faceValue - that.faceValue
    }
  }

}  