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

