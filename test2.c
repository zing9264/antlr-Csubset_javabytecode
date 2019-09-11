void main()
{

    /*if else ,compare,測試浮點數、整數運算、printf功能*/
   int a;
   int b;
   float c;
   float d;
   printf("*****test2   start*****\n");

   a = 1;
   b = 0;
  
  printf("if(a>b)  ;a->%d, b->%d\n",a,b);
   if(a>b){
      a=500;
      printf("if成立 ,a=500  a->%d, b->%d\n",a,b);
   }
   else
   {
      b=120;
      printf("if不成立 ,b=120;  a->%d, b->%d\n",a,b);
   }

   a=20;
   b=100;
   printf("if(a>b)  ;a->%d, b->%d\n",a,b);
   if(a>b){
      a=500;
      printf("if成立 ,a=500  a->%d, b->%d\n",a,b);
   }
   else
   {
      b=120;
      printf("if不成立 ,b=120;  a->%d, b->%d\n",a,b);
   }

   c = 22.0f;
   printf("if(c!=0)  ;c->%f\n",c);
   if (c != 0.0f){
   d = 10.0f;
     printf("if成立 ,d = 10.0f;  ;d->%f\n",d);
   }
   else{
   d = c;
   printf("if不成立 ,  d = c;  ;d->%f\n",d);
   }
   
   /*printf可容納不超過變數堆疊上限的arg*/
   printf("printf可容納不超過變數堆疊上限的arg: \n%d,%d,%f,%f,%d,%d,%f,%f,%d,%d,%f,%f,%d,%d,%f,%f\n",a,b,c,d,a,b,c,d,a,b,c,d,a,b,c,d);

   printf("*****test2   End*****\n");

}
