package com.daxin

object Test {
 def main(args: Array[String]): Unit = {
  
   val uf1=UserFactory
	 val uf2=UserFactory

	 //证明UserFactory是单例模式
	 println(uf1.eq(uf2))
   println(uf1.equals(uf2))
   
   
   println(uf1.getUser("Dax1n", 18))
   
   // t是Test的单例对象
   val t=Test
	 
	 
   
 }
}