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

Tworzenie subskrypcji

POST /subscriptions

Tworzy nową subskrypcję na podstawie przekazanych danych subskrypcji.

Pobieranie subskrypcji

GET /subscriptions/{subscriptionId}

Pobiera subskrypcję o podanym identyfikatorze.

Tworzenie trenera

POST /trainers

Tworzy nowego trenera na podstawie przekazanych danych trenera.

Aktualizacja trenera

PUT /trainers/{trainerId}

Aktualizuje dane trenera o podanym identyfikatorze.

Usuwanie trenera

DELETE /trainers/{trainerId}

Usuwa trenera o podanym identyfikatorze.

Pobieranie trenera

GET /trainers/{trainerId}

Pobiera trenera o podanym identyfikatorze.

Pobieranie wszystkich trenerów

GET /trainers/allTrainers

Pobiera listę wszystkich trenerów.

Tworzenie treningu

POST /trainings

Tworzy nowy trening na podstawie przekazanych danych treningu.

Aktualizacja treningu

PUT /trainings/{trainingId}

Aktualizuje dane treningu o podanym identyfikatorze.

Usuwanie treningu

DELETE /trainings/{trainingId}

Usuwa trening o podanym identyfikatorze.

Pobieranie treningu

GET /trainings/byId/{trainingId}

Pobiera trening o podanym identyfikatorze.

