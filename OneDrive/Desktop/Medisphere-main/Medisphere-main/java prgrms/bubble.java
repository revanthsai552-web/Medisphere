import java.util.*;
class bubble
{
static void bubble(int a[])
{
int n=a.length;
 int temp=0;
for(int i=0;i<n;i++)
{
for (int j=1;j<(n-i);j++)
{
 if( a[j-1]>a[j])
{
temp=a[j-1];
a[j-1]=a[j];
a[j]=temp;
}
}
}
}
public static void main(String args[])
{
System.out.println("Enter size:");
Scanner sc=new Scanner(System.in);
int size=sc.nextInt();
System.out.println("Enter values of an array before sorting:");
int a[]=new int[size];
for (int i=0;i<size;i++)
{
a[i]=sc.nextInt();
}
bubble(a);
System.out.println("After sorting:");
for (int i=0;i<a.length;i++)
{
System.out.println(a[i]);
}
}
}
