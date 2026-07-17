import java.util.*;
abstract class shape
{
  int length=10;
int width=20;
int radius=25;
abstract void area();
}
class rectangle extends shape
{
  void area()
{
System.out.println("The area of rectangle:"+(length*width));
}
}
class square extends shape
{

  void area()
{
System.out.println("The area of square:"+(length*length));
}
}
class circle extends shape
{

  void area()
{
System.out.println("The area of circle:"+(3.15*radius*radius));
}
}
class Abstractex
{
public static void main(String args[])
{
 rectangle r=new rectangle();
r.area();
square s=new square();
s.area();
circle c=new circle();
c.area();
}
}

 

 