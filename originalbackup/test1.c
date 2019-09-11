void main()
{
   /*測試浮點數、整數運算、printf功能*/

   int a;
   int b;
   float c;
   float d;
   printf("*****test1   start*****\n");

   a = 0;
   printf("a=0;    a->%d\n",a);
   b = a + 100;/*100*/
   printf("b = a + 100; b->%d\n",b);
   b = b - 50;/*50*/
   printf("b = b - 50; b->%d\n",b);
   a = 3*5;
   printf("a = 3*5; a->%d\n",a);
   a = b+2*(100-1);/*248*/
   printf("a = b+2*(100-1); a->%d\n",a);
   b = a/3;
   printf("b = a/3; b->%d\n",b);

   d = 1.5f;
   printf("d = 1.5f; d->%f\n",d);
   c = 0.5f-d;
   printf("c = 0.5f-d; c->%f\n",c);
   c = d+2.0f*(100.0f-1.0f);
   printf("c = d+2.0f*(100.0f-1.0f); c->%f\n",c);
   c = 3.0f*5.5f;
   printf("c = 3.0f*5.5f; c->%f\n",c);
   d = c/3.0f;
   printf("d = c/3.0f; d->%f\n",d);

   printf("result a,b,c,d = %d,%d,%f,%f\n",a,b,c,d);

   printf("*****test1   END*****\n");

}
