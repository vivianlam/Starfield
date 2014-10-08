import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

//Vivian Lam, AP Computer Science, Mod 6/7, Starfield
Particle[] plat;
public void setup()
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
public void draw()
{
  //background(0);
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
    myAngle+=0.01f;
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
    myAngle+=0.05f;
  }
  public void show(){
  	noStroke();
  	fill(255);
  	ellipse((int)myX,(int)myY,10,10);
  }
  
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
