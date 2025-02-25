# TicketGuru
Tiimi: Artturi Haavisto, Veera Heikkinen, Eetu Pärnänen, Riku Roivanen, Carolina Woodfine


## Johdanto
TicketGuru on lipunmyyntijärjestelmä, joka on suunniteltu helpottamaan tapahtumalippujen myyntiä ja hallintaa. Järjestelmän tilaajana on lipputoimisto, joka myy lippuja myyntipisteissään ja tapahtumien ovella.
 Järjestelmän avulla lipunmyyjät voivat myydä ja tulostaa lippuja asiakkaille, ja ovimyyjät voivat tarkistaa ja merkitä liput käytetyiksi sisäänpääsyssä.  

### **Tavoitteet ja käyttäjät**
Järjestelmän keskeiset käyttäjät ovat:
- **Lipunmyyjät**, jotka myyvät ja tulostavat lippuja asiakkaille.
- **Ovimyyjät**, jotka tarkastavat liput, myyvät yli jääneitä lippuja ja hallinnoivat sisäänpääsyä.
- **Admin-käyttäjät**, jotka hallinnoivat tapahtumia ja käyttäjäoikeuksia yms.
- **Asiakkaat**, jotka ostavat lippuja ja käyttävät niitä tapahtumiin pääsyssä.

Järjestelmän perustoimintoja on:
- Tapahtumien hallinta
- Lippujen myynti ja tulostus
- Ovimyyntien hallinta ja lipputarkastus
- Myyntiraporttien tarkastelu

### **Teknologiat ja toteutusympäristö**
Projektissa käytetään seuraavia teknologioita:

- **Backend:** Java + Spring Boot
- **REST API:** CRUD-toiminnot lippujen ja tapahtumien hallintaan.
- **Frontend** Web-pohjainen käyttöliittymä. Esimerkiksi react/thymeleaf/JavaScript.
- **Päälaitteet** Desktop selainpohjainen käyttöliittymä lipunmyyjille, mobiililaite optimoitu näkymä?

### **Projektin lopputulos**
Projektin valmistuttua TicketGuru järjestelmä sisältää ainakin seuraavat toiminnallisuudet:
- Lipunmyynti ja tulostus myyntipisteessä.
- Ovimyyntien hallinta ja lipuntarkistus.
- Käyttäjähallinta ja oikeuksien määrittely.
- Myyntitietojen ja tapahtumien hallinta admin-käyttäjille.

Jatkossa järjestelmään voidaan lisätä verkkokauppa.

# **Järjestelmän määrittely**

## **Käyttäjäryhmät ja käyttäjätarinat**  

### **Lipunmyyjä**  
- *Lipunmyyjänä* voin lisätä järjestelmään uusia tapahtumia, jotta voin myydä niihin lippuja asiakkaille.  
- *Lipunmyyjänä* voin muokata tapahtuman tietoja, jotta voin hallinnoida tapahtuman mahdollisia muutoksia.  
- *Lipunmyyjänä* haluan myydä lippuja, jotta yrityksemme saa liikevaihtoa.  
- *Lipunmyyjänä* haluan tulostaa lipun asiakkaalle, jotta asiakas pääsee tapahtumaan helposti.  
- *Lipunmyyjänä* haluan pystyä käsittelemään lippujen peruutuksia, jotta voin palauttaa asiakkaan rahat ja päivittää lipun tilan järjestelmään.  
- *Lipunmyyjänä* haluan nähdä myyntihistorian.  
- *Lipunmyyjänä* haluan nähdä jäljellä olevien lippujen määrän.  

### **Ovimyyjä**  
- *Ovimyyjänä* haluan saada lipun ja tapahtuman tiedot esiin.  
- *Ovimyyjänä* haluan tulostaa jäljelle jääneet liput, jotta voin myydä ne ovella.  
- *Ovimyyjänä* pystyn tarkistamaan lipun siinä olevasta koodista ja merkitsemään sen käytetyksi.  

