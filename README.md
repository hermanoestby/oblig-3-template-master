# Obligatorisk oppgave 3 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende student:
* Herman Østby, S362120, s362120@oslomet.no


# Oppgavebeskrivelse

I oppgave 1 så gikk jeg frem ved å kopiere inn programkoden gitt i oppgaven. 
Deretter lager jeg en ny node med foreldrepeker q. Sjekker her om q er null, dersom dette stemmer
så er p rotnoden. Finner så hvilket side barnet skal være på. 

Oppgave 2 løste jeg ved å først sjekke om verdien  vi ser etter er null.
Deretter lager jeg hjelpevariabel antall. Så lager jeg en rotnode n.
Så benytter jeg meg av en While løkke. I denne sammenliknes verdien vi har
med nodens verdi. Ut ifra dette så bestemmes om det skal være høyre eller venstre barn.

I oppgave 3 sjekker jeg her om noden har venstre barn. Hvis den ikke
har det så sjekker jeg om høyre har barn. Deretter forsetter jeg med dette frem til
jeg har nådd nederst til venstra da dette er første node i postorden.
I nestePostorden følger jeg stegene i kompendiet for å finne neste node i postorden. 

Løser oppgave 4 ved å følge stegene i oppgaveteksten. 
Oppretter en node, og kaller på metodene  og utfører oppgaven. 
Dette bruker jeg en while løkke til frem til jeg har nådd rotnoden.
I den recursive metoden så kaller jeg metoden på seg selv med høyre/venstre barn.
Utfører opppgaven etter de revursive kallene siden det er postorden. 