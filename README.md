# TicketGuru
Tiimi: Artturi Haavisto, Veera Heikkinen, Eetu Pärnänen, Riku Roivanen

## Sisällysluettelo
- [Johdanto](#johdanto)
- [Järjestelmän määrittely](#järjestelmän-määrittely)
  - [Käyttäjäryhmät ja käyttäjätarinat](#käyttäjäryhmät-ja-käyttäjätarinat)
  - [Käyttöliittymät](#käyttöliittymät)
  - [Tietokanta](#tietokanta)
- [Rajapinta](#rajapinta)
  - [Tapahtuma](#hae-kaikki-tapahtumat)
  - [Myyntitapahtuma](#hae-kaikki-myyntitapahtumat)
  - [Lippu](#hae-kaikki-liput)
- [Tekninen kuvaus](#tekninen-kuvaus)
- [Testaus](#testaus)
- [Asennustiedot](#asennustiedot)
- [Käynnistys- ja käyttöohje](#käynnistys--ja-käyttöohje)

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

![Ohjelmistoprojekti tietokanta](https://github.com/user-attachments/assets/94c26460-4c2a-4013-9ac3-350dbce91c02)



### **Tietohakemisto**


## SalesTransaction-taulu
| Kenttä              | Tyyppi       | Kuvaus                             |
|---------------------|-------------|-----------------------------------|
| transactionId       | int PK       | Myyntitapahtuman yksilöllinen ID        |
| transactionTime     | datetime     | Myyntitapahtuman päivämäärä       |
| sum     | int     | Myyntitapahtuman summa     |

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
| transactionid    | int FK | Myyntitapahtuma, johon lippu kuuluu                 |
| code    | int | Lipun yksilöllinen koodi               |

## TicketType-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| ticketTypeId | int PK  | Lipputyypin yksilöllinen ID |
| ticketType     | varchar(50)  | Lipputyypin nimi                |

## EventTicketTypes-taulu
| Kenttä         | Tyyppi       | Kuvaus                            |
|---------------|-------------|----------------------------------|
| eventTicketTypeId   | int PK | Tapahtumaan sidotun lipputyypin yksilöllinen ID |
| ticketTypeId   | int PK | Lipputyypin yksilöllinen ID |
| eventId     | int PK | Tapahtuman yksilöllinen ID |
| price        | int   | Tapahtumaan sidotun lipputyypin hinta |


## Taulut, joita ei käytössä: 
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

# **Rajapinta**

**base-URL**: https://ticketguru


**Endpointit:**

**Hae kaikki tapahtumat**
GET /api/events

**Hae tapahtuma id:n perusteella**
GET /api/events/{id}

**Luo uusi Tapahtuma**
POST /api/events

**Päivitä koko tapahtuma**
PUT /api/events/{id}

**Päivitä osa tapahtumasta**
PATCH /api/events/{id}

**Poista tapahtuma id:n perusteella**
DELETE /api/events/{id}

## Hae kaikki tapahtumat


**Metodi** : `GET`

**Polku** : `/api/events`

**Polkuparametrit** : -

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : -

**Vastauksen paluukoodi** : `200 OK` 

**Vastauksen sisältö (Response body)**:
```json
[
    {
        "name": "Jalkapallo-ottelu",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
        "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000,
        "eventTicketTypes": [
            {
                "eventTicketTypeId": 1,
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "price": 120.0
            },
            {
                "eventTicketTypeId": 2,
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "price": 150.0
            }
        ],
        "event_Id": 1
    }
]

```
## Hae tapahtuma id:n perusteella


**Metodi** : `GET`

**Polku** : `/api/events/{id}`

**Polkuparametrit** : `{id}`
tapahtuman id

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : -

**Vastauksen paluukoodi** : `200 OK`, `404 Not found`

**Vastauksen sisältö (Response body)**:

```json
    {
        "name": "Jalkapallo-ottelu",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
        "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000,
        "eventTicketTypes": [
            {
                "eventTicketTypeId": 1,
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "price": 120.0
            },
            {
                "eventTicketTypeId": 2,
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "price": 150.0
            }
        ],
        "event_Id": 1
    }

```
# Luo uusi Tapahtuma


**Metodi** : `POST`

**Polku** : `/api/events`

**Polkuparametrit** : -

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : 
```json
{
        "name": "Uusi tapahtuma",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
         "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000
        
    }
```

**Vastauksen paluukoodi** : `201 Created`  

**Vastauksen sisältö (Response body)**: 
```json
{
    "name": "Uusi tapahtuma",
    "description": "Suomen maajoukkueen peli",
    "startTime": "2025-06-15T18:15:00",
    "endTime": "2025-06-15T20:15:00",
    "location": {
        "locationId": 1,
        "name": "Tampere Arena",
        "streetAddress": "Hämeenkatu 30, Tampere",
        "postalcode": {
            "postalcode": "33100",
            "city": "Tampere",
            "country": "Suomi"
        },
        "capacity": 5000
    },
    "ticketCount": 2000,
    "eventTicketTypes": [],
    "event_Id": 6
  }

```

# Päivitä koko tapahtuma


**Metodi** : `PUT`

**Polku** : `/api/events/{id}`

**Polkuparametrit** : {id}
(tapahtuman id)

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : 
```json
{
    "name": "Muokattu tapahtuma",
    "description": "Suomen maajoukkueen peli",
    "startTime": "2025-06-15T18:15:00",
    "endTime": "2025-06-15T20:15:00",
    "location": {
        "locationId": 1,
        "name": "Tampere Arena",
        "streetAddress": "Hämeenkatu 30, Tampere",
        "postalcode": {
            "postalcode": "33100",
            "city": "Tampere",
            "country": "Suomi"
        },
        "capacity": 5000
    },
    "ticketCount": 2000
   
}

```

**Vastauksen paluukoodi** : `200 OK` `404 Not found` 

**Vastauksen sisältö (Response body)**: 
```json
{
    "name": "Muokattu tapahtuma",
    "description": "Suomen maajoukkueen peli",
    "startTime": "2025-06-15T18:15:00",
    "endTime": "2025-06-15T20:15:00",
    "location": {
        "locationId": 1,
        "name": "Tampere Arena",
        "streetAddress": "Hämeenkatu 30, Tampere",
        "postalcode": {
            "postalcode": "33100",
            "city": "Tampere",
            "country": "Suomi"
        },
        "capacity": 5000
    },
    "ticketCount": 2000,
    "eventTicketTypes": [],
    "event_Id": 4
}
```

# Päivitä osa tapahtumasta 


**Metodi** : `PATCH`

**Polku** : `/api/events/{id}`

**Polkuparametrit** : {id}
(tapahtuman id)

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : 
```json
{
    "description": "Vuoden suurin juhlatapahtuma"
  }

```

**Vastauksen paluukoodi** : `200 OK` `404 Not found` 

**Vastauksen sisältö (Response body)**: 
```json
{
    "name": "Muokattu tapahtuma",
    "description": "Vuoden suurin juhlatapahtuma",
    "startTime": "2025-06-15T18:15:00",
    "endTime": "2025-06-15T20:15:00",
    "location": {
        "locationId": 1,
        "name": "Tampere Arena",
        "streetAddress": "Hämeenkatu 30, Tampere",
        "postalcode": {
            "postalcode": "33100",
            "city": "Tampere",
            "country": "Suomi"
        },
        "capacity": 5000
    },
    "ticketCount": 2000,
    "eventTicketTypes": [],
    "event_Id": 4
}
```

# Poista tapahtuma id:n perusteella

**Metodi** : `DELETE`

**Polku** : `/api/events/{id}`

**Polkuparametrit** : {id}
(tapahtuman id)

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : -

**Vastauksen paluukoodi** : `204 No Content` `404 Not Found ` 

**Vastauksen sisältö (Response body)**: -

# Hae kaikki myyntitapahtumat

**Metodi:** `GET`

**Polku:** `/api/sales`

**Polkuparametrit:** -

**Query-parametrit:** -

**Toimintopyynnön sisältö (Request body):** -

**Vastauksen paluukoodi:** `200 OK`

**Vastauksen sisältö (Response body):**
```json
[
      {
        "transactionId": 2,
        "transactionTime": "2025-05-12T12:29:32.278966",
        "sum": 0.0,
        "tickets": [
            {
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "event": {
                    "name": "Jalkapallo-ottelu",
                    "description": "Vuoden suurin juhlatapahtuma",
                    "startTime": "2025-06-15T18:15:00",
                    "endTime": "2025-06-15T20:15:00",
                    "location": {
                        "locationId": 1,
                        "name": "Tampere Arena",
                        "streetAddress": "Hämeenkatu 30, Tampere",
                        "postalcode": {
                            "postalcode": "33100",
                            "city": "Tampere",
                            "country": "Suomi"
                        },
                        "capacity": 5000
                    },
                    "ticketCount": 2000,
                    "eventTicketTypes": [
                        {
                            "eventTicketTypeId": 1,
                            "ticketType": {
                                "ticketTypeId": 1,
                                "ticketType": "Eläkeläinen"
                            },
                            "price": 120.0
                        },
                        {
                            "eventTicketTypeId": 2,
                            "ticketType": {
                                "ticketTypeId": 2,
                                "ticketType": "Opiskelija"
                            },
                            "price": 150.0
                        }
                    ],
                    "endTimeAfterStartTime": true,
                    "event_Id": 1
                },
                "ticketUsed": false,
                "code": "vUobjRhc9v9Mu3xC",
                "ticketId": 3
            },
            {
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "event": {
                    "name": "Jalkapallo-ottelu",
                    "description": "Vuoden suurin juhlatapahtuma",
                    "startTime": "2025-06-15T18:15:00",
                    "endTime": "2025-06-15T20:15:00",
                    "location": {
                        "locationId": 1,
                        "name": "Tampere Arena",
                        "streetAddress": "Hämeenkatu 30, Tampere",
                        "postalcode": {
                            "postalcode": "33100",
                            "city": "Tampere",
                            "country": "Suomi"
                        },
                        "capacity": 5000
                    },
                    "ticketCount": 2000,
                    "eventTicketTypes": [
                        {
                            "eventTicketTypeId": 1,
                            "ticketType": {
                                "ticketTypeId": 1,
                                "ticketType": "Eläkeläinen"
                            },
                            "price": 120.0
                        },
                        {
                            "eventTicketTypeId": 2,
                            "ticketType": {
                                "ticketTypeId": 2,
                                "ticketType": "Opiskelija"
                            },
                            "price": 150.0
                        }
                    ],
                    "endTimeAfterStartTime": true,
                    "event_Id": 1
                },
                "ticketUsed": false,
                "code": "T20EzqI1CPDPNUhh",
                "ticketId": 4
            }
        ]
   }
]
```

# Hae myyntitapahtuma id:n perusteella

**Metodi:** `GET`

**Polku:** `/api/sales/{id}`

**Polkuparametrit:** `{id}` myyntitapahtuman id

**Query-parametrit:** - 

**Toimintopyynnön sisältö (Request body):** -

**Vastauksen paluukoodi:** `200 OK`,`404 Not found`

**Vastauksen sisältö (Response body):**
```json
[
      {
        "transactionId": 2,
        "transactionTime": "2025-05-12T12:29:32.278966",
        "sum": 0.0,
        "tickets": [
            {
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "event": {
                    "name": "Jalkapallo-ottelu",
                    "description": "Vuoden suurin juhlatapahtuma",
                    "startTime": "2025-06-15T18:15:00",
                    "endTime": "2025-06-15T20:15:00",
                    "location": {
                        "locationId": 1,
                        "name": "Tampere Arena",
                        "streetAddress": "Hämeenkatu 30, Tampere",
                        "postalcode": {
                            "postalcode": "33100",
                            "city": "Tampere",
                            "country": "Suomi"
                        },
                        "capacity": 5000
                    },
                    "ticketCount": 2000,
                    "eventTicketTypes": [
                        {
                            "eventTicketTypeId": 1,
                            "ticketType": {
                                "ticketTypeId": 1,
                                "ticketType": "Eläkeläinen"
                            },
                            "price": 120.0
                        },
                        {
                            "eventTicketTypeId": 2,
                            "ticketType": {
                                "ticketTypeId": 2,
                                "ticketType": "Opiskelija"
                            },
                            "price": 150.0
                        }
                    ],
                    "endTimeAfterStartTime": true,
                    "event_Id": 1
                },
                "ticketUsed": false,
                "code": "vUobjRhc9v9Mu3xC",
                "ticketId": 3
            },
            {
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "event": {
                    "name": "Jalkapallo-ottelu",
                    "description": "Vuoden suurin juhlatapahtuma",
                    "startTime": "2025-06-15T18:15:00",
                    "endTime": "2025-06-15T20:15:00",
                    "location": {
                        "locationId": 1,
                        "name": "Tampere Arena",
                        "streetAddress": "Hämeenkatu 30, Tampere",
                        "postalcode": {
                            "postalcode": "33100",
                            "city": "Tampere",
                            "country": "Suomi"
                        },
                        "capacity": 5000
                    },
                    "ticketCount": 2000,
                    "eventTicketTypes": [
                        {
                            "eventTicketTypeId": 1,
                            "ticketType": {
                                "ticketTypeId": 1,
                                "ticketType": "Eläkeläinen"
                            },
                            "price": 120.0
                        },
                        {
                            "eventTicketTypeId": 2,
                            "ticketType": {
                                "ticketTypeId": 2,
                                "ticketType": "Opiskelija"
                            },
                            "price": 150.0
                        }
                    ],
                    "endTimeAfterStartTime": true,
                    "event_Id": 1
                },
                "ticketUsed": false,
                "code": "T20EzqI1CPDPNUhh",
                "ticketId": 4
            }
        ]
   }
]
```

# Luo uusi myyntitapahtuma

**Metodi:** `POST`

**Polku:** `/api/sales/`

**Polkuparametrit:** 

**Query-parametrit:** 

**Toimintopyynnön sisältö (Request body):** 
```json
{
    "tickets": [
        { "eventId": 1, "ticketTypeId": 1, "count":  1},
        { "eventId": 1, "ticketTypeId": 2, "count": 2 }
    ]
}
```

**Vastauksen paluukoodi:** `201 Created`,`404 Not found`, 

**Vastauksen sisältö (Response body):**
```json
{
    "salesTransactionId": 3,
    "ticketIds": [
        6,
        7,
        8
    ],
    "transactionTime": "2025-05-12T12:34:31.5395223"
}
```

# Poista myyntitapahtuma id:n perusteella

**Metodi** : `DELETE`

**Polku** : `/api/saless/{id}`

**Polkuparametrit** : {id}
(myyntitapahtuman id)

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : -

**Vastauksen paluukoodi** : `204 No Content` `404 Not Found ` 

**Vastauksen sisältö (Response body)**: -


# Hae kaikki liput
**Metodi**: `GET`

**Polku**: `/api/tickets`

**Polkuparametrit**: -
  
**Query-parametrit**: -

**Toimintopyynnön sisältö (Request body)**: -

**Vastauksen paluukoodi**: `200 OK` 

**Vastauksen sisältö (Response body)**:
  ```json
  [
    {
        "ticketType": {
            "ticketTypeId": 1,
            "ticketType": "Eläkeläinen"
        },
        "event": {
            "name": "Jalkapallo-ottelu",
            "description": "Suomen maajoukkueen peli",
            "startTime": "2025-06-15T18:15:00",
            "endTime": "2025-06-15T20:15:00",
            "location": {
                "locationId": 1,
                "name": "Tampere Arena",
                "streetAddress": "Hämeenkatu 30, Tampere",
                "postalcode": {
                    "postalcode": "33100",
                    "city": "Tampere",
                    "country": "Suomi"
                },
                "capacity": 5000
            },
            "ticketCount": 2000,
            "eventTicketTypes": [
                {
                    "eventTicketTypeId": 1,
                    "ticketType": {
                        "ticketTypeId": 1,
                        "ticketType": "Eläkeläinen"
                    },
                    "price": 120.0
                },
                {
                    "eventTicketTypeId": 2,
                    "ticketType": {
                        "ticketTypeId": 2,
                        "ticketType": "Opiskelija"
                    },
                    "price": 150.0
                }
            ],
            "endTimeAfterStartTime": true,
            "event_Id": 1
        },
        "ticketUsed": false,
        "code": "CODE12345",
        "ticketId": 1
    }
]
  ```


# Hae lippu id:n perusteella

**Metodi**: `GET`

**Polku**: `/api/tickets/{id}`

**Polkuparametrit**: {id} (pakollinen): Lippu, joka halutaan hakea (lippu-id).
  
**Query-parametrit**: -

**Toimintopyynnön sisältö (Request body)**: -

**Vastauksen paluukoodi**: `200 OK` `404 Not Found`

**Vastauksen sisältö (Response body)**:
  ```json
  {
    "ticketType": {
        "ticketTypeId": 1,
        "ticketType": "Eläkeläinen"
    },
    "event": {
        "name": "Jalkapallo-ottelu",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
        "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000,
        "eventTicketTypes": [
            {
                "eventTicketTypeId": 1,
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "price": 120.0
            },
            {
                "eventTicketTypeId": 2,
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "price": 150.0
            }
        ],
        "endTimeAfterStartTime": true,
        "event_Id": 1
    },
    "ticketUsed": false,
    "code": "CODE12345",
    "ticketId": 1
}
  ```

# Hae lippu koodin perusteella

**Metodi**: `GET`

**Polku**: `/api/tickets?code={code}`

**Polkuparametrit**: -
  
**Query-parametrit**: {code}: lipun yksilöllinen koodi

**Toimintopyynnön sisältö (Request body)**: -

**Vastauksen paluukoodi**: `200 OK` `404 Not Found`

**Vastauksen sisältö (Response body)**:
  ```json
 {
    "ticketType": {
        "ticketTypeId": 1,
        "ticketType": "Eläkeläinen"
    },
    "event": {
        "name": "Jalkapallo-ottelu",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
        "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000,
        "eventTicketTypes": [
            {
                "eventTicketTypeId": 1,
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "price": 120.0
            },
            {
                "eventTicketTypeId": 2,
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "price": 150.0
            }
        ],
        "endTimeAfterStartTime": true,
        "event_Id": 1
    },
    "ticketUsed": true,
    "code": "CODE12345",
    "ticketId": 1
}
  ```


# Tarkista lippu

**Metodi**: `PATCH`

**Polku**: `/api/tickets/check/{id}`

**Polkuparametrit**: {id} (pakollinen): Lippu, jonka käyttöä tarkistetaan (lippu-id).

**Query-parametrit**: -

**Toimintopyynnön sisältö (Request body)**: 
 ```json
{
    "ticketUsed": true
}
  ```

**Vastauksen paluukoodi**: `200 OK`: Lippu on merkitty käytetyksi. `400 Bad Request`: Lippu on jo käytetty. `404 Not Found`: Lippua ei löytynyt annetulla id:llä.

**Vastauksen sisältö (Response body)**:
  ```json
  {
    "ticketType": {
        "ticketTypeId": 2,
        "ticketType": "Opiskelija"
    },
    "event": {
        "name": "Jalkapallo-ottelu",
        "description": "Suomen maajoukkueen peli",
        "startTime": "2025-06-15T18:15:00",
        "endTime": "2025-06-15T20:15:00",
        "location": {
            "locationId": 1,
            "name": "Tampere Arena",
            "streetAddress": "Hämeenkatu 30, Tampere",
            "postalcode": {
                "postalcode": "33100",
                "city": "Tampere",
                "country": "Suomi"
            },
            "capacity": 5000
        },
        "ticketCount": 2000,
        "eventTicketTypes": [
            {
                "eventTicketTypeId": 1,
                "ticketType": {
                    "ticketTypeId": 1,
                    "ticketType": "Eläkeläinen"
                },
                "price": 120.0
            },
            {
                "eventTicketTypeId": 2,
                "ticketType": {
                    "ticketTypeId": 2,
                    "ticketType": "Opiskelija"
                },
                "price": 150.0
            }
        ],
        "endTimeAfterStartTime": true,
        "event_Id": 1
    },
    "ticketUsed": true,
    "code": "CODE67890",
    "ticketId": 2
}
 ```

# Poista lippu id:n perusteella

**Metodi** : `DELETE`

**Polku** : `/api/tickets/{id}`

**Polkuparametrit** : {id}
(lipun id)

**Query-parametrit** : -

**Toimintopyynnön sisältö (Request body)** : -

**Vastauksen paluukoodi** : `204 No Content` `404 Not Found ` 

**Vastauksen sisältö (Response body)**: -


# Tekninen kuvaus

## Järjestelmän komponentit
**Backend**
-	Teknologia: Java Spring Boot
-	Sijainti: Rahti-ympäristö tai lokaali kehitysympäristö
  
**Tietokanta**
-	Teknologia: PostgreSQL tuotannossa ja H2 kehitysvaiheessa
-	Sijainti: Rahti-ympäristö tai lokaali kehitysympäristö

**Frontend**
-	Teknologia: ReactJS
-	Sijainti: lokaalisti
-	Frontend-demoa käytetään myyntitapahtumien luomisen demonstrointiin 



Backend ja frontend ovat yhteydessä HTTP-pyyntöjen ja -vastausten avulla REST-rajapintojen kautta. Backend on yhteydessä tietokantaan ja käsittelee tiedon tallennuksen ja haun JPA:n avulla.


## Turvallisuus
Sovelluksen autentikoinnissa ja autorisoinnissa on hyödynnetty Spring Securitya. Kaikki endpointit on suojattu HTTP Basic-autentikoinnilla ja vaativat tunnistautumista. Autentikoimattomat pyynnöt palauttavat 401 unauthorized -virheilmoituksen. 

Sovellukseen on asetettu kaksi käyttäjää, "admin" ja "user". Salasanat tallennetaan tietokantaan bcrypt-algoritmilla hajautettuina. 
Käyttäjien oikeudet perustuvat rooleihin. Admin-käyttäjällä on enemmän hallinnollisia oikeuksia, kuten oikeus luoda ja poistaa tapahtumia, kun taas user-käyttäjän oikeudet rajoittuvat perustoimintoihin, kuten tietojen hakemiseen ja lipunmyyntiin.

Kehitysvaiheessa CORS on sallittu kaikista lähteistä, jotta mahdollistetaan sujuva front end-kehitys. 

## Testaus
Järjestelmän toimintoja on testattu eri tason testeillä, joilla on varmistettu
järjestelmän kokonaisvaltainen toiminta. Testit sisältävät yksikkötestejä,
integraatiotestejä, sekä end-to-end testejä. Järjestelmän testit löytyvät Test-paketista

**Yksikkötestit:** 
Järjestelmän yksikkötesteillä on testattu entiteettiluokkien toimintaa erillään
muusta järjestelmästä. Erityisesti on keskitytty testaamaan entiteettiluokkien
validointisääntöjä, joilla varmistetaan että entiteettien attribuutit noudattavat
validointilogiikkaa odotetulla tavalla.

**Integraatiotestaus:** 
Järjestelmän integraatiotesteillä on testattu, että järjestelmän repositoriorajapinnat
toimivat yhdessä tietokannan kanssa. Näillä testeillä varmistetaan että järjestelmä
toimii odotetulla tavalla tietokantatasolla.

**End-to-end testaus:** 
Järjestelmän end-to-end testit testaavat koko järjestelmän toimintaa käyttäjän näkökulmasta.
Pääasiassa järjestelmää on end-to-end testattu niin, että järjestelmä toimii kokonaisvaltaisesti
tapahtuman luonnista lipunmyyntiin.


## Asennustiedot

**Kehitysympäristön asennusta varten tarvittavat työkalut:**
- Java 17
- Koodieditori (esim. VSCode)
- Springboot

Kun työkalut on asennettu, projektin voi kloonata github-repositoriosta.
Kehitysympäristössä pitää varmistaa että `spring.profiles.active=dev` joka käyttää h2-tietokantaa testausta varten on aktiivinen `application.properties` tiedostossa.


**Järjestelmän asentaminen tuotantoympäristöön:**

Projektin tuotantoympäristössä ajamista varten tarvittavat asetukset löytyvät `Dockerfile`-tiedostosta. Tuotantoympäristössä pitää varmistaa että `spring.profiles.active=rahti` on aktivoitu.

Järjestelmä käyttää PostgreSQL-tietokantaa, johon yhdistämiseen tarvittavat tiedot löytyvät `application-rahti.properties`-tiedostosta. Kyseisestä tiedostosta löytyvät muuttujat pitää asettaa tuotantoympäristön ympäristömuuttujiin. Tietokannan alustamista varten löytyvät luontilauseet löytyvät `TicketguruDatabase.sql`-tiedostosta. Luontilauseiden yhteydessä tietokantaan ajetaan esimerkkidataa, sekä `user` ja `admin` käyttäjät. Käyttäjiä voi lisätä luomalla uuden käyttäjän `AppUser`-tauluun.


## Käynnistys- ja käyttöohje

https://ticket-guru-git1-ticketguru-1.2.rahtiapp.fi

Kirjautumista varten käytettävät tunnukset ovat `user` ja `admin`


