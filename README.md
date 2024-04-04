<h1>Titolo dell'esercitazione: Creazione di un'applicazione di gestione di una libreria con Spring(Three-Tier)</h1>

**Obiettivo:** Creare un'applicazione Spring Boot che gestisca una libreria con un'architettura a tre
livelli (Controller, Service, Repository) e implementi una logica di business per la gestione dei libri
e delle copie dei libri.

**Descrizione:** Il tuo compito è creare un'applicazione Java basata su Spring con un'architettura a tre
livelli che consente di gestire una libreria. In questa applicazione, dovrai implementare una logica di
business che consenta di aggiungere libri, aggiungere copie di libri, prestare e restituire copie,
elencare i libri disponibili e molto altro.

<h3>Requisiti dell'applicazione:</h3>

**Strato di Controller (Controller Layer):**

1. Implementa un controller LibroController che si occupa di gestire le richieste HTTP
relative ai libri e alle copie dei libri. Collega le richieste in arrivo ai metodi del servizio per
eseguire le operazioni specifiche.

2. Espone le seguenti API:
- POST /libri: Per aggiungere un nuovo libro alla libreria.
- POST /libri/{libroId}/copie: Per aggiungere una copia di un libro esistente.
- PUT /libri/copie/{copiaId}/prestito: Per registrare una copia in prestito.
- PUT /libri/copie/{copiaId}/restituzione: Per registrare la restituzione di una copia.
- GET /libri: Per ottenere un elenco di tutti i libri nella libreria.
- GET /libri/copie/disponibili: Per ottenere un elenco di copie disponibili.
  
**Strato di Servizio (Service Layer):**
1. aggiungiLibro
- Passo 1: Ricevi i parametri titolo, autore e annoPubblicazione per il nuovo libro.
- Passo 2: Crea una nuova istanza di Libro con i parametri forniti.
- Passo 3: Salva il nuovo libro nel repository dei libri utilizzando il LibroRepository.
- Passo 4: Restituisci il libro appena creato.
2. aggiungiCopiaLibro
- Passo 1: Ricevi il parametro libroId che identifica il libro esistente a cui aggiungere una copia.
- Passo 2: Cerca il libro con libroId nel repository dei libri utilizzando il LibroRepository.
- Passo 3: Crea una nuova istanza di CopiaLibro collegata al libro trovato.
- Passo 4: Salva la nuova copia del libro nel repository delle copie dei libri utilizzando il CopiaLibroRepository.
- Passo 5: Restituisci la copia del libro appena creata.
3. prendiInPrestitoCopiaLibro
- Passo 1: Ricevi il parametro copiaId che identifica la copia del libro da registrare come "in prestito".
- Passo 2: Cerca la copia del libro con copiaId nel repository delle copie dei libri utilizzando il CopiaLibroRepository.
- Passo 3: Imposta lo stato della copia come "in prestito".
- Passo 4: Salva la copia del libro aggiornata nel repository delle copie dei libri utilizzando il CopiaLibroRepository.
4. restituisciCopiaLibro
- Passo 1: Ricevi il parametro copiaId che identifica la copia del libro da registrare come "restituita".
- Passo 2: Cerca la copia del libro con copiaId nel repository delle copie dei libri utilizzando il CopiaLibroRepository.
- Passo 3: Imposta lo stato della copia come "restituita".
- Passo 4: Salva la copia del libro aggiornata nel repository delle copie dei libri utilizzando il CopiaLibroRepository.
5. elencoLibri
- Passo 1: Utilizza il LibroRepository per ottenere un elenco di tutti i libri presenti nella libreria.
- Passo 2: Restituisci l'elenco di libri.
6. numeroCopieDisponibili
- Passo 1: Ricevi il parametro libroId che identifica il libro per cui calcolare il numero di copie disponibili.
- Passo 2: Cerca il libro con libroId nel repository dei libri utilizzando il LibroRepository.
- Passo 3: Utilizza il CopiaLibroRepository per contare il numero di copie disponibili per il libro trovato.
- Passo 4: Restituisci il numero di copie disponibili.
Questi step dettagliati descrivono come implementare la logica di business per ciascun metodo nel
servizio LibroService. Assicurati di gestire le eccezioni e le situazioni di errore in modo
appropriato durante l'implementazione.

**Strato di Repository (Data Access Layer):**

Crea un repository LibroRepository per gestire la
persistenza dei dati dei libri. Questo repository dovrebbe consentire operazioni CRUD (Create,
Read, Update, Delete) sui libri.

Crea un repository CopiaLibroRepository per gestire la persistenza dei dati delle copie dei
libri. Questo repository dovrebbe consentire operazioni di accesso e ricerca.

**Configurazione del Database:**

Configura il tuo database preferito (ad esempio, MySQL o H2)
nelle proprietà dell'applicazione per garantire la persistenza dei dati.

**Ulteriori Miglioramenti (opzionale):**

Aggiungi ulteriori funzionalità come la gestione degli
utenti, la generazione di report, la ricerca avanzata di libri, la gestione dei prestiti, l'autenticazione,
l'autorizzazione, la documentazione delle API con Swagger, i test unitari, ecc.

**Note:** Assicurati di seguire le best practices di sviluppo Spring durante l'implementazione. Puoi
ampliare ulteriormente l'applicazione in base alle tue esigenze e competenze.









