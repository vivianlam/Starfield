//Vivian Lam, AP Computer Science, Mod 6/7, Starfield
Particle[] plat;
void setup()
{
  background(0);
  size(400,400);
  plat=new Particle[1000];
  for(int i=0;i<999;i++){
  	plat[i]=new NormalParticle();
  }
  plat[999]=new OddballParticle();
  frameRate(20);
}
void draw()
{
  background(0);
  for(int i=0; i<1000;i++){
   plat[i].move();
   plat[i].show();
  }

}
class NormalParticle implements Particle
{
  int myColor;
  double myX, myY, mySpeed, myAngle;
  NormalParticle()
  {
    myColor= color ((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    myX= 200;
    myY= 200;
    mySpeed= Math.random()*10;
    myAngle= Math.random()*2*Math.PI; 
  }
  public void move(){
    myX+=Math.cos(myAngle)*mySpeed;
    myY+=Math.sin(myAngle)*mySpeed;  
    myAngle+=0.01;
  }
  public void show(){
    noStroke();
    fill(myColor);
    ellipse((int)myX,(int)myY,5,5);
  }
}
interface Particle
{
  public void move();
  public void show();
}
class OddballParticle implements Particle
{
  int myColor;
  double myX, myY, mySpeed, myAngle;
  OddballParticle()
  {
  	myColor=color(0,255,0);
  	myX=Math.random()*200+100;
  	myY=Math.random()*200+100;
  	mySpeed=Math.random()*10;
  	myAngle=Math.random()*2*Math.PI;
  }
   public void move(){
  	myX+=Math.cos(myAngle)*mySpeed;
    myY+=Math.sin(myAngle)*mySpeed;  
    myAngle+=0.05;
  }
  public void show(){
  	noStroke();
  	fill(255);
  	ellipse((int)myX,(int)myY,10,10);
  }
  
}


