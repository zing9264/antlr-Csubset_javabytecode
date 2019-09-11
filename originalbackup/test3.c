void main()
{
   /*if else ,所有浮點數、整數compare, 運算、printf功能*/

   int a;
   int b;
   float c;
   float d;
   printf("*****test3   start*****\n");
   a=10;
   b=50;
   c=10.0f;
   d=50.0f;

   printf("a=%d,b=%d\n",a,b);
   if(a>b){
      printf("a>b成立\n");
   }else{
      printf("a>b不成立\n");
      if(a==a){
         printf("可巢狀if\n");
      }else{
         printf("可巢狀else\n");
      }
   }
   if(a<b){
      printf("a<b成立\n");
       if(a!=a){
         printf("可巢狀if\n");
      }else{
         printf("可巢狀else\n");
      }
   }else{
      printf("a<b不成立\n");
   }
   if(a>=b){
      printf("a>=b成立\n");
   }else{
      printf("a>=b不成立\n");
   }
   if(a<=b){
      printf("a<=b成立\n");
   }else{
      printf("a<=b不成立\n");
   }
   if(a==b){
      printf("a==b成立\n");

   }else{
      printf("a==b不成立\n");
   }
   if(a!=b){
      printf("a!=b成立\n");

   }else{
      printf("a!=b不成立\n");
   }


printf("c=%f,d=%f\n",c,d);
   if(c>d){
      printf("c>d成立\n");
   }else{
      printf("c>d不成立\n");
      if(c==c){
         printf("可巢狀if\n");
      }else{
         printf("可巢狀else\n");
      }
   }
   if(c<d){
      printf("c<d成立\n");
       if(c!=c){
         printf("可巢狀if\n");
      }else{
         printf("可巢狀else\n");
      }
   }else{
      printf("c<d不成立\n");
   }
   if(c>=d){
      printf("c>=d成立\n");
   }else{
      printf("c>=d不成立\n");
   }
   if(c<=d){
      printf("c<=d成立\n");
   }else{
      printf("c<=d不成立\n");
   }
   if(c==d){
      printf("c==d成立\n");

   }else{
      printf("c==d不成立\n");
   }
   if(c!=d){
      printf("c!=d成立\n");

   }else{
      printf("c!=d不成立\n");
   }
      printf("*****test3   END*****\n");
}
