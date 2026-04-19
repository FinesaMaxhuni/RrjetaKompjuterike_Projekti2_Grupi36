# RrjetaKompjuterike_Projekti2_Grupi36
Përshkrimi i Projektit

Ky projekt implementon një sistem client-server duke përdorur Java sockets, ku serveri menaxhon shumë klientë njëkohësisht dhe ofron funksionalitete për menaxhimin e file-ve dhe komunikimin mes tyre.
Çdo klient që lidhet me serverin mund të dërgojë komanda ose mesazhe tekstuale, ndërsa serveri i lexon, i ruan dhe i përpunon ato sipas funksionalitetit të implementuar. Për të siguruar kontroll më të mirë, klientët ndahen në role të ndryshme (admin dhe user), ku secili rol ka nivele të ndryshme qasjeje. Përdoruesit normal kanë mundësi kryesisht për lexim, ndërsa admini ka privilegje të plota për menaxhimin e file-ve në server, si krijimi, fshirja apo ngarkimi i tyre.
Projekti përdor TCP socket për komunikim të besueshëm dhe përfshin gjithashtu një HTTP server të thjeshtë, i cili funksionon paralelisht dhe shërben për monitorimin e serverit përmes statistikave si numri i klientëve aktivë, IP adresat dhe mesazhet e dërguara.

