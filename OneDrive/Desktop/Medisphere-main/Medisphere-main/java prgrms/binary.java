import java.util.*;
class binary
{
 static int binary(int a[],int low,int high,int key)
{
 if(high<low)
return -1;
int mid=(low+high)/2;
if(a[mid]==key)
return mid;
if (a[mid]<key)
return binary(a,(mid+1),high,key);
return binary(a,mid,mid-1,key);
}
public static void main(String args[])
{
System.out.println("Enter size:");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
System.out.println("Enter values of an array:");
int a[]=new int[n];
for(int i=0;i<n;i++)
{
 a[i]=sc.nextInt();
}
System.out.println("Enter key value:");
int key=sc.nextInt();
int pos=binary(a,0,n-1,key);
System.out.println("Element found at:"+pos);
}
}