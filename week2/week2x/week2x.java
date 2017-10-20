import java.applet.*; import java.awt.*; import java.awt.image.*; import java.awt.event.*; import java.io.*; import java.net.*; import java.text.*; import java.util.*; import java.util.zip.*; import netscape.javascript.*; import javax.comm.*; import javax.sound.midi.*; import javax.sound.midi.spi.*; import javax.sound.sampled.*; import javax.sound.sampled.spi.*; import javax.xml.parsers.*; import javax.xml.transform.*; import javax.xml.transform.dom.*; import javax.xml.transform.sax.*; import javax.xml.transform.stream.*; import org.xml.sax.*; import org.xml.sax.ext.*; import org.xml.sax.helpers.*; public class week2x extends BApplet {
int xspeed = -1;
int yspeed = 3;
int x;
int y;
float r = 10.0f;

int boxx;
int boxy;
int boxsize;

boolean intersecting = false;

void setup() {

  size(400,200);
  x = 10;
  y = height/2;

  boxx = width/2;
  boxy = height/2;
  boxsize = 50;

}

void loop() {

  //test for intersection

  int w2 = boxsize/2;
  if ((x > boxx - w2) && ( x < boxx + w2) && (y > boxy - w2) && (y < boxy + w2))
  {
    intersecting = true;
  } else {
    intersecting = false;
  }

  //adjusts based on speed
  x = x + xspeed;
  y = y + yspeed;

  //adjust the ellipse to get smaller
  r = r - 1.5f;
  if (r < 10.0f) {
    r = 10.0f;
  }

  //reversing direction
  if ((y > height) || ( y < 0)) {
    yspeed = yspeed * -1;
    r = 30.0f;
  }

  if ((x > width) || ( x < 0)) {
    xspeed = xspeed * -1;
    r = 30.0f;
  }

  //DRAWING CODE
  background(100);
  noStroke();
  rectMode(CENTER_DIAMETER);
  if (intersecting) {
    fill(0,255,200);
  } else {
    fill(255,0,200);
  }
  rect(boxx,boxy,boxsize,boxsize);

  ellipseMode(CENTER_DIAMETER);

  fill(255,200,0);
  ellipse(x,y,r,r);

}
}