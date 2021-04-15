#include <SD.h>
const int pinLight = A0;
const int pinLed = 32;
File myFile = SD.open("lightdata.txt", FILE_WRITE);
int time = 0;

void setup()
{
  pinMode(pinLed, OUTPUT);
  Serial.begin(9600);
}
 
void loop()
{
  int sensorValue = analogRead(pinLight);
  digitalWrite(LED_BUILTIN, HIGH);
  Serial.print("Sensor = ");
  Serial.println(sensorValue);
  myFile.print("Sensor = ");
  myFile.println(sensorValue);
  Serial.print("Time (Milliseconds) = ");
  Serial.println(time);
  myFile.print("Time (Milliseconds) = ");
  myFile.println(time);
  time = time + 500;
  delay(500);
}