### **Admin**  
- *Adminina* voin lisätä järjestelmään uusia tapahtumia, jotta voin myydä niihin lippuja asiakkaille.  
- *Adminina* voin muokata tapahtuman tietoja, jotta voin hallinnoida tapahtuman mahdollisia muutoksia.  
- *Adminina* haluan oikeudet tarkastella ylläpitotehtäviä varten tärkeitä asiakastietoja GDPR:ää noudattaen.  
- *Adminina* haluan pystyä käsittelemään lippujen peruutuksia, jotta voin palauttaa asiakkaan rahat ja päivittää lipun tilan järjestelmään.  
- *Adminina* haluan nähdä myyntihistorian.  
- *Adminina* haluan muokata lipputyyppejä, koska niitä voi olla erilaisia eri tapahtumissa.  


## Käyttöliittymät
Linkki käyttöliittymän näkymiin: https://www.figma.com/design/zVIZzCBoQg3RqEqrGYyHpp/TicketGuru?node-id=0-1&t=rLzlFhLt2YrBquWw-1





## Tietokanta

**Paikka kaaviolle**



### **Tietohakemisto**

## SalesTransaction-taulu
| Kenttä              | Tyyppi       | Kuvaus                             |
|---------------------|-------------|-----------------------------------|
| transactionId       | int PK       | Myyntitapahtuman yksilöllinen ID        |
| customerId          | int FK       | Viittaus Customer-tauluun          |
| paymentId           | int FK       | Viittaus Payment-tauluun            |
| transactionTime     | datetime     | Myyntitapahtuman päivämäärä       |

## Customer-taulu
| Kenttä        | Tyyppi       | Kuvaus                           |
|--------------|-------------|---------------------------------|
| customerId   | int PK       | Asiakkaan yksilöllinen ID       |
| firstName      | varchar(50)  | Asiakkaan etunimi              |
| lastName     | varchar(50)  | Asiakkaan sukunimi             |
| streetAddress   | varchar(50)  | Asiakkaan osoite               |
| postalcode  | char(5)      | Viittaus Postalcode-tauluun   |
| email        | varchar(50)  | Asiakkaan sähköpostiosoite     |
| phoneNumber | varchar(20) | Asiakkaan puhelinnumero        |

## Payment-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| paymentId      | int PK       | Maksun yksilöllinen ID           |
| salesTransactionId | int FK  | Viittaus SalesTransaction-tauluun |
| paymentMethod     | varchar(50)  | Maksun tapa                     |
| paymentStatus    | varchar(50)  | Maksun tila                     |
| paymentTime      | datetime     | Maksun päivämäärä               |
| paymentAmount         | double       | Maksun summa                     |

## Event-taulu
| Kenttä              | Tyyppi       | Kuvaus                             |
|---------------------|-------------|-----------------------------------|
| eventId       | int PK       | Tapahtuman yksilöllinen ID        |
| name          | varchar(100)       | Tapahtuman nimi          |
| description           | varchar(500)       | Tapahtuman kuvaus            |
| startTime     | datetime     | Tapahtuman alkuaika       |
| endTime              | datetime       | Tapahtuman loppuaika                             |
| locationId              | int FK       | Viittaus location-tauluun                             |
| ticketCount              | int       | Myytävien lippujen määrä                             |

## Location-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| locationId      | int PK       | Tapahtumapaikan yksilöllinen ID           |
| name | varchar(100) | Tapahtumapaikan nimi |
| streetAddress     | varchar(100)  | Tapahtumapaikan osoite                     |
| postalcode    | char(5)  | Viittaus Postalcode-tauluun                     |
| capacity      | int     | Tapahtumapaikan henkilöpaikkojen määrä               |

## Postalcode-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| postalcode      | char(5) PK       | Postinumero           |
| city | varchar(150)  | Kaupunki |
| country     | varchar(50)  | Maa                     |

## Ticket-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| ticketId     | int PK       | Lipun yksilöllinen ID           |
| ticketTypeId | int FK  | Viittaus TicketType-tauluun |
| eventId     | int FK  | Viittaus Event-tauluun                 |
| ticketUsed    | boolean | Kertoo, onko lippu käytetty vai ei                 |

## Ticket-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| ticketTypeId | int PK  | Lipputyypin yksilöllinen ID |
| ticketType     | varchar(50)  | Lipputyypin nimi                |

## EventTicketTypes-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| ticketTypeId   | int PK | Lipputyypin yksilöllinen ID |
| eventId     | int PK | Tapahtuman yksilöllinen ID |
| price        | int   | Tapahtumaan sidotun lipputyypin hinta |


