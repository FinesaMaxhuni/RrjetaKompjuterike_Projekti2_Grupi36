# RrjetaKompjuterike_Projekti2_Grupi36
Përshkrimi i Projektit
------------------------------------------------------------------------------------------------------
Ky projekt implementon një sistem client-server duke përdorur Java sockets, ku serveri menaxhon shumë klientë njëkohësisht dhe ofron funksionalitete për menaxhimin e file-ve dhe komunikimin mes tyre.
Çdo klient që lidhet me serverin mund të dërgojë komanda ose mesazhe tekstuale, ndërsa serveri i lexon, i ruan dhe i përpunon ato sipas funksionalitetit të implementuar. Për të siguruar kontroll më të mirë, klientët ndahen në role të ndryshme (admin dhe user), ku secili rol ka nivele të ndryshme qasjeje. Përdoruesit normal kanë mundësi kryesisht për lexim, ndërsa admini ka privilegje të plota për menaxhimin e file-ve në server, si krijimi, fshirja apo ngarkimi i tyre.
Projekti përdor TCP socket për komunikim të besueshëm dhe përfshin gjithashtu një HTTP server të thjeshtë, i cili funksionon paralelisht dhe shërben për monitorimin e serverit përmes statistikave si numri i klientëve aktivë, IP adresat dhe mesazhet e dërguara.

Qëllimi i Projektit
------------------------------------------------------------------------------------------------------
Qëllimi i këtij projekti është të kuptohet dhe të implementohet në praktikë komunikimi në rrjet përmes modelit client-server, duke përdorur protokollin TCP. Gjithashtu, projekti demonstron përdorimin e multi-threading, menaxhimin e lidhjeve të shumëfishta dhe kontrollin e qasjes përmes roleve të ndryshme të përdoruesve.

Funksionalitetet kryesore:
1. Komunikim client-server përmes TCP
2. Mbështetje për shumë klientë njëkohësisht (multi-threading)
3. Menaxhim i roleve (admin dhe user)
4. Ekzekutimi i komandave për file system, ejt.
5.Monitorim i serverit përmes statistikave (numri i klientëve, kërkesave dhe statusi i serverit)

Komponentët Kryesor
------------------------------------------------------------------------------------------------------
Server.java(Serveri kryesor i aplikacionit)
- Hap një ServerSocket
- Pret lidhje nga klientët
- Kufizon numrin maksimal të klientëve
- Krijon thread për secilin klient

Client.java
Klienti i aplikacionit:
- Lidhet me serverin
- Dërgon kërkesa
- Merr përgjigje nga serveri

Clienthandler.java
Menaxhon komunikimin me një klient:
- Lexon mesazhet nga klienti
- Përpunon kërkesat
- Dërgon përgjigje

httpstateserver.java
- Shfaq numrin e klientëve aktivë
- Shfaq kërkesat e përpunuara
- Monitoron aktivitetin e serverit

Teknologjitë e përdorura
------------------------------------------------------------------------------------------------------
- Java
- Socket Programming
- Multithreading
- HTTP Server (bazik)
- IntelliJ IDEA
- Git & GitHub

Struktura e Projektit
------------------------------------------------------------------------------------------------------
```
RrjetaKompjuterike_Projekti2_Grupi26
├── src
│   ├── Client.java
│   ├── Server.java
│   ├── ClientHandler.java
│   └── HttpStatsServer.java
├── .idea
├── server_files
├── lib
└── README.md
```


Si te ekzekutohet projekti
------------------------------------------------------------------------------------------------------
1. Klono repository-n:
  git clone https://github.com/FinesaMaxhuni/RrjetaKompjuterike_Projekti2_Grupi36.git
2.	Hape folderin e projektit ne IntelliJ IDEA/VSCode (Cfarëdo editori që përkrah gjuhën programuese Java)
3.	Zgjedh file-in dhe ekzekutojeni atë


