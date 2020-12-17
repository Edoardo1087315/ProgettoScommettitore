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

Dopo aver avviato l'applicazione, sarà possibile interrogarla attraverso richieste HTTP all'indirizzo http://localhost:8080.

![Image of CaseDiagram](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreUseCase.jpg)

come descritto dal diagramma dei casi d'uso le richieste possibli da parte dell'utente sono diverse e riassunte in breve di seguito.


Tipo | path | parametri | informazioni restituite
-----|------|-----------|--------------------------------------
GET | /currencies | - | restituisce l'elenco delle valute disponibili
GET | /currencies/metadata | - | restituisce i metadata
GET | /currencies/statistics | from, to, currencies | restituisce le statistiche relative alle valute richiete 
POST | /currencies/filters | from, to, currencies | restituisce le valute filtrate come richiesto
GET | /currencies/chart | from, to, currencies | restituisce l'andamento della valuta sul periodo mediante un grafico

alla rotta /currencies/filters la richiesta dovrà essere di tipo POST e andrà inserito il body in formato JSON
per specificare il tipo di filtro richiesto.

### i parametri
i parametri permettono all'utente di effettuare delle richieste specifiche in base alle necessità.

* **from & to**

in particolare i parametri from & to permettono di specificare il periodo sul quale ottenere le informazioni e vanno inseriti 

secondo la seguente sintassi : ```yyyy-mm-dd ```
> - se non inseriti entrambi allora di default l'applicativo andrà a considerare il periodo che và da ieri ad oggi.
> - se l'utente inserisce solo il parametro "from" allora di default verrà considerato il periodo che va dalla data inserita ad oggi.
> - se l'utente inserisce solo il parametro "to" allora verrà restituito un errore.
> - se l'utente non inserisce la data come da sintassi verrà restituito un errore.
> - se il prametro "from" contiene una data maggiore o uguale di quella presente nel to viene restituito un errore.

* **currencies**

il parametro "currencies" permette di filtrare le valute e di considerare le informazioni relative solo a quelle inserite.
E' possible specificare più valute elencandole separate da virogla.

un esempio inserendo le valute EUR e AUD : ```http://......?currencies = EUR,AUD``` 

> -  se il parametro non viene inserito l'applicativo non andrà a considerare il filtro e restituirà le informazioni relative a tutte le valute.
> -  se il parametro contiene solo uno o più valute non valide verrà restituito un errore.
> -  se il parametro contiene almeno una valuta corretta verranno filtrate tutte quelle valide e ignorate quelle invalide.
> -  alla rotta /currencies/chart il parametro assume un valore di default se non inserito pari ad "EUR".



- **Esempi**

  - sintassi non corretta sui parametri from & to [1](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/datanonesistente.PNG) [2](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/soloto.PNG) [3](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/sintassidateerrate.PNG) [4](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/dateopposte.PNG)

  - sintassi non corretta sul parametro currencies [1](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/currenciespippo.PNG) [2](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/currenciespuntoevirgola.PNG)



###
