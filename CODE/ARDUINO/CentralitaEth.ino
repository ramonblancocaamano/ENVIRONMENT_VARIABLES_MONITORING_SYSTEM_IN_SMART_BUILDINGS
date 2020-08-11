#include <UIPEthernet.h>

EthernetClient client;

void setup() {
  Serial.begin(9600);
  
  uint8_t mac[6] = {0x00,0x01,0x02,0x03,0x04,0x05};
  Ethernet.begin(mac);

  Serial.print("localIP: ");
  Serial.println(Ethernet.localIP());
  Serial.print("subnetMask: ");
  Serial.println(Ethernet.subnetMask());
  Serial.print("gatewayIP: ");
  Serial.println(Ethernet.gatewayIP());
  Serial.print("dnsServerIP: ");
  Serial.println(Ethernet.dnsServerIP());
}


void loop() {
  
    byte eon []= {0x7E, 0x00, 0X10, 0X17, 0X00, 0x00, 0X13, 0XA2, 0x00, 0X40, 0X8B, 0X69, 0X0B, 0XFF, 0XFE, 0X02, 0X44, 0X30, 0X05, 0X7C};
    byte eoff []= {0x7E, 0x00, 0X10, 0X17, 0X00, 0x00, 0X13, 0XA2, 0x00, 0X40, 0X8B, 0X69, 0X0B, 0XFF, 0XFE, 0X02, 0X44, 0X30, 0X04, 0X7D};
    
  
        byte Start=0x00;
        byte longhigh=0x00;
        byte longlow=0x00;
        int Dato=0;

  
      if (Serial.available()>3) 
        
        Start = Serial.read();
        
        if (Start==126){
          
          Serial.print("Start = ");
          Serial.println(Start,HEX);
          
          longhigh = Serial.read();
          Serial.print("LongHigh = ");
          Serial.println(longhigh,HEX);
          
          longlow= Serial.read();
          Serial.print("Longlow = ");
          Serial.println(longlow,HEX);
      
          byte lectura[longlow];
          Serial.print("Lectura = ");
          byte sum= 0xFF;
          
          if(longlow<10)
          Serial.flush();
        
        while (Serial.available()<=longlow)
        {}
          if (longlow==13){ 
           Serial.println("Borramos");
           for (int i=0; i<longlow; i ++)
           Serial.read();
         }
         else{           
          for (int i=0; i<longlow; i ++){
            
            lectura [i]= Serial.read();
            Serial.print(lectura[i],HEX);
            Serial.print(" ");
            sum= sum - lectura[i];
                       
          } //for
          Serial.print ("Check1 ");
          Serial.println(sum);
          byte Check= Serial.read();
          Serial.print ("Check2 ");
          Serial.println (Check);
          Serial.println (" ");
           Serial.print ("Dato ");
            Serial.print (lectura[longlow-2], HEX);
            Serial.print (" ");
            Serial.println (lectura[longlow-1], HEX);
            Dato= lectura[longlow-2]*256+ lectura[longlow-1];
            Serial.println(Dato);
            
            if(Dato>500){
            for (int i=0; i<20; i ++){
            Serial.write(eon[i]);
            }
            }
          
            else{
            for (int i=0; i<20; i ++){
            Serial.write(eoff[i]);
            }}
    
          SendDataBase("L",Dato,"Ramon");
          }//IF LONGLOW=!13
         } //if start
   

  } // loop
  
  void SendDataBase(String Sensor, int Value,String Username){
     Serial.println("Client connect");
      if (client.connect(IPAddress(54,72,0,171),80))// IP del servidor/puerto
        {
          Serial.println("Client connected");
          client.print("GET /arduino.php?id=");
          client.print(Username);
          client.print("&sensor=");
          client.print(Sensor);
          client.print("&value=");
          client.print(Value);
          client.println(" HTTP/1.0");
          client.println();
          Serial.println("Client disconnect");
          client.stop();
        }
      else
        Serial.println("Client connect failed");
} 
  

