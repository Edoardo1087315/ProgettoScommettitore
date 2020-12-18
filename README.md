# Progetto Spring
In questo repository troverai il progetto di programmazione ad oggetti A.A. 2019/2020 svolto dal gruppo composto da 

Edoardo Bilancia & Emanuele Biccheri.

Corso in Ingegneria informatica e dell'automazione presso l'[Università Politecnica delle Marche](https://www.univpm.it).

## Introduzione

Il progetto in questione è stato sviluppato mediante l'utilizzo del framework Spring.

Grazie all'utilizzo di questo framework è stata sviluppata l'applicazione web-based **"scommettitoreApp"** che può essere interrogata dall'utente mediante richieste
di tipo GET/POST. L'applicativo si occupa di comunicare con le API del sito [Currencylayer](www.currencylayer.com), il quale restituirà i dati in formato JSON che saranno
poi modellizzati e adattati al tipo di richiesta dell'utente restituendo i dati in formato JSON.

[Currencylayer](www.currencylayer.com) è un sito che colleziona informazioni riguardanti 168 valute mondiali dal 2001, e mette a disposizione tramite API l'accesso a questi dati. 

E' necessario sottoscrivere un abbonamento al sito che permette, attraverso una chiave di accesso, di accedere al servizio. Nel nostro caso abbiamo utilizzato la versione gratuita che permette un numero limitato di accessi e di funzioni, nello specifico non vi è la possibilità di modificare la valuta di riferimento "USD".

## Come funziona?

Dopo aver avviato l'applicazione sarà possibile interrogarla attraverso richieste HTTP all'indirizzo http://localhost:8080.

![Image of CaseDiagram](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreUseCase.jpg)

Come descritto dal diagramma dei casi d'uso, le richieste possibli da parte dell'utente sono diverse e riassunte in breve di seguito.


Tipo | Path | Parametri | Informazioni restituite
-----|------|-----------|--------------------------------------
GET | /currencies | - | Restituisce l'elenco delle valute disponibili
GET | /currencies/metadata | - | Restituisce i metadata
GET | /currencies/statistics | from, to, currencies | Restituisce le statistiche relative alle valute richiete 
POST | /currencies/filters | from, to, currencies | Restituisce le valute filtrate come richiesto
GET | /currencies/chart | from, to, currencies | Restituisce l'andamento della valuta sul periodo mediante un grafico

Alla rotta /currencies/filters la richiesta dovrà essere di tipo POST e andrà inserito il body in formato JSON
per specificare il tipo di filtro richiesto.

### Parametri
I parametri permettono all'utente di effettuare delle richieste specifiche in base alle necessità.

* **from & to**

In particolare i parametri "from" e "to" permettono di specificare il periodo sul quale ottenere le informazioni e devono rispettare 

la seguente sintassi : ```yyyy-mm-dd ```
> - Se non inseriti entrambi allora di default l'applicativo andrà a considerare il periodo che và da ieri ad oggi.
> - Se l'utente inserisce solo il parametro "from" allora di default verrà considerato il periodo che va dalla data inserita ad oggi.
> - Se l'utente inserisce solo il parametro "to" allora verrà restituito un errore.
> - Se l'utente non inserisce la data come da sintassi verrà restituito un errore.
> - Se il prametro "from" contiene una data maggiore o uguale di quella presente nel "to" viene restituito un errore.

* **currencies**

Il parametro "currencies" permette di filtrare le valute e di considerare le informazioni relative solo a quelle inserite.
E' possible specificare più valute elencandole separate dalla virogla.

Un esempio inserendo le valute "EUR" e "AUD" : ```http://......?currencies = EUR,AUD``` 

> -  Se il parametro non viene inserito l'applicativo non andrà a considerare il filtro e restituirà le informazioni relative a tutte le valute.
> -  Se il parametro contiene solo uno o più valute non valide verrà restituito un errore.
> -  Se il parametro contiene almeno una valuta corretta verranno filtrate tutte quelle valide e ignorate quelle invalide.
> -  Alla rotta "/currencies/chart" il parametro assume un valore di default pari ad "EUR" se non inserito.

- **Esempi**

  - Sintassi non corretta sui parametri "from" e "to" [Es 1](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/datanonesistente.PNG) [Es 2](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/soloto.PNG) [Es 3](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/sintassidateerrate.PNG) [Es 4](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/dateopposte.PNG)

  - Sintassi non corretta sul parametro "currencies" [Es 1](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/currenciespippo.PNG) [Es 2](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/currenciespuntoevirgola.PNG)



### Statistiche

Le statistiche restituite dall'applicativo vengono calcolate al momento della richiesta da parte dell'utente.

Alla rotta /currencies/statistics, oltre ai valori delle valute assunti sul periodo vengono restituite le seguenti statistiche per ogni valuta:

* Media, *valore medio della valuta sul periodo indicato*
* Varianza, *valore della varianza della valuta sul periodo indicato*
* Deviazione standard,  *valore della deviazione standard della valuta sul periodo indicato (indice di volatilità)*
* Variazione percentuale,  *valore della varizione percentuale della valuta sul periodo indicato*
* Variazioni percentuali giornaliere,  *valori della variazioni percentuali giornaliere della valuta sul periodo indicato*

**NOTA:** I valori restituiti saranno ordinati dal meno recente al più recente.

- **Esempi**
  - esempi sulle statistiche [Es 1](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/esempio1statistiche.PNG) [Es 2](https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/images/esempio2statistiche.PNG)

### Filtri

A disposizione dell'utente è presente la possibilità di richiedere, su un dato periodo, le valute che risultano più o meno costanti a seconda della richiesta.
Alla rotta "/currencies/filters" è richiesto all'utente di specificare un body secondo la seguente sintassi:
```{"metodo" : valore}```
dove il campo "metodo" deve essere: 
* "best", *se l'utente vuole ottenere le più costanti sul periodo*
* "worst", *se l'utente vuole ottenere le meno costanti sul periodo* 

Il campo "valore" corrisponde alla quantità di valute che l'utente vuole filtrare.

Oltre al nome delle valute l'applicativo restituisce l'indice di volatilità relativo ad ogni valuta filtrata, utile in secondo luogo per delle analisi di mercato.

Se l'utente inserisce i due filtri contemporaneamente otterrà una lista unica in cui saranno presenti le valute filtrate nell'ordine con cui sono stati indicati nel body.
La sintassi per utilizzare i due filtri contemporaneamente è:
```{"metodo" : valore, "metodo" : valore}``` 

Viene restituito un errore nei seguenti casi:
> - Se l'utente inserisce un metodo non presente.
> - Se l'utente inserisce un valore negativo o nullo.
> - Se l'utente inserisce un valore maggiore di quello delle valute richieste.
> - Se la sintassi non è corretta.


### Grafico 

Un ulteriore servizio fornito dall'applicativo è la possibilità di consultare un grafico relativo all'andamento della valuta sul periodo;
 l'utente può scegliere quale valuta visualizzare nel grafico, potendone scegliere anche più di una.

Nonostante ciò è consigliato inserire una valuta per volta affinchè la risoluzione del grafico risulti sufficientemente valida.


## Sviluppo

### Package

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreAppPackage.jpg"  width="600" />

### Classi

#### currency.scomettitoreApp.controller

Classe che si occupa di gestire le richieste dell'utente ed eventuali eccezioni.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassController.jpg"  width="700" />


#### currency.scomettitoreApp.service

La classe PrincipalService si occupa di smistare le richieste del controller.

La classe DateService si occupa di fornire dei metodi per la gestione delle date, quali ad esempio la verifica e il parsing da stringa a oggetto di tipo Date.

La classe UrlService si occupa di generare il link per le richieste API al sito Currencylayer.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassService.jpg"  width="700" />


#### currency.scomettitoreApp.data

La classe CurrencyLayer si occupa di effettuare la chiamata al sito ed effettua il parsing del JSON restituito.

La classe Currency prende gli elementi parsati di tipo ApiModel (uno per ogni data) e li mette in un vettore.

La classe CreateHashMap costruisce la hashmap e la popola in base alle richieste.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassCurrencylayer.jpg"  width="700" />


#### currency.scomettitoreApp.exceptions

In questo package sono presenti le eccezioni personalizzate.

La classe ExceptionErr fornisce un modello di risposta che contiene le varie informazioni relative all'eccezione che è stata lanciata,
in particolare viene restituito all'utente un messaggio, il timestamp della richiesta, l'eccezione lanciata e un HttpStatus.

Tutte le eccezioni estendono la classe astratta GenericError.

L'eccezione DateException viene lanciata quando la data eccede o e uguale alla data di fine.

L'eccezione UrlException viene lanciata nel momento in cui il server restituisce un insuccesso a fronte di una richiesta.

L'eccezione AmountException viene lanciata quando il valore inserito nel body risulta essere non positivo oppure maggiore del numero delle valute richieste.


<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassException.jpg"  width="700" />


#### currency.scomettitoreApp.filtersstatistics

Il package filtersstatistics contiene tutte le classi utili a generare statistiche e gestire i filtri inseriti nel body dall'utente al momento della richiesta.

La classe BodyParsing si occupa di effettuare il parsing del filtro inserito dall'utente e richiamare il metodo corretto.

La classe Filter si occupa di filtrare le valute.

La classe Statistics genera tutte le statistiche.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassStatisticsFilters.jpg"  width="700" height="130"/>


#### currency.scomettitoreApp.model

In questo package sono contenuti tutti i modelli utilizzati.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassModel.jpg"  width="700" />


#### currency.scomettitoreApp.plot

La classe Chart utilizza la libreria jfreeChart che mette a disposizione del developer una serie di metodi che permettono la creazione di un
grafico da un dataset di valori.

Una volta definito il dataset è possibile generare un grafico ed è possibile personalizzarlo a seconda delle esigenze. Nel nostro caso abbiamo utilizzato un grafico lineare personalizzato, il quale, ad esempio, adatta il range degli assi automaticamente a seconda del dataset.

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreClassChart.jpg"  width="700" />


### Sequenze

* **Chiamata GET /currencies**

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreGetCurrencies.jpg"  width="700" />

* **Chiamata GET /currencies/metadata**

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreGetMetadata.jpg"  width="400" />

* **Chiamata GET /currencies/statistics**

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreGetStatistics.jpg"  width="900" />

* **Chiamata POST /currencies/filters**

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreGetFilters.jpg"  width="900" />

* **Chiamata GET /currencies/chart**

<img src="https://github.com/Edoardo1087315/ProgettoScommettitore/blob/master/UML/ScommettitoreGetChart.jpg"  width="900" />


## Autori

* **Edoardo Bilancia** - [GitHub](https://github.com/Edoardo1087315)
* **Emanuele Biccheri** - [GitHub](https://github.com/Emanuele1087650)

#### Suddivisione del lavoro

Lo sviluppo del progetto è avvenuto per fasi.

In primo luogo abbiamo fatto una stesura del codice UML per concretizzare le idee di entrambi.

Abbiamo poi lavorato insieme tramite videochiamate con condivisione dello schermo per ragionare sulla possibile implementazione del codice,
in particolar modo sulle parti più complesse ci siamo confrontati e abbiamo cercato in rete le possibili soluzioni ai nostri problemi.

Purchè sia capitato di lavorare individualmente al progetto, ogni modifica a quest'utlimo è stata sottoposta alla revisione dell'altro per 
garantire un risultato migliore.

