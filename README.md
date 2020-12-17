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

## Come funziona?

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

### Parametri
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



### Statistiche

Le statistiche restituite dall'applicativo vengono calcolate al momento della richiesta da parte dell'utente.
Alla rotta /currencies/statistics, oltre ai valori delle valute assunti sul periodo vengono restituite le seguenti statistiche per ogni valuta:

* Media, *valore medio della valuta sul periodo indicato*
* Varianza, *valore della varianza della valuta sul periodo indicato*
* Deviazione standard,  *valore della deviazione standard della valuta sul periodo indicato (indice di volatilità)*
* Variazione percentuale,  *valore della varizione percentuale della valuta sul periodo indicato*
* Variazione percentuale giornaliera,  *valori della variazioni percentuali giornaliere della valuta sul periodo indicato*

in particolare i valori restituiti saranno ordinati dal meno recente al più recente 

### Filtri

A disposizione dell'utente è presente la possibilità di richiedere, su un dato periodo, le valute che risultano più o meno costanti a seconda della richiesta.
alla rotta /currencies/filters è richiesto all'utente di specificare un body secondo la seguente sintassi:
```{"metodo" : valore}```
dove il campo "metodo" deve essere: 
* "best", *se l'utente vuole ottenere le più costanti sul periodo*
* "worst", *se l'utente vuole ottenere le meno costanti sul periodo* 

mentre il campo "valore" corrisponde alla quantità di valute che l'utente vuole filtrare.
oltre al nome delle valute l'applicativo restituisce l'indice di volatilità relativo ad ogni valuta filtrata, utile in secondo luogo per delle analisi di mercato.

se l'utente inserisce i due filtri contemporaneamente otterrà una lista unica in cui saranno presenti le valute filtrate nell'ordine con cui sono stati indicati nel body.
la sintassi per utilizzare i due filtri contemporaneamente è:
```{"metodo" : valore, "metodo" : valore}``` 

viene restituito un errore nei seguenti casi:
> - se l'utente inserisce un metodo non presente.
> - se l'utente inserisce un valore negativo o nullo.
> - se l'utente inserisce un valore maggiore di quello delle valute richieste.
> - se la sintassi non è corretta.

### Grafico 

un ulteriore servizio fornito dall'applicativo è la possibilità di consultare un grafico relativo all'andamento della valuta sul periodo
l'utente può scegliere quale valuta visualizzare nel grafico, potendone scegliere anche più di una.
nonostante ciò è consigliato inserire una valuta per volta affinchè la risoluzione del grafico risulti sufficientemente valida.

## Sviluppo

### Package

![image of packages](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreAppPackage.jpg  =500x) 
