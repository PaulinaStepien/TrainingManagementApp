Personal Training Management

Personal Training Management to system zarządzania treningami personalnymi. Pozwala na tworzenie subskrypcji, zarządzanie trenerami oraz planowanie i zarządzanie treningami.

Spis treści:
1. Technologie
2. Uruchomienie
3. Endpointy
4. Technologie

Projekt został zrealizowany przy użyciu następujących technologii:
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
Mave

Uruchomienie
Aby uruchomić projekt, wykonaj następujące kroki:

Sklonuj repozytorium na swoje urządzenie:
bash
Copy code
git clone https://github.com/twoje-repozytorium.git
Przejdź do katalogu projektu:

bash
Copy code
cd personal-training-management
Skonfiguruj połączenie do bazy danych w pliku application.properties.

Uruchom aplikację przy użyciu Maven:

bash
Copy code
mvn spring-boot:run
Po wykonaniu powyższych kroków, aplikacja powinna być dostępna pod adresem http://localhost:8080.

Endpointy
Poniżej znajduje się lista dostępnych endpointów:
USER
getAllUsers – pobiera wszystkich użytkowników z bazy
createUser – tworzy użytkownika o unikatowym id w bazie danych – dane sprawdzane są zgodnie z walidacją klasy User
updateUser – aktualizuje istniejącego użytkownika – dane sprawdzane są zgodnie z walidacją klasy User
deleteUser – usuwa istniejącego użytkownika z bazy danych
getUser – pobiera użytkownika po Id
getUserByPhoneNumber - pobiera użytkownika po numerze telefonu
getUserByEmail - pobiera użytkownika po mailu


TRAINER
getAllTrainers – pobiera wszystkich użytkowników z bazy
createTrainer – tworzy trenera o unikatowym id w bazie danych – dane sprawdzane są zgodnie z walidacją klasy Trainer
updateTrainer – aktualizuje istniejącego trenera – dane sprawdzane są zgodnie z walidacją klasy Trainer
deleteTrainer – usuwa istniejącego trenera z bazy danych
getTrainerById - pobiera trenera po Id
getTrainerByEmail - - pobiera użytkownika po mailu


TRAINING
createTraining – tworzy trening
updateTraining - aktualizuje istniejący trening
deleteTraining – usuwa trening
getTraining – pobiera trening po Id
getReservedTrainingsForUser – pobiera treningi o statusie aktywny dla danego użytkownika
getReservedTrainingsForTrainer - pobiera treningi o statusie zarezerwowany dla danego trenera
getActiveTrainingsForTrainer - pobiera treningi o statusie aktywny dla danego trenera

SUBSCRIPTION
createSubscription – tworzy subskrypcję dla użytkownika
getSubscriptionById – pobiera dane subskrypcji 
