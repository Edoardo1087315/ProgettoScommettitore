# Progetto Spring
In questo repository troverai il progetto di programmazione ad oggetti A.A. 2019/2020 svolto dal gruppo composto da 
- Edoardo Bilancia & Emanuele Biccheri.

Corso in ingegneria informatica e dell'automazione presso l'[Università Politecnica delle Marche](https://www.univpm.it).

## Introduzione

il progetto in questione è stato sviluppato mediante l'utilizzo del framework Spring.

grazie all'utilizzo di questo framework è stata sviluppata l'applicazione web-based **"scommettitoreApp"** che può essere interrogata dall'utente mediante richieste
di tipo GET/POST. l'applicativo si occupa di interrogare le API dal sito [Currencylayer](www.currencylayer.com) il quale restituira i dati in formato JSON che saranno
poi modellizzati e adattati al tipo di richiesta dell'utente restituendo i dati in formato JSON.

[Currencylayer](www.currencylayer.com) è un sito collezziona informazioni riguardanti 168 valute mondiali dal 2001, e mette a disposizione tramite un sevizio API l'accesso a questi dati.

## come funziona?

![Image of CaseDiagram](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreUseCase.jpg)

Dopo aver avviato l'applicazione, sarà possibile interrogarla attraverso richieste HTTP all'indirizzo http://localhost:8080.

le richieste gestite sono 5

Tipo | path | parametri | informazioni restituite
-----|------|-----------|--------------------------------------
GET | /currencies | - | restituisce l'elenco delle valute disponibili
GET | /currencies/metadata | - | restituisce i metadata
GET | /currencies/statistics | from, to, currencies | restituisce le statistiche relative alle valute richiete nel periodo inserito
POST | /currencies/filters | from, to, currencies, body | restituisce le valute filtrate come richiesto
GET | /currencies/chart | from, to, currencies | restituisce l'andamento della valuta sul periodo attraverso un grafico
